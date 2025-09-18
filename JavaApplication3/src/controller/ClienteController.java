/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author aluno.saolucas
 */
public class ClienteController {

    //inserindo cliente no banco
    public boolean inserir(Cliente cli) {
        String sql = "INSERT INTO tbcliente(nome, telefone, email, endereco) VALUES (?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            //define o valor decada variável(?) pela posição em que aparece no sql
            comando.setString(1, cli.getNome());
            comando.setString(2, cli.getTelefone());
            comando.setString(3, cli.getEmail());
            comando.setString(4, cli.getEndereco());

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

    //TENTANDO PUXAR PARA TABELA ;ASS:BRUNO
    public List<Cliente> consultar(int opcaoFiltro, String filtro) {
        String sql = "SELECT * from TBCLIENTE ";

        if (!filtro.equals("")) {

            if (opcaoFiltro == 0) {
                sql += " WHERE pk_cliente = " + filtro;
            } else if (opcaoFiltro == 1) {
                sql += " WHERE nome LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 2) {
                sql += " WHERE email LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 3) {
                sql += " WHERE telefone LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 4) {
                sql += " WHERE endereco LIKE '%" + filtro + "%'";
            }
        }

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        //crio a lista de usuários, vazia ainda
        List<Cliente> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
                Cliente cli = new Cliente();

                cli.setIdCliente(resultado.getInt("pk_cliente"));
                cli.setNome(resultado.getString("nome"));
                cli.setEmail(resultado.getString("email"));
                cli.setTelefone(resultado.getString("telefone"));
                cli.setEndereco(resultado.getString("endereco"));

                lista.add(cli);

            }

        } catch (SQLException e) {
            //caso ocorra um erro relacionado ao banco de dados
            //exibe popup com erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //depois de executar o try dando erro ou não executa o finally
            gerenciador.fecharConexao(comando, resultado);
        }

        return lista;
    }

    public boolean alterar(Cliente cli) {
    String sql = "UPDATE tbcliente SET "
            + " nome = ?, " //1
            + " telefone = ?, " //2
            + "email = ?, " //3
            + "endereco = ? "//4
            + "WHERE pk_cliente = ? " ;//5
            

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;

    try {
        // Preparando o comando SQL
        comando = gerenciador.prepararComando(sql);
        
        // Definindo os parâmetros para a execução
        
        comando.setString(1, cli.getNome());
        comando.setString(2, cli.getTelefone());
        comando.setString(3, cli.getEmail());
        comando.setString(4, cli.getEndereco());
        comando.setInt(5, cli.getIdCliente()); 
        

        // Executa a atualização no banco de dados
        comando.executeUpdate();

        return true;

    } catch (SQLException e) {
        // Se ocorrer algum erro no banco de dados, exibe uma mensagem de erro
        JOptionPane.showMessageDialog(null, e.getMessage());
    } finally {
        // Fechando a conexão no bloco finally
        gerenciador.fecharConexao(comando, resultado);
    }

    return false;
}
    
}
