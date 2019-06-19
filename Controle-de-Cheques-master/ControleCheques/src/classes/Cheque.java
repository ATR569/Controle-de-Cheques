/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.interfaces.Entity;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Adson Macêdo
 */
public class Cheque implements Entity{
    private int id;
    private Cliente cliente;
    private double valor;
    private Conta conta;
    private int numero;
    private Calendar dataCompensacao;    
    private Calendar dataCompensado;    
    private int state;
    public static final int ABERTO = 0, DEVOLVIDO = 1, COMPENSADO = 2;
        
    public Cheque(){}
    
    public Cheque(int id, Cliente cliente, double valor, Conta conta, int numero, Calendar dataCompensacao, Calendar dataCompensado, int state) {
        this.id = id;
        this.cliente = cliente;
        this.conta = conta;
        this.numero = numero;
        this.valor = valor;
        this.dataCompensacao = dataCompensacao;
        this.dataCompensado = dataCompensado;
        this.state = state;
    }
    
    public Cheque(Cliente cliente, double valor, Conta conta, int numero, Calendar dataCompensacao) {
        this(0, cliente, valor, conta, numero, dataCompensacao, null, ABERTO);
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

    public Calendar getDataCompensacao() {
        return dataCompensacao;
    }

    public void setDataCompensacao(Calendar dataCompensacao) {
        this.dataCompensacao = dataCompensacao;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String getFields() {
        return "numero, id_conta, id_cliente, valor, data_compensado, data_compensacao, status_cheque";
    }

    @Override
    public String getValues() {
        
        return  numero + ", " +
                (conta != null ? conta.getId() + ", ": "null, ") + 
                (cliente != null ? cliente.getId() + ", ": "null, ") + 
                valor + ", " + 
                (dataCompensado != null ? "'" + dataCompensado.get(Calendar.YEAR) + '/' + dataCompensado.get(Calendar.MONTH) + '/' + dataCompensado.get(Calendar.DATE) + "'," : "null, " ) +
                "'" + dataCompensacao.get(Calendar.YEAR) + '/' + dataCompensacao.get(Calendar.MONTH) + '/' + dataCompensacao.get(Calendar.DATE) + "',"+
                state;                
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
