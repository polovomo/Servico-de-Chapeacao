/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CarroController;
import controller.ClienteController;
import controller.OsController;
import controller.OsControllerPecas;
import controller.OsControllerServicos;
import controller.PecaController;
import controller.ServicoController;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Carro;
import model.Cliente;
import model.OrdemServico;
import model.OrdemServicoPecas;
import model.OrdemServicoServicos;
import model.Peca;
import model.Servico;

/**
 *
 * @author aluno.saolucas
 */
public class FrCadOrdem extends javax.swing.JDialog {

    /**
     * Creates new form FrCadOrdem
     */
    public FrCadOrdem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

    }

    private void salvarOrdemServico() {
        // Carregar clientes
        ClienteController clienteController = new ClienteController();
        List<Cliente> listaClientes = clienteController.consultar(1, ""); // Sem filtro

        // Carregar carros
        CarroController carroController = new CarroController();
        List<Carro> listaCarros = carroController.consultar(1, ""); // Sem filtro

        // Carregar peças
        PecaController pecaController = new PecaController();
        List<Peca> listaPecas = pecaController.consultar(1, ""); // Sem filtro

        // Carregar serviços
        ServicoController servicoController = new ServicoController();
        List<Servico> listaServico = servicoController.consultar(1, ""); // Sem filtro

        // Exibir clientes na tabela
        DefaultTableModel modeloClientes = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "Telefone", "Endereço"});
        for (Cliente cli : listaClientes) {
            modeloClientes.addRow(new Object[]{cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getEndereco()});
        }
        tblClientes1.setModel(modeloClientes);

        // Exibir carros na tabela
        DefaultTableModel modeloCarros = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Modelo", "Marca", "Placa"});
        for (Carro car : listaCarros) {
            modeloCarros.addRow(new Object[]{car.getIdCarro(), car.getModelo(), car.getMarca(), car.getPlaca()});
        }
        tblCarros1.setModel(modeloCarros);  // Corrigido para tblCarros1

        for (Peca peca : listaPecas) {
            cbxPecas.addItem(peca);
        }

        for (Servico servico : listaServico) {
            cbxServico.addItem(servico);
        }
        DefaultTableModel modeloTabela = (DefaultTableModel) tblPecas.getModel();
        modeloTabela.setNumRows(0);

        DefaultTableModel modeloTabelas = (DefaultTableModel) tblServicos.getModel();
        modeloTabelas.setNumRows(0);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCarros1 = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbxPecas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxServico = new javax.swing.JComboBox<>();
        btnAddSer = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Ordem de Serviço");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setText("CADASTRO DE ORDEM DE SERVIÇO");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11108091_flickr_online_social_media_icon.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 60, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2203520_circle_dot_record_round_icon.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -60, 70, 100));

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Preço Unitário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblServicos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, 80));

        tblClientes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblClientes1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 80));

        jLabel1.setText("PEÇAS:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel2.setText("CLIENTES:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel3.setText("CARROS:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        btnAdd.setBackground(new java.awt.Color(234, 106, 106));
        btnAdd.setText("ADICIONAR");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        tblCarros1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Modelo", "Marca", "Placa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblCarros1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 80));

        btnSalvar.setBackground(new java.awt.Color(234, 106, 106));
        btnSalvar.setText("SALVAR");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, -1, -1));

        jButton2.setBackground(new java.awt.Color(234, 106, 106));
        jButton2.setText("VOLTAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 590, -1, -1));

        jPanel1.add(cbxPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 170, -1));

        jLabel4.setText("SERVIÇOS:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));
        jPanel1.add(cbxServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 170, -1));

        btnAddSer.setBackground(new java.awt.Color(234, 106, 106));
        btnAddSer.setText("ADICIONAR");
        btnAddSer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddSerMouseClicked(evt);
            }
        });
        jPanel1.add(btnAddSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Preço Unitário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblPecas);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, 80));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2203520_circle_dot_record_round_icon.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 70, 100));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2203520_circle_dot_record_round_icon.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 610, 70, 100));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11108091_flickr_online_social_media_icon.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 630, 60, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11108091_flickr_online_social_media_icon.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 50, 70));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11108091_flickr_online_social_media_icon.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 60, 70));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2203520_circle_dot_record_round_icon.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 70, 100));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11108091_flickr_online_social_media_icon.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 60, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        salvarOrdemServico();

    }//GEN-LAST:event_formWindowOpened

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked

        Peca item = (Peca) cbxPecas.getSelectedItem();
        if (item == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma peça selecionada!");
            return;
        }
        DefaultTableModel modeloTabela = (DefaultTableModel) tblPecas.getModel();
        modeloTabela.addRow(new Object[]{
            item,
            item.getValorUnitario()
        });


    }//GEN-LAST:event_btnAddMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddSerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddSerMouseClicked
        Servico item = (Servico) cbxServico.getSelectedItem();
        if (item == null) {
            JOptionPane.showMessageDialog(this, "Nenhum serviço selecionada!");
            return;
        }
        DefaultTableModel modeloTabelas = (DefaultTableModel) tblServicos.getModel();
        modeloTabelas.addRow(new Object[]{
            item,
            item.getValorUnitario()
        });
    }//GEN-LAST:event_btnAddSerMouseClicked

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked

        gravar();

    }//GEN-LAST:event_btnSalvarMouseClicked

    private void gravar() {
        // Verificação se as tabelas possuem uma linha selecionada
        if (tblClientes1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um cliente.");
            return;
        }

        if (tblCarros1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um carro.");
            return;
        }

        // Obter dados dos campos
        int clienteSelecionado = (int) tblClientes1.getValueAt(tblClientes1.getSelectedRow(), 0); // Selecionar o cliente da tabela
        int carroSelecionado = (int) tblCarros1.getValueAt(tblCarros1.getSelectedRow(), 0); // Selecionar o carro da tabela

        // Criar a ordem de serviço
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setFkCliente(clienteSelecionado);
        ordemServico.setFkCarro(carroSelecionado);

        OsController controller = new OsController();
        controller.inserir(ordemServico);
        int idOrdem = controller.selecionarUltimaPk();

        if (idOrdem <= 0) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar a ordem de serviço. Tente novamente.");
            return;
        }

        OsControllerPecas control = new OsControllerPecas();

        DefaultTableModel modeloPecas = (DefaultTableModel) tblPecas.getModel();
        for (int i = 0; i < modeloPecas.getRowCount(); i++) {
            Object pecaObj = modeloPecas.getValueAt(i, 0);
            Peca peca = (Peca) pecaObj;
            OrdemServicoPecas osp = new OrdemServicoPecas();
            osp.setIdOrdemServico(idOrdem);
            osp.setIdPeca(peca.getIdPeca());

            control.inserir(osp); // Método para associar a peça à ordem de serviço

        }

        OsControllerServicos controll = new OsControllerServicos();

        // Verificar e associar os serviços
        DefaultTableModel modeloServicos = (DefaultTableModel) tblServicos.getModel();
        for (int i = 0; i < modeloServicos.getRowCount(); i++) {
            Object servicoObj = modeloServicos.getValueAt(i, 0);
            Servico servico = (Servico) servicoObj;
            OrdemServicoServicos oss = new OrdemServicoServicos();
            oss.setIdOrdemServico(idOrdem);
            oss.setIdServico(servico.getIdServico());

            controll.inserir(oss); // Método para associar o serviço à ordem de serviço
            
           
            JOptionPane.showMessageDialog(null, "Ordem Salva com Sucesso!");
            this.dispose();
        }

    }
    
    
    

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
            java.util.logging.Logger.getLogger(FrCadOrdem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrCadOrdem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrCadOrdem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrCadOrdem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrCadOrdem dialog = new FrCadOrdem(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddSer;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Peca> cbxPecas;
    private javax.swing.JComboBox<Servico> cbxServico;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblCarros1;
    private javax.swing.JTable tblClientes1;
    private javax.swing.JTable tblPecas;
    private javax.swing.JTable tblServicos;
    // End of variables declaration//GEN-END:variables
}
