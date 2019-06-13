/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.interfaces.Entity;
import java.sql.SQLException;

/**
 *
 * @author Adson Macêdo
 */
public class Cliente extends Object implements Entity{
    private int id;
    private Endereco endereco;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private double scoreInicial;

    public Cliente(int id, Endereco endereco, String cpf, String nome, String telefone, String email, double scoreInicial) {
        this.id = id;
        this.endereco = endereco;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.scoreInicial = scoreInicial;
    }

    public Cliente(Endereco endereco, String cpf, String nome, String telefone, String email, double scoreInicial) {
        this(0, endereco, cpf, nome, telefone, email, scoreInicial);
    } 

    public Cliente() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getScoreInicial() {
        return scoreInicial;
    }
    
    public double getScoreAtual() throws SQLException{
        return (new HistoricoTransacoes(this.id)).getScoreTransacoes() * this.scoreInicial; 
    }

    public void setScoreInicial(double scoreInicial) {
        this.scoreInicial = scoreInicial;
    }

    @Override
    public String getFields() {
        return "id_endereco, score_inicial, cpf, nome, telefone, email";
    }

    @Override
    public String getValues() {
        return (endereco != null ? endereco.getId() : "null")+", "+
                getScoreInicial() + ", "+
                "\""+getCpf() + "\", " + 
                "\""+getNome() + "\", "+
                "\""+getTelefone() + "\", "+
                "\""+getEmail()+ "\"";
    }

    @Override
    public String getKeyField() {
        return "id";
    }

    @Override
    public int getKeyValue() {
        return this.id;
    }

    @Override
    public void setKeyValue(int value) {
        setId(value);
    }

}
