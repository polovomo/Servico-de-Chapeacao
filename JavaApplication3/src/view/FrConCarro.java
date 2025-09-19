/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CarroController;
import controller.ClienteController;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Carro;
import model.Cliente;
import utils.Util;

/**
 *
 * @author aluno.saolucas
 */
public class FrConCarro extends javax.swing.JDialog {

    /**
     * Creates new form FrConCarro
     */
    public FrConCarro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
    }

    private void pesquisar() {
        //pega o modelo da grade com suas colunas
        DefaultTableModel modeloTabela = (DefaultTableModel) tblCarros.getModel();

        //limpa a grade setando o numero de linhas para zero
        modeloTabela.setNumRows(0);

        int opcaoFiltro = cbxFiltro.getSelectedIndex();
        String filtro = edtFiltro.getText();

        //consultar banco de dados
        CarroController controler = new CarroController();

        List<Carro> listaCarros = controler.consultar(opcaoFiltro, filtro);

        //preencher a grade
        for (Carro car : listaCarros) {
            Object[] linha = {
                car.getIdCarro(), //0
                car.getModelo(), //1
                car.getMarca(), //2
                car.getPlaca(), //3
                car.getAnoFabricacao() //4
            };

            modeloTabela.addRow(linha);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarros = new javax.swing.JTable();
        cbxFiltro = new javax.swing.JComboBox<>();
        edtFiltro = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta De Carros");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Modelo", "Marca", "Placa", "Ano de Fabricação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCarros);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 123, 568, 134));

        cbxFiltro.setBackground(new java.awt.Color(234, 106, 106));
        cbxFiltro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID igual a", "Modelo contendo", "Marca contendo", "Placa contendo", "Ano fabricação contendo" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel2.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 63, 103, -1));

        edtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFiltroActionPerformed(evt);
            }
        });
        jPanel2.add(edtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 64, 336, -1));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setText("CONSULTA DE CARROS");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 13, -1, -1));

        btnPesquisar.setBackground(new java.awt.Color(234, 106, 106));
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 60, -1, -1));

        btnVoltar.setBackground(new java.awt.Color(234, 106, 106));
        btnVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });
        jPanel2.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 275, -1, -1));

        btnAlterar.setBackground(new java.awt.Color(234, 106, 106));
        btnAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAlterar.setText("ALTERAR CARRO");
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 275, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11108091_flickr_online_social_media_icon.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 60, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2203520_circle_dot_record_round_icon.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 300, 70, 100));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2203520_circle_dot_record_round_icon.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, -50, 70, 100));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11108091_flickr_online_social_media_icon.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 60, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setIconImage(Util.getIcone());
        
        
        
        
    }//GEN-LAST:event_formWindowOpened

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void edtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtFiltroActionPerformed

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        pesquisar();
    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked

        //valido de tem alguma linha selecionada na grade = -1
        if (tblCarros.getSelectedRow() == -1) {
            return;
        }
        //pego numero da linha selecionada
        int posicaoLinha = tblCarros.getSelectedRow();

        //pego o valor da celula na grade, na coluna 0(codigo)
        String celula = tblCarros.getValueAt(posicaoLinha, 0).toString();

        int idCarro = Integer.parseInt(celula);

        FrAltCarro telaAlterar = new FrAltCarro(null, rootPaneCheckingEnabled);
        //passso pra tela de cadastro

        telaAlterar.setIdCarro(idCarro);

        telaAlterar.setVisible(true);

        //quando fechar a janela de alterar vai continuar aqui
        //refazendo a pesquisa da grade para atualizar
        pesquisar();
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

    }//GEN-LAST:event_btnAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrConCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrConCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrConCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrConCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrConCarro dialog = new FrConCarro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JTextField edtFiltro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblCarros;
    // End of variables declaration//GEN-END:variables
}
