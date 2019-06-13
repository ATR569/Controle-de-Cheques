/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Cliente;
import classes.Conta;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adson Macêdo
 * @param <T>
 */
public class ContaDao<T> extends Dao<T>{

    public ContaDao() {
        super("conta");
    }

    @Override
    protected T getObject(ResultSet resultSet) throws SQLException {
        Cliente cliente = null;

        if (resultSet.getInt("id_cliente") != 0)
            cliente = (new ClienteDao<Cliente>()).find(resultSet.getInt("id_cliente"));

        return ((T) new Conta(resultSet.getInt("id"),
                                cliente,
                                resultSet.getString("banco"),                                
                                resultSet.getInt("agencia"),
                                resultSet.getString("num_conta")
                             ));
    }
    
}
