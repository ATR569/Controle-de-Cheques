/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Adson Macêdo
 */
public class HistoricoTransacoes {
    private ArrayList<Transacao> historico = new ArrayList<>();
    
    public double getConfianca(){
        double confianca = 1;
        for (Transacao tr : historico)
            confianca *= tr.getScore();
        
        return confianca;
    }
}
