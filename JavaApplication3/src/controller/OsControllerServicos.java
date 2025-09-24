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
import model.OrdemServicoPecas;
import model.OrdemServicoServicos;

/**
 *
 * @author aluno.saolucas
 */
public class OsControllerServicos {
    public boolean inserir(OrdemServicoServicos os) {
        String sql = "INSERT INTO ordem_servico_servicos (id_ordem_servico, id_servico) VALUES (?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            //define o valor decada variável(?) pela posição em que aparece no sql
            comando.setInt(1, os.getIdOrdemServico());
            comando.setInt(2, os.getIdServico());
           
            

            //executa o comando
            comando.executeUpdate();

            return true;

        } catch (SQLException e) {
            //caso ocorra um erro relacionado ao banco de dados
            //exibe popup com erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //depois de executar o try dando erro ou não executa o finally
            gerenciador.fecharConexao(comando, resultado);
        }

        return false;
    }
}
