/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedao;

import DAO.ClienteDao;
import DAO.Dao;
import classes.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Adson Macêdo
 */
public class TesteDaoCliente {
    
    public TesteDaoCliente() {
    }
    @Test
    public void testaDaoCheque() throws SQLException{
        Cliente c1 = new Cliente(1, null, "000.000.000-20", "Adson de Macêdo", "(83) 00000-0000", "agnsoft@hotmail.com", 1);
        Cliente c2 = new Cliente(2, null, "000.000.000-21", "João pé de Feijão", "(83) 00000-0000", "agnsoft@hotmail.com", 0.7);
        
        Dao dao = new ClienteDao();
        ArrayList<Object> lista = dao.query("SELECT * FROM CLIENTE");
        
        for (Object c : lista){
            System.out.println("Nome: " + ((Cliente)c).getNome());
            if (((Cliente)c).getEndereco() != null){
                System.out.println("Endereço: " + ((Cliente)c).getEndereco().getRua());
            }else{
                System.out.println("<sem endereço>");
            }
                
            System.out.println();
        }
//        dao.insert(c1);
        for (Object c : lista){
            System.out.println("Nome: " + ((Cliente)c).getNome());
            if (((Cliente)c).getEndereco() != null){
                System.out.println("Endereço: " + ((Cliente)c).getEndereco().getRua());
            }else{
                System.out.println("<sem endereço>");
            }
                
            System.out.println();
        }
    }
    
    
}
