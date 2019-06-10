/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.interfaces.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Adson Macêdo
 */
public abstract class Dao{
    protected Connection con;
    protected PreparedStatement stmt;
    protected ResultSet rs;
    protected String table;
    
    public Dao(String table){
        
        this.table = table;
    }
        
    public void insert(Entity ent) throws SQLException{
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement("INSERT INTO " + table + "("+ ent.getFields() +") VALUES (" + ent.getValues() + ")");
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao salvar!", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Entity ent) throws SQLException{
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement("DELETE FROM " + table + " WHERE "+ ent.getKeyField() + " = " + ent.getKeyValue());
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao salvar!", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void executeSql(String sql) throws SQLException{
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();            
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao executar operação!", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Object> query(String sql) throws SQLException{
        ArrayList<Object> lista = new ArrayList<>();
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(); 

            while (rs.next()){
                lista.add(getObject(rs));
            }
            
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar consulta!", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        } 
    }
    
    public Object find(int id) throws SQLException {
        ArrayList<Object> lista = query("SELECT * FROM " + table + " WHERE id = " + id);
        
        if (lista.isEmpty())
            return null;
        else
            return lista.get(0);
    }

    protected abstract Object getObject(ResultSet resultSet) throws SQLException;
}
