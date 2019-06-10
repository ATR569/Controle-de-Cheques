/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adson Macêdo
 * @param <T>
 */
public class ChequeDao<T> extends Dao<T>{
    
    public ChequeDao() {
        super("cheque");
    }
    
    @Override
    protected T getObject(ResultSet resultSet) throws SQLException {
        Cliente cliente = null;
        Conta conta = null;

        if (resultSet.getInt("id_cliente") != 0)
            cliente = (new ClienteDao<Cliente>()).find(resultSet.getInt("id_cliente"));

        if (resultSet.getInt("id_conta") != 0)
            conta = (new ContaDao<Conta>()).find(resultSet.getInt("id_conta"));

        return ((T) new Cheque(resultSet.getInt("id"),
                                cliente,
                                resultSet.getDouble("valor"),                                
                                conta,
                                resultSet.getInt("numero"),
                                resultSet.getDate("data_compensacao"),
                                resultSet.getDate("data_compensado"),
                                resultSet.getInt("status_cheque")
                             ));
    }
    
    
}
