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
public class Transacao {
    private int idCheque;
    private int tipo;
    private String descricao;
    private Date data;
    private double score;

    public Transacao(int idCheque, int tipo, String descricao, Date data, double score) {
        this.idCheque = idCheque;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    

}
