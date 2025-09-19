/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Servico;

/**
 *
 * @author aluno.saolucas
 */
public class ServicoController {
    //inserindo serviço no banco
    public boolean inserir(Servico servico) {
    String sql = "INSERT INTO TBSERVICO (descricao, valor_unitario, nome) VALUES (?,?,?)";

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;

    try {
        comando = gerenciador.prepararComando(sql);

 
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
    //TENTANDO PUXAR PARA TABELA ;ASS:BRUNO
    public List<Servico> consultar(int opcaoFiltro, String filtro) {
        String sql = "SELECT * from TBSERVICO ";

        if (!filtro.equals("")) {

            if (opcaoFiltro == 0) {
                sql += " WHERE pk_servico = " + filtro;
            } else if (opcaoFiltro == 1) {
                sql += " WHERE nome LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 2) {
                sql += " WHERE descricao LIKE '%" + filtro + "%'";
            } 
        }

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        //crio a lista de usuários, vazia ainda
        List<Servico> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
                Servico ser = new Servico();

                ser.setIdServico(resultado.getInt("pk_servico"));
                ser.setNomeServico(resultado.getString("nome"));
                ser.setDescricao(resultado.getString("descricao"));
                ser.setValorUnitario(resultado.getDouble("valor_unitario"));

                lista.add(ser);

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
    
    
    public boolean alterar(Servico ser) {
    String sql = "UPDATE TBSERVICO SET "
            + "nome = ?, "
            + "descricao = ?, "
            + "valor_unitario = ? "
            + "WHERE pk_servico = ?";
            

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;

    try {
        // Preparando o comando SQL
        comando = gerenciador.prepararComando(sql);
        
        // Definindo os parâmetros para a execução
        
       comando.setString(1, ser.getNomeServico());
        comando.setString(2, ser.getDescricao());
        comando.setDouble(3, ser.getValorUnitario());
        comando.setInt(4, ser.getIdServico());  
        

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
