/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.interfaces.Entity;
import java.util.Calendar;

/**
 *
 * @author Adson Macêdo
 */
public class Transacao implements Entity{
    private int idCheque;
    private int tipo;
    private Calendar data;
    private double score;
    
    public Transacao(){}

    public Transacao(int idCheque, int tipo, Calendar data, double score) {
        this.idCheque = idCheque;
        this.tipo = tipo;
        this.data = data;
        this.score = score;
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
        if (tipo == 1)
            return "COMPENSAÇÃO";
        else
            return "DEVOLUÇÃO MOTIVO " + tipo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    @Override
    public void setKeyValue(int value) {

    }

}
