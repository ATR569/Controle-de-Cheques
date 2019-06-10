/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adson Macêdo
 */
public class ContaDao extends Dao{

    public ContaDao() {
        super("conta");
    }

    @Override
    protected Object getObject(ResultSet resultSet) throws SQLException {
        return null;
    }
    
}
