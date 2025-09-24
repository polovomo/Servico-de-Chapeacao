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
public class OrdemServico {

    private int idOrdemServico;
    private String status;
    private double valorTotal;
    private int fkCliente;
    private int fkCarro;

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    
    public void setFkCarro(int fkCarro) {
        this.fkCarro = fkCarro;
    }

    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    public String getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getFkCliente() {
        return fkCliente;
    }

   

    public int getFkCarro() {
        return fkCarro;
    }

}
