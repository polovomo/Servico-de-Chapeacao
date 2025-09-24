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
import model.Carro;
import model.Cliente;
import model.OrdemServico;
import model.Peca;

/**
 *
 * @author aluno.saolucas
 */
public class OsController {

    public boolean inserir(OrdemServico os) {
        String sql = "INSERT INTO tbordemservico (fk_cliente, fk_carro) VALUES (?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            //define o valor decada variável(?) pela posição em que aparece no sql
            comando.setInt(1, os.getFkCliente());
            comando.setInt(2, os.getFkCarro());

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

    public int selecionarUltimaPk() {
        String sql = "SELECT pk_ordem from tbordemservico ORDER BY pk_ordem DESC LIMIT 1";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        int pk_ordem=0;

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {

                pk_ordem = resultado.getInt("pk_ordem");

            }

        } catch (SQLException e) {
            //caso ocorra um erro relacionado ao banco de dados
            //exibe popup com erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //depois de executar o try dando erro ou não executa o finally
            gerenciador.fecharConexao(comando, resultado);
        }

        return pk_ordem;
    }
    
     public List<OrdemServico> consultar(int opcaoFiltro, String filtro) {
        String sql = "SELECT * from TBORDEMSERVICO "
                + "INNER JOIN TBCLIENTE"
                + " ON TBCLIENTE.PK_CLIENTE = TBORDEMSERVICO.FK_CLIENTE "
                + " INNER JOIN TBCARRO"
                + " ON TBCARRO.PK_CARRO = TBORDEMSERVICO.FK_CARRO "
                ;

        if (!filtro.equals("")) {

            if (opcaoFiltro == 0) {
                sql += " WHERE pk_ordem = " + filtro;
            } else if (opcaoFiltro == 1) {
                sql += " WHERE TBCLIENTE.nome LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 2) {
                sql += " WHERE TBCARRO.modelo LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 3) {
                sql += " WHERE TBCARRO.placa LIKE '%" + filtro + "%'";
            } 
        }

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        //crio a lista de usuários, vazia ainda
        List<OrdemServico> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
                OrdemServico os= new OrdemServico();
                
                
                
                os.setIdOrdemServico(resultado.getInt("pk_ordem"));
                os.setNomeCliente(resultado.getString("nome"));
                os.setModeloCarrro(resultado.getString("modelo"));
                os.setPlacaCarro(resultado.getString("placa"));

                lista.add(os);

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
