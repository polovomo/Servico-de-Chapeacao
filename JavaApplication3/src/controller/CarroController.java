/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Carro;

/**
 *
 * @author aluno.saolucas
 */
public class CarroController {
     //inserindo carro no banco
    public boolean inserir(Carro carro) {
    String sql = "INSERT INTO Carro (modelo, marca, placa, ano_fabricacao, fk_cliente) VALUES (?, ?, ?, ?, ?)";

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;

    try {
        comando = gerenciador.prepararComando(sql);

        // Definindo os valores para os placeholders (?)
        comando.setString(1, carro.getModelo());
        comando.setString(2, carro.getMarca());
        comando.setString(3, carro.getPlaca());
        comando.setInt(4, carro.getAnoFabricacao());
        comando.setInt(5, carro.getFkCliente());  // Chave estrangeira

        // Executa o comando de inserção
        comando.executeUpdate();

        return true;

    } catch (SQLException e) {
        // Caso ocorra um erro, exibe a mensagem de erro
        JOptionPane.showMessageDialog(null, e.getMessage());
    } finally {
        // Fecha a conexão no final
        gerenciador.fecharConexao(comando, resultado);
    }

    return false;
}

    
}
