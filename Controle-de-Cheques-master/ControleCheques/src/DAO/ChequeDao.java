/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Adson Macêdo
 */
public class ChequeDao extends Dao{
    
    public ChequeDao() {
        super("cheque");
    }
    
    @Override
    protected Object getObject(ResultSet resultSet) throws SQLException {
        Cliente cliente = null;
        Conta conta = null;

        if (resultSet.getInt("id_cliente") != 0)
            cliente = (Cliente)(new ClienteDao()).find(resultSet.getInt("id_cliente"));

        if (resultSet.getInt("id_conta") != 0)
            conta = (Conta)(new ContaDao()).find(resultSet.getInt("id_conta"));

        return ((Object) new Cheque(resultSet.getInt("id"),
                                cliente,
                                resultSet.getDouble("valor"),                                
                                conta,
                                resultSet.getInt("numero"),
                                resultSet.getDate("data_compensacao"),
                                resultSet.getInt("status_cheque")
                             ));
    }
    
    
}
