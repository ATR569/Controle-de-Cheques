/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedao;

import DAO.ClienteDao;
import DAO.Dao;
import classes.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thairam Michel
 */
public class TesteDaoConta {
    
    Dao<Cliente> dao;
    
    @Before
    public void Setup(){
        dao  = new ClienteDao<>();
    }
}
