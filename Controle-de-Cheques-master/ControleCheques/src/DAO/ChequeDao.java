/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import sun.util.calendar.BaseCalendar;

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
        
        Calendar compensacao, compensado = null;
        
        Date dataCompesancao = resultSet.getDate("data_compensacao");
        Date dataCompensado = resultSet.getDate("data_compensado");
        
        compensacao = Calendar.getInstance();
        compensacao.setTime(dataCompesancao);
        
        if (dataCompensado != null){
            compensado = Calendar.getInstance();
            compensado.setTime(dataCompensado);
        }
        
        System.out.println(compensacao.get(Calendar.DATE));
        return ((T) new Cheque(resultSet.getInt("id"),
                                cliente,
                                resultSet.getDouble("valor"),                                
                                conta,
                                resultSet.getInt("numero"),
                                compensacao,
                                compensado,
                                resultSet.getInt("status_cheque")
                             ));
    }
    
    
}
