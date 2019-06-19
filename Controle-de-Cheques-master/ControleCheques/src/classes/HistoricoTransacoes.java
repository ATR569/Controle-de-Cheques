/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.Dao;
import DAO.TransacaoDao;
import java.util.ArrayList;

/**
 *
 * @author Adson Macêdo
 */
public class HistoricoTransacoes {
    private ArrayList<Transacao> historico;
    
    public HistoricoTransacoes(int idCliente) {
        Dao<Transacao> dao = new TransacaoDao<>();
        this.historico = dao.query("SELECT * FROM "+ dao.getTable() + " WHERE id_cliente = " + idCliente + " ORDER BY data_transacao DESC LIMIT 30");
    }
    
    public double getScoreTransacoes(){
        double confianca = 1;
        for (Transacao tr : historico)
            confianca *= tr.getScore();
        
        return confianca;
    }
}
