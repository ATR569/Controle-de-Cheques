/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author Adson Macêdo
 */
public class Cheque {
    private int id;
    private Cliente cliente;
    private double valor;
    private Conta conta;
    private int numero;
    private Date dataCompensacao;    
    private int state;
    public static final int ABERTO = 0, DEVOLVIDO = 1, COMPENSADO = 2;
            
    public Cheque(int id, Cliente cliente, double valor, Conta conta, int numero, Date dataCompensacao, int state) {
        this.id = id;
        this.cliente = cliente;
        this.conta = conta;
        this.numero = numero;
        this.dataCompensacao = dataCompensacao;
        this.state = state;
    }
    
    public Cheque(Cliente cliente, double valor, Conta conta, int numero, Date dataCompensacao) {
        this(0, cliente, valor, conta, numero, dataCompensacao, ABERTO);
    }

    public void saveData(){
        if (id != 0){
            
        }else{
            
        }
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataCompensacao() {
        return dataCompensacao;
    }

    public void setDataCompensacao(Date dataCompensacao) {
        this.dataCompensacao = dataCompensacao;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
}
