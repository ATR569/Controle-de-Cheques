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
public class Endereco {
    private int id;
    private int cep;
    private String rua;
    private String bairro;
    private String uf;
    
    Endereco(int id, int cep, String rua, String bairro, String uf){
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.uf = uf;
    }

    public Endereco(int cep, String rua, String bairro, String uf) {
        this(0, cep, rua, bairro, uf);
    }  
    
}
