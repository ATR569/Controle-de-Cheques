/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.interfaces.Entity;
import java.util.Date;

/**
 *
 * @author Adson Macêdo
 */
public class Transacao implements Entity{
    private int idCheque;
    private int tipo;
    private String descricao;
    private Date data;
    private double score;
    
    public Transacao(){}

    public Transacao(int idCheque, int tipo, Date data, double score) {
        this.idCheque = idCheque;
        this.tipo = tipo;
        this.data = data;
        this.score = score;
        
        if (tipo == 0)
            this.descricao = "COMPENSAÇÃO";
        else
            this.descricao = "DEVOLUÇÃO MOTIVO " + tipo;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String getFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getKeyField() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getKeyValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(int idCheque) {
        this.idCheque = idCheque;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public void setKeyValue(int value) {

    }

}
