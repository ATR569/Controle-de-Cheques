/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedao;

import DAO.ClienteDao;
import DAO.Dao;
import DAO.TransacaoDao;
import classes.Cliente;
import classes.HistoricoTransacoes;
import classes.Transacao;
import java.sql.SQLException;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Adson Macêdo
 */
public class TesteDaoTransacao {
    Dao<Transacao> dao;

    @Before
    public void setup(){
        dao = new TransacaoDao<>();
    }
    
    @Test
    public void testeQueryTransacao(){
        
        try {
            //  Busca o cliente de id = 1 na tabela
            Cliente c1 = (new ClienteDao<Cliente>()).find(1);
            //  Busca o cliente de id = 2 na tabela
            Cliente c2 = (new ClienteDao<Cliente>()).find(2);
            
            //  Instacia o histórico das transações para os cientes
            HistoricoTransacoes h1 = new HistoricoTransacoes(c1.getId());
            HistoricoTransacoes h2 = new HistoricoTransacoes(c2.getId());
            
            //  O score atual é dado por score_inicial*score_das_transacoes
            System.out.println("Cliente: " + c1.getNome());
            System.out.printf("Confiança: %.2f%%\n\n", 100*(c1.getScoreInicial()*h1.getScoreTransacoes()));
            System.out.println("Cliente: " + c2.getNome());
            System.out.printf("Confiança: %.2f%%\n\n", 100*(c2.getScoreAtual()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
