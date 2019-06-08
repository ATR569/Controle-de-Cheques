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
    private Date dataCompensacao;    
    private int state;
    public static final int ABERTO = 0, DEVOLVIDO = 1, COMPENSADO = 2;
            
    Cheque(int id, Cliente cliente, double valor, Conta conta, Date dataCompensacao, int state) {
        this.id = id;
        this.cliente = cliente;
        this.conta = conta;
        this.dataCompensacao = dataCompensacao;
        this.state = state;
    }
    
    Cheque(Cliente cliente, double valor, Conta conta, Date dataCompensacao) {
        this(0, cliente, valor, conta, dataCompensacao, ABERTO);
    }

    public void saveData(){
        if (id != 0){
            
        }else{
            
        }
    }
    
}
