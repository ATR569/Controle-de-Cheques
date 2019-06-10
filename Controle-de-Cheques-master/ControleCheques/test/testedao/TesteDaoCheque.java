/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedao;

import DAO.*;
import classes.Cheque;
import java.sql.SQLException;
import org.junit.Test;

/**
 *
 * @author Adson Macêdo
 */
public class TesteDaoCheque {
    
    public TesteDaoCheque() {
        
    }
    
    @Test
    public void testaDaoCheque() throws SQLException{
        Dao dao = new ChequeDao();
        
        Cheque ch1 = (Cheque)dao.find(1);
        System.out.println(ch1.getCliente().getNome());
        Cheque ch2 = (Cheque)dao.find(5);
        System.out.println(ch2);
        
    }
}
