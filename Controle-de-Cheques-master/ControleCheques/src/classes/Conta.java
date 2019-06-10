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
    private String conta;

    public Conta(int id, Cliente cliente, String banco, int agencia, String conta) {
        this.id = id;
        this.cliente = cliente;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
    }

    public Conta(Cliente cliente, String banco, int agencia, String conta) {
        this(0, cliente, banco, agencia, conta);
    }

    
    
    
}
