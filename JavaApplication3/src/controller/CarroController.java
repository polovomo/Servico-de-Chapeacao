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
     //TENTANDO PUXAR PARA TABELA ;ASS:BRUNO
    public List<Carro> consultar(int opcaoFiltro, String filtro) {
        String sql = "SELECT * from TBCARRO ";

        if (!filtro.equals("")) {

            if (opcaoFiltro == 0) {
                sql += " WHERE pk_carro = " + filtro;
            } else if (opcaoFiltro == 1) {
                sql += " WHERE modelo LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 2) {
                sql += " WHERE marca LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 3) {
                sql += " WHERE placa LIKE '%" + filtro + "%'";
            } else if (opcaoFiltro == 4) {
                sql += " WHERE ano_fabricacao LIKE '%" + filtro + "%'";
            }
        }

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //declara as variaveis como nulas antes do try
        //para poder usar no finally

        PreparedStatement comando = null;
        ResultSet resultado = null;

        //crio a lista de usuários, vazia ainda
        List<Carro> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
               Carro carro = new Carro();

                carro.setIdCarro(resultado.getInt("pk_carro"));
                carro.setModelo(resultado.getString("modelo"));
                carro.setMarca(resultado.getString("marca"));
                carro.setPlaca(resultado.getString("placa"));
                carro.setAnoFabricacao(resultado.getInt("ano_fabricacao"));

                lista.add(carro);

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
