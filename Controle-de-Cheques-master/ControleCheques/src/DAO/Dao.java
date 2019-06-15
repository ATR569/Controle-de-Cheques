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
 * @param <T> tipo do objeto manipulado
 */
public abstract class Dao<T>{
    protected Connection con;
    protected PreparedStatement stmt;
    protected ResultSet rs;
    protected String table;
    
    /**
     * Cria uma Dao para a tabela table
     * @param table
     */
    public Dao(String table){
        this.table = table;
    }
    
    public String getTable(){
        return this.table;
    }
    
    /**
     * Adiciona na tabela table um registro para o objeto ent,
     * que implementa a interface Entity
     * @param ent
     * @throws SQLException
     */
    public void insert(Entity ent) throws SQLException{
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement("INSERT INTO " + table + "("+ ent.getFields() +") VALUES (" + ent.getValues() + ")", 1);
            stmt.executeUpdate();            
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();
            ent.setKeyValue(keys.getInt(1));
            
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao salvar!", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    /**
     * Atualiza na tabela table um registro referente ao objeto ent,
     * que implementa a interface Entity
     * @param ent
     * @throws SQLException
     */
    public void update(Entity ent) throws SQLException{
        con = ConnectionFactory.getConnection();
        String [] fields = ent.getFields().split(",");
        String [] values = ent.getValues().split(",");
        
        String sql = "UPDATE " + table + " SET ";
        
        sql += fields[0] + " = " + values[0];
        for (int i = 1; i < fields.length; i++)
            sql += ", " + fields[i] + " = " + values[i];

        sql += " WHERE " + ent.getKeyField()  + " = " + ent.getKeyValue();

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao salvar!", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     * Remove da tabela table a tupla referente ao objeto ent
     * @param ent
     * @throws SQLException
     */
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
    
    /**
     * Executa uma instrução SQL
     * @param sql
     * @throws SQLException
     */
    public void executeSql(String sql) throws SQLException{
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement(sql);
            stmt.execute();            
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao executar operação!", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    /**
     * Realiza uma consulta na tabela e retorna um ArrayList com os
     * elementos em objetos
     * @param sql
     * @return
     * @throws SQLException
     */
    public ArrayList<T> query(String sql) throws SQLException{
        ArrayList<T> lista = new ArrayList<>();
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
    
    /**
     * Busca um registro específico e retorna em um objeto do tipo
     * @param id
     * @return
     * @throws SQLException
     */
    public T find(int id) throws SQLException {
        ArrayList<T> lista = query("SELECT * FROM " + table + " WHERE id = " + id);
        
        if (lista.isEmpty())
            return null;
        else
            return lista.get(0);
    }

    /**
     * Busca um registro específico e retorna em um objeto do tipo
     * @param fields
     * @param values
     * @return
     * @throws SQLException
     */
    public T find(String []fields, String []values) throws SQLException {
        String sql = "SELECT * FROM " + getTable() + " WHERE "+ fields[0] + " = " + values[0];
        for (int i = 1; i < fields.length; i++) {
            sql += " AND " + fields[i] + " = " + values[i];
        }
        
        ArrayList<T> lista = query(sql);
        
        if (lista.isEmpty())
            return null;
        else
            return lista.get(0);
    }
    
    /**
     * Método abstrato a ser implementado em todas as especializações de Dao,
     * que retornará o objeto específico de cada tipo de Dao
     * @param resultSet
     * @return
     * @throws SQLException
     */
    protected abstract T getObject(ResultSet resultSet) throws SQLException;
    
}
