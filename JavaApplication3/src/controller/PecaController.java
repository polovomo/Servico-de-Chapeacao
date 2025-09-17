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
import model.Peca;

/**
 *
 * @author aluno.saolucas
 */
public class PecaController {

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

    //TENTANDO PUXAR PARA TABELA ;ASS:BRUNO
    public List<Peca> consultar(int opcaoFiltro, String filtro) {
        String sql = "SELECT * from TBPECA ";

        if (!filtro.equals("")) {

            if (opcaoFiltro == 0) {
                sql += " WHERE pk_peca = " + filtro;
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
        List<Peca> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
                Peca pec = new Peca();

                pec.setIdPeca(resultado.getInt("pk_peca"));
                pec.setNome(resultado.getString("nome"));
                pec.setDescricao(resultado.getString("descricao"));
                pec.setValorUnitario(resultado.getDouble("valor_unitario"));

                lista.add(pec);

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
}
