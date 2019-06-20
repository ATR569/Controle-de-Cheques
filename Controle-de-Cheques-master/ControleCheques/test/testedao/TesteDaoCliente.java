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
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Adson Macêdo
 */
public class TesteDaoCliente {
    Dao<Cliente> dao;
    
    @Before
    public void Setup(){
        dao  = new ClienteDao<>();
    }
    public TesteDaoCliente() {
        
    }

    @Test
    public void testaQueryCliente() throws SQLException{        
        ArrayList<Cliente> lista;
        lista = dao.query("SELECT * FROM CLIENTE");
        
        for (Cliente c : lista){
            System.out.println("Nome: " + c.getNome());
            if (c.getEndereco() != null){
                System.out.println("Endereço: " + c.getEndereco().getRua());
            }else{
                System.out.println("<sem endereço>");
            }
                
            System.out.println();
        }
        
        lista = dao.query("SELECT * FROM CLIENTE WHERE id >= 4");
        
        for (Cliente c : lista){
            System.out.println("Nome: " + c.getNome());
            if (c.getEndereco() != null){
                System.out.println("Endereço: " + c.getEndereco().getRua());
            }else{
                System.out.println("<sem endereço>");
            }
                
            System.out.println();
        }

    }
    
    @Test
    public void testeFindCliente() throws SQLException{
        Cliente c1 = dao.find(2);
        
        assertEquals(c1.getCpf(), "222.222.222-22");
        assertEquals(c1.getId(), 2);
        assertEquals(c1.getNome(), "Adson");
        
        Cliente c2 = dao.find(100);
        
        Assert.assertNull(c2);
    }
    
    @Test
    public void testeInsertCliente(){
        Cliente c1 = new Cliente();
        c1.setNome("João Bytista Binário Segundo");
        c1.setCpf("110.010.010-11");
        c1.setEndereco(null);
        c1.setEmail("jbb2@bytecode.com");
        c1.setTelefone("(10) 10010-0101");
        System.out.println(c1.getValues());
        dao.insert(c1);
        System.out.println("Incluindo: " + c1.getNome());
        Cliente c2 = dao.find(c1.getId());
        assertEquals(c1.getNome(), c2.getNome());
    }
    
    @Test
    public void testeDeleteCliente(){        
        Cliente c1 = new Cliente();
        c1.setNome("João Bytista Binário Segundo");
        c1.setCpf("010.010.010-11");
        c1.setEndereco(null);
        c1.setEmail("jbb@bytecode.com");
        c1.setScoreInicial(0.85);
        c1.setTelefone("(10) 10010-0101");
        
        System.out.println("Incluindo: " + c1.getNome());
        dao.insert(c1);
        System.out.println("Excluindo: " + c1.getNome());
        dao.delete(c1);
        c1 = dao.find(c1.getId());
        assertNull(c1);
    }
    
}
