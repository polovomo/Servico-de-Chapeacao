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
public class Carro {

    private int idCarro;
    private String modelo;
    private String marca;
    private String placa;
    private int anoFabricacao;
    private int fkCliente;

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public Carro(int idCarro, String modelo, String marca, String placa, int anoFabricacao, int fkCliente) {
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.fkCliente = fkCliente;
    }
    
    
    
}
