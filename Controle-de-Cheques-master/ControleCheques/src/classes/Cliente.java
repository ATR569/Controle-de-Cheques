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
class Cliente {
    private int id;
    private Endereco endereco;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private double scoreInicial;

    public Cliente(int id, Endereco endereco, String cpf, String nome, String telefone, String email, double scoreInicial) {
        this.id = id;
        this.endereco = endereco;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.scoreInicial = scoreInicial;
    }

    public Cliente(Endereco endereco, String cpf, String nome, String telefone, String email, double scoreInicial) {
        this(0, endereco, cpf, nome, telefone, email, scoreInicial);
    } 
    
}
