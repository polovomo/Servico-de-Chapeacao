/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrador
 */
public class Peca {

    private int idPeca;
    private String nome;
    private double valorUnitario;
    private String descricao;

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

}
