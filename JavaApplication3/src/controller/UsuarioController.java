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

/**
 *
 * @author aluno.saolucas
 */
public class UsuarioController {
    
     public boolean autentificao(String email, String senha) {
        // Comando SQL para verificar se existe um usuário ativo com o email e senha informados
        String sql = "SELECT * from TBUSUARIO "
                + "WHERE email = ? and senha = ? "
              ;

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            // Prepara o comando SQL para execução
            comando = gerenciador.prepararComando(sql);

            // Define os parâmetros do comando SQL para evitar SQL Injection
            comando.setString(1, email);
            comando.setString(2, senha);

            // Executa a consulta no banco de dados
            resultado = comando.executeQuery();

            // Verifica se retornou algum resultado (usuário encontrado e ativo)
            if (resultado.next()) {
                return true; // Autenticação bem-sucedida
            }
        } catch (SQLException e) {
            // Em caso de erro, exibe uma mensagem para o usuário
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            // Fecha recursos de banco de dados para evitar vazamentos
            gerenciador.fecharConexao(comando, resultado);
        }

        // Se não encontrou o usuário ou ocorreu algum problema, retorna false
        return false;
    }

}
