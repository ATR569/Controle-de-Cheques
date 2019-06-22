/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Transacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Adson Macêdo
 * @param <T>
 */
public class TransacaoDao<T> extends Dao<T>{

    public TransacaoDao() {
        super("historicocheque");
    }

    @Override
    protected T getObject(ResultSet resultSet) throws SQLException {
        Calendar data = Calendar.getInstance();
        data.setTime(resultSet.getDate("data_transacao"));
        return (T) new Transacao(resultSet.getInt("id_cheque"),
                                 resultSet.getInt("tipo"),
                                 data,
                                 resultSet.getDouble("score")
        );
    }
    
}
