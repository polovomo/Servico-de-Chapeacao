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
import model.Servico;

/**
 *
 * @author aluno.saolucas
 */
public class ServicoController {
    //inserindo serviço no banco
    public boolean inserir(Servico servico) {
    String sql = "INSERT INTO Servico (descricao, valor_unitario, nome) VALUES (?,?,?)";

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;

    try {
        comando = gerenciador.prepararComando(sql);

        // Definindo os valores para os placeholders (?)
        comando.setString(1, servico.getDescricao());
        comando.setDouble(2, servico.getValorUnitario());
        comando.setString(3,servico.getNomeServico());
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
