/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Adson Macêdo
 */
public class Conta {
    private int id;
    private Cliente cliente;
    private String banco;
    private int agencia;
    private String numConta;

    public Conta(int id, Cliente cliente, String banco, int agencia, String conta) {
        this.id = id;
        this.cliente = cliente;
        this.banco = banco;
        this.agencia = agencia;
        this.numConta = conta;
    }

    public Conta(Cliente cliente, String banco, int agencia, String conta) {
        this(0, cliente, banco, agencia, conta);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    
    
    
}
