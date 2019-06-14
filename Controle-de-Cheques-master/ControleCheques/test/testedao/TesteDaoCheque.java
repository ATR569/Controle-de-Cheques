/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedao;

import DAO.*;
import classes.Cheque;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Adson Macêdo
 */
public class TesteDaoCheque {
    Dao<Cheque> dao;
    public TesteDaoCheque() {
        
    }
    
    @Before
    public void setup(){
        this.dao = new ChequeDao<>();
    }
    
    @Test
    public void testaFindCheque() throws SQLException{
        System.out.println("=======teste find==========");
        Cheque ch1 = dao.find(3);
        System.out.println("Data de Compensação: " + ch1.getDataCompensacao());
        System.out.printf("Cheque: %08d\n", ch1.getNumero());
        System.out.printf("Valor: R$ %.2f\n", ch1.getValor());
        System.out.println("Cliente: " + ch1.getCliente().getNome());
        System.out.println("Banco: " + ch1.getConta().getBanco());
        System.out.printf("Agência: %06d\n", ch1.getConta().getAgencia());
        System.out.printf("Número Conta: %s\n", ch1.getConta().getNumConta());
        System.out.println("Emitente: " + ch1.getConta().getCliente().getNome());
        System.out.println("===========================");
    }
    
    @Test
    public void testeQueryCheque(){
        System.out.println("=======teste query========");
        try {
            ArrayList<Cheque> lista = dao.query("SELECT * FROM cheque");
            System.out.println(lista.size() + " registros");
            for (Cheque c : lista) {
                System.out.println("Cliente: " + c.getCliente().getNome());
                System.out.println("Cliente: " + c.getConta().getCliente().getNome());
                System.out.printf("Valor: R$ %.2f", c.getValor());
                System.out.println("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TesteDaoCheque.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("===========================");
            
    }
}
