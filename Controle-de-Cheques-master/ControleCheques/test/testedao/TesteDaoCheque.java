/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedao;

import DAO.*;
import classes.Cheque;
import java.sql.SQLException;
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
        Cheque ch1 = dao.find(3);
        System.out.println("Data de Compensação: " + ch1.getDataCompensacao());
        System.out.printf("Cheque: %08d\n", ch1.getNumero());
        System.out.printf("Valor: R$ %.2f\n", ch1.getValor());
        System.out.println("Cliente: " + ch1.getCliente().getNome());
        System.out.println("Banco: " + ch1.getConta().getBanco());
        System.out.printf("Agência: %06d\n", ch1.getConta().getAgencia());
        System.out.printf("Número Conta: %s\n", ch1.getConta().getNumConta());
        System.out.println("Emitente: " + ch1.getConta().getCliente().getNome());
    }
}
