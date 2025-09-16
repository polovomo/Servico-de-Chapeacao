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
import model.Cliente;
import model.OrdemServico;
import model.Peca;
import model.Servico;
import utils.Util;

/**
 *
 * @author Administrador
 */
public class UsuarioController {
    
    //inserindo cliente no banco
    public boolean inserir(Cliente cli) {
        String sql = "INSERT INTO tbclientes(nome, telefone, email, telefone, fk_carro) VALUES (?,?,?,?,?)";

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
            comando.setString(4, cli.getTelefone());
            comando.setInt(5, cli.getFkCarro());
            
            
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
    //inserindo serviço no banco
    public boolean inserir(Servico servico) {
    String sql = "INSERT INTO Servico (descricao, valor_unitario) VALUES (?, ?)";

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;

    try {
        comando = gerenciador.prepararComando(sql);

        // Definindo os valores para os placeholders (?)
        comando.setString(1, servico.getDescricao());
        comando.setDouble(2, servico.getValorUnitario());

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
    
    
    public boolean inserir(Peca pec) {
        String sql = "INSERT INTO tbpeca(nome, descricao, valor_unitario) VALUES (?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            //define o valor decada variável(?) pela posição em que aparece no sql
            comando.setString(1, pec.getNome());
            comando.setString(2, pec.getDescricao());
            comando.setDouble(3, pec.getValorUnitario());
            

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
    
    public boolean inserir(OrdemServico ordemServico) {
    String sql = "INSERT INTO Ordem_Servico (status, valor_total, fk_cliente, fk_servico, fk_carro) VALUES (?, ?, ?, ?, ?)";

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;

    try {
        comando = gerenciador.prepararComando(sql);

        // Definindo os valores para os placeholders (?)
        comando.setString(1, ordemServico.getStatus());
        comando.setDouble(2, ordemServico.getValorTotal());
        comando.setInt(3, ordemServico.getFkCliente()); // Chave estrangeira Cliente
        comando.setInt(4, ordemServico.getFkServico()); // Chave estrangeira Servico
        comando.setInt(5, ordemServico.getFkCarro());   // Chave estrangeira Carro

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
