/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedao;

import DAO.ContaDao;
import DAO.Dao;
import classes.Conta;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Thairam Michel
 */
public class TesteDaoConta {

    Dao<Conta> dao;

    @Before
    public void Setup() {
        dao = new ContaDao<>();
    }

    public void TesteDaoConta() {
    }

    @Test
    public void testeFindConta() throws SQLException {
        System.out.println("=======teste find==========");
        Conta conta1 = dao.find(1);
        System.out.println("Banco: " + conta1.getBanco());
        System.out.printf("Agência: %06d\n", conta1.getAgencia());
        System.out.printf("Número Conta: %s\n", conta1.getNumConta());
        System.out.println("Emitente : " + conta1.getCliente().getNome());
        System.out.println("===========================");
    }

    @Test
    public void testeQueryConta() {
        System.out.println("=======teste query========");
        ArrayList<Conta> lista = dao.query("SELECT * FROM conta");
        System.out.println(lista.size() + " registros");
        for (Conta conta : lista) {
            System.out.println("Banco: " + conta.getBanco());
            System.out.printf("Agência: %06d\n", conta.getAgencia());
            System.out.printf("Número Conta: %s\n", conta.getNumConta());
            System.out.println("Emitente : " + conta.getCliente().getNome());
            System.out.println(conta.getValues());
            System.out.println("");
        }
    }
}
