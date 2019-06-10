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
  cpf       	varchar(30) UNIQUE,
  nome      	varchar(30) NOT NULL,
  telefone  	varchar(20),
  email     	varchar(50),
 
  PRIMARY KEY (id),
  FOREIGN KEY(id_endereco) REFERENCES Endereco(id)
);

/*							CLIENTES PARA TESTES 								*/
INSERT INTO Cliente (id, id_endereco, score_inicial, cpf, nome, telefone, email) 
VALUES (1, 1, 55.0, '11111111111', 'Thairam', '999999999', 'email-Thairam');

INSERT INTO Cliente (id, id_endereco, score_inicial, cpf, nome, telefone, email) 
VALUES (2, 2, 55.0, '22222222222', 'Adson', '888888888', 'email-Adson');

INSERT INTO Cliente (id, id_endereco, score_inicial, cpf, nome, telefone, email) 
VALUES (3, 3, 55.0, '33333333333', 'Ramom', '777777777', 'email-Ramom');

CREATE TABLE Conta(
  id  			integer AUTO_INCREMENT,
  banco     	integer,
  agencia   	integer,
  num_conta  	varchar(10),
  id_cliente  	integer,
  
  PRIMARY KEY (id),
  UNIQUE INDEX cnt(banco, agencia, num_conta),
  FOREIGN KEY(id_cliente) REFERENCES Cliente(id)
);

/*						CONTAS PARA TESTES						*/
INSERT INTO CONTA (id, banco, agencia, num_conta, id_cliente)
VALUES (1, 1, 1, '0001', 1);

INSERT INTO CONTA (id, banco, agencia, num_conta, id_cliente)
VALUES (2, 1, 1, '0002', 2);

INSERT INTO CONTA (id, banco, agencia, num_conta, id_cliente)
VALUES (3, 1, 1, '0003', 3);

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

/*											CHEQUES PARA TESTES 													*/
INSERT INTO Cheque (id, numero, id_conta, id_cliente, valor, data_compensado, data_compensacao, status_cheque)
VALUES (1, 1, 1, 2, 150, '2019/06/08', '2019/06/09', 0);

/*
INSERT INTO Cheque (id, numero, id_conta, id_cliente, valor, data_compensado, data_compensacao, status_cheque)
VALUES (2, 1, 1, 2, 100, '2019/06/08', '2019/06/09', 0);

INSERT INTO Cheque (id, numero, id_conta, id_cliente, valor, data_compensado, data_compensacao, status_cheque)
VALUES (3, 2, 3, 1, 300, '2019/06/08', '2019/06/09', 0);
*/

CREATE TABLE HistoricoCheque(
  id_cheque       integer,
  tipo            integer,
  descricao       varchar(40),
  data_transacao  date,
  Score       	  double,
  
  FOREIGN KEY (id_cheque) REFERENCES Cheque(id) 
);

CREATE VIEW ww_Cheques AS SELECT 
	(SELECT Cliente.nome FROM Cliente WHERE Cliente.id = Cheque.id_cliente) AS 'Nome_do_Cliente', 
	Conta.banco AS 'Banco', 
	Conta.agencia AS 'Agência',
	Cheque.numero AS 'Num_da_Conta', 
	Cheque.numero AS 'Num_Cheque', 
	(SELECT Cliente.nome FROM Cliente WHERE Cliente.id = Conta.id_cliente) AS 'Nome_do_Emitente',
	Cheque.valor AS 'Valor',
	Cheque.data_compensacao AS 'Data_de_Compensação', 
	Cheque.status_cheque AS 'Status'
FROM 
	Cheque INNER JOIN Conta ON Cheque.id_conta = Conta.id;

SELECT * FROM ww_Cheques;