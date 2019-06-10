/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Cliente;
import classes.Endereco;
import java.sql.*;

/**
 *
 * @author Adson Macêdo
 * @param <T>
 */
public class ClienteDao<T> extends Dao<T>{

    public ClienteDao() {
        super("cliente");
    }
    
    protected T getObject(ResultSet resultSet) throws SQLException{
        Endereco endereco = null;

        if (resultSet.getInt("id_endereco") != 0){
            EnderecoDao dao = new EnderecoDao();
            endereco = (Endereco)dao.find(resultSet.getInt("id_endereco"));
        }

        return ((T) new Cliente(resultSet.getInt("id"),
                                endereco,
                                resultSet.getString("cpf"),
                                resultSet.getString("nome"),
                                resultSet.getString("telefone"),
                                resultSet.getString("email"),
                                resultSet.getDouble("score_inicial")
                             ));
    }
        

}
