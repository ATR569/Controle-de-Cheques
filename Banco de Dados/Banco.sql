DROP DATABASE IF EXISTS controledecheques;

CREATE DATABASE controledecheques;

USE controledecheques;

SET default_storage_engine = INNODB;

CREATE TABLE Endereco(
  id	  integer AUTO_INCREMENT,	
  cep     integer UNIQUE,
  rua     varchar(50) NOT NULL,
  bairro  varchar(30),
  cidade  varchar(30),
  uf      char(2),
  
  PRIMARY KEY (id)
);

/* 								ENDEREÇOS PARA TESTES  										*/
INSERT INTO Endereco (id, cep, rua, bairro, cidade, uf) 
VALUES (1, 58117000, 'João Jerônimo da Costa', 'Bela Vista', 'Lagoa Seca', 'PB');

INSERT INTO Endereco (id, cep, rua, bairro, cidade, uf) 
VALUES (2, 58400, 'Rua de Adson', 'Bairro de Adson', 'Campina Grande', 'PB');

INSERT INTO Endereco (id, cep, rua, bairro, cidade, uf) 
VALUES (3, 59200-000, 'Rua de Ramom', 'Bairro de Ramom', 'Santa Cruz', 'PE');


CREATE TABLE Cliente(
  id			integer AUTO_INCREMENT,
  id_endereco   integer,
  score_inicial double,
  cpf       	varchar(30) UNIQUE NOT NULL,
  nome      	varchar(30) NOT NULL,
  telefone  	varchar(20),
  email     	varchar(50),
 
  PRIMARY KEY (id),
  FOREIGN KEY(id_endereco) REFERENCES Endereco(id)
);

/*							CLIENTES PARA TESTES 							*/	
INSERT INTO Cliente (id, id_endereco, score_inicial, cpf, nome, telefone, email) 
VALUES (1, 1, 0.5, '111.111.111-11', 'Thairam', '999999999', 'email-Thairam');

INSERT INTO Cliente (id, id_endereco, score_inicial, cpf, nome, telefone, email) 
VALUES (2, 2, 0.5, '222.222.222-22', 'Adson', '888888888', 'email-Adson');

INSERT INTO Cliente (id, id_endereco, score_inicial, cpf, nome, telefone, email) 
VALUES (3, 3, 0.5, '333.333.333-33', 'Ramom', '777777777', 'email-Ramom');


CREATE TABLE Conta(
  id  			integer AUTO_INCREMENT,
  banco     	varchar(30),
  agencia   	integer,
  num_conta  	varchar(10),
  id_cliente  	integer,
  
  PRIMARY KEY (id),
  UNIQUE INDEX cnt(banco, agencia, num_conta),
  FOREIGN KEY(id_cliente) REFERENCES Cliente(id)
);

/*						CONTAS PARA TESTES						*/
INSERT INTO CONTA (id, banco, agencia, num_conta, id_cliente)
VALUES (1, 'Banco do Brasil', 1, '0001', 1);

INSERT INTO CONTA (id, banco, agencia, num_conta, id_cliente)
VALUES (2, 'Banco do Brasil', 1, '0002', 2);

INSERT INTO CONTA (id, banco, agencia, num_conta, id_cliente)
VALUES (3, 'Banco do Brasil', 1, '0003', 3);

CREATE TABLE Cheque(
  id  				integer AUTO_INCREMENT,
  numero 			integer NOT NULL,
  id_conta 			integer NOT NULL,
  id_cliente 		integer,
  valor 			double DEFAULT 0,
  data_compensado 	date,
  data_compensacao 	date,
  status_cheque 	integer,

  PRIMARY KEY (id),
  FOREIGN KEY (id_conta) REFERENCES Conta(id),
  FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
);

/*											CHEQUES PARA TESTES 					*/								
INSERT INTO Cheque (id, numero, id_conta, id_cliente, valor, data_compensado, data_compensacao, status_cheque)
VALUES (1, 1, 1, 2, 150, '2019/06/08', '2019/06/09', 0);


INSERT INTO Cheque (id, numero, id_conta, id_cliente, valor, data_compensado, data_compensacao, status_cheque)
VALUES (2, 1, 3, 1, 100, '2019/06/08', '2019/06/09', 0);

INSERT INTO Cheque (id, numero, id_conta, id_cliente, valor, data_compensado, data_compensacao, status_cheque)
VALUES (3, 2, 2, 1, 300, '2019/06/08', '2019/06/09', 0);


CREATE TABLE HistoricoCheque(
  id_cheque       integer,
  id_cliente	  integer,
  tipo            integer,
  descricao		  varchar(40),
  data_transacao  date,
  score       	  double,
  
  FOREIGN KEY (id_cheque) REFERENCES Cheque(id) ON DELETE SET NULL,
  FOREIGN KEY (id_cliente) REFERENCES Cliente (id)
);

INSERT INTO HistoricoCheque (id_cheque, id_cliente, tipo, descricao, data_transacao, score)
VALUES (1, 1, 1, null, '2019/06/10', 0.5);

INSERT INTO HistoricoCheque (id_cheque, id_cliente, tipo, descricao, data_transacao, score)
VALUES (1, 2, 1, null, '2019/06/10', 0.1);

INSERT INTO HistoricoCheque (id_cheque, id_cliente, tipo, descricao, data_transacao, score)
VALUES (2, 3, 1, null, '2019/06/10', 0.7);
	
INSERT INTO HistoricoCheque (id_cheque, id_cliente, tipo, descricao, data_transacao, score)
VALUES (3, 2, 1, null, '2019/06/10', 1);

DELIMITER $$
CREATE 
TRIGGER trgRegHistorico
BEFORE UPDATE
ON cheque
FOR EACH ROW
BEGIN
 IF (OLD.status_cheque != NEW.status_cheque) AND (NEW.status_cheque > 0) THEN
   INSERT INTO historicocheque VALUES (NEW.id, NEW.id_cliente, NEW.status_cheque, null, CURRENT_DATE, IF(NEW.status_cheque = 1, 1.1, 0.8));
   SELECT co.id_cliente FROM conta co WHERE NEW.id_conta = co.id into @emitente;

   IF (NEW.id_cliente != @emitente) THEN
     INSERT INTO historicocheque VALUES (NEW.id, @emitente, NEW.status_cheque, null, CURRENT_DATE, IF(NEW.status_cheque = 1, 1.1, 0.8));
   END IF;
 END IF;
END;

CREATE TRIGGER trgDelCliente
BEFORE DELETE
ON cliente 
FOR EACH ROW
BEGIN
 DELETE FROM HistoricoCheque WHERE HistoricoCheque.id_cliente = OLD.id;
 DELETE FROM Cheque WHERE Cheque.id_cliente = OLD.id;
 DELETE FROM Conta WHERE Conta.id_cliente = OLD.id;
END;

CREATE TRIGGER trgDelConta
BEFORE DELETE 
ON Conta
FOR EACH ROW
BEGIN
 DELETE FROM Cheque WHERE Cheque.id_conta = OLD.id;
END;
DELIMITER ;
