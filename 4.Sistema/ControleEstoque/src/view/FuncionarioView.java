package view;

import controller.FuncionarioController;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Login;
import utils.Mensagens;
import utils.exceptions.ExcluirUnicoAdministrador;
import utils.exceptions.UserInexistente;

/**
 *
 * @author Nelson
 */
public class FuncionarioView extends javax.swing.JFrame {

    private final FuncionarioController controller = new FuncionarioController();

    private boolean insercao = false;
    private String userAntigo;

    /**
     * Creates new form FuncionarioView
     */
    public FuncionarioView() {
        initComponents();
        initController();

        try {
            controller.atualizarTabela();
        } catch (SQLException ex) {
            Mensagens.exibirErro(ex.getMessage());
        }
    }

    private void initController() {
        controller.setView(this);
    }

    /**
     * Adicionar um funcionario à tabela de exibição.
     *
     * @param funcionario
     */
    public void adicionarFuncionario(Funcionario funcionario) {
        DefaultTableModel model = (DefaultTableModel) jTabela.getModel();
        model.addRow(new Object[]{funcionario.getNome(), funcionario.getCpf(),
            funcionario.getFuncaoString(), funcionario.getLogin().getUser()});
    }

    public void limparFuncionarios() {
        DefaultTableModel model = (DefaultTableModel) jTabela.getModel();
        model.setRowCount(0);
    }

    /**
     * Exibe a janela de detalhes para um funcionário.
     *
     * @param funcionario
     * @param insercao
     */
    public void exibirDetalhes(Funcionario funcionario, boolean insercao) {
        jNomeField.setText(funcionario.getNome());
        jCpfField.setText(funcionario.getCpf());
        jFuncaoCombo.setSelectedItem(funcionario.getFuncaoString());
        jUserField.setText(funcionario.getLogin().getUser());
        jSenhaField.setText(funcionario.getLogin().getSenha());
        userAntigo = funcionario.getLogin().getUser();

        this.insercao = insercao;
        if (insercao) {
            jDetalhesDialog.setTitle("Inserção");
        } else {
            jDetalhesDialog.setTitle("Detalhes");
        }

        jDetalhesDialog.setSize(500, 180);
        jDetalhesDialog.setLocationRelativeTo(null);
        jDetalhesDialog.setVisible(true);
    }

    public void ocultarDetalhes() {
        jDetalhesDialog.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDetalhesDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jNomeField = new javax.swing.JTextField();
        jUserField = new javax.swing.JTextField();
        jCpfField = new javax.swing.JTextField();
        jFuncaoCombo = new javax.swing.JComboBox<>();
        jSenhaField = new javax.swing.JPasswordField();
        jConfirmarButton = new javax.swing.JButton();
        jCancelarButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTabelaScrollPane = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jInserirButton = new javax.swing.JButton();
        jDetalharButton = new javax.swing.JButton();
        jExcluirButton = new javax.swing.JButton();

        jDetalhesDialog.setTitle("Detalhes");
        jDetalhesDialog.setMinimumSize(new java.awt.Dimension(500, 175));
        jDetalhesDialog.setModal(true);
        jDetalhesDialog.setPreferredSize(new java.awt.Dimension(500, 175));
        jDetalhesDialog.setResizable(false);

        jLabel1.setText("Nome");

        jLabel2.setText("CPF");

        jLabel3.setText("Função");

        jLabel4.setText("Usuário");

        jLabel5.setText("Senha");

        jFuncaoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "OPERADOR", "GESTOR" }));

        jConfirmarButton.setText("Confirmar");
        jConfirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmarButtonActionPerformed(evt);
            }
        });

        jCancelarButton.setText("Cancelar");
        jCancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDetalhesDialogLayout = new javax.swing.GroupLayout(jDetalhesDialog.getContentPane());
        jDetalhesDialog.getContentPane().setLayout(jDetalhesDialogLayout);
        jDetalhesDialogLayout.setHorizontalGroup(
            jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDetalhesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDetalhesDialogLayout.createSequentialGroup()
                        .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCpfField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jNomeField)
                            .addComponent(jFuncaoCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUserField, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jSenhaField)))
                    .addGroup(jDetalhesDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCancelarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jConfirmarButton)))
                .addContainerGap())
        );
        jDetalhesDialogLayout.setVerticalGroup(
            jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDetalhesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jNomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSenhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFuncaoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jDetalhesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jConfirmarButton)
                    .addComponent(jCancelarButton))
                .addContainerGap())
        );

        jDetalhesDialog.getAccessibleContext().setAccessibleParent(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu de Administrador");
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel1.setMinimumSize(new java.awt.Dimension(150, 100));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 600));

        jToggleButton1.setSelected(true);
        jToggleButton1.setText("Funcionários");
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToggleButton1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabela.setAutoCreateRowSorter(true);
        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Função", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTabela.setToolTipText("");
        jTabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTabelaScrollPane.setViewportView(jTabela);
        jTabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jInserirButton.setText("Inserir");
        jInserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInserirButtonActionPerformed(evt);
            }
        });

        jDetalharButton.setText("Detalhar");
        jDetalharButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDetalharButtonActionPerformed(evt);
            }
        });

        jExcluirButton.setText("Excluir");
        jExcluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcluirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabelaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDetalharButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jExcluirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jInserirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jInserirButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jDetalharButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jExcluirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabelaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jInserirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInserirButtonActionPerformed
        try {
            controller.inserirFuncionario();
        } catch (SQLException ex) {
            Mensagens.exibirErro(ex.getMessage());
        }
    }//GEN-LAST:event_jInserirButtonActionPerformed

    private void jDetalharButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDetalharButtonActionPerformed
        int linhaSelecionada = jTabela.getSelectedRow();
        if (linhaSelecionada == -1) {
            Mensagens.exibirAviso("Nenhum item selecionado.");
            return;
        }

        try {
            String user = (String) jTabela.getValueAt(linhaSelecionada, 3);
            controller.detalharFuncionario(user);
        } catch (SQLException | UserInexistente ex) {
            Mensagens.exibirErro(ex.getMessage());
            System.exit(1);
        }
    }//GEN-LAST:event_jDetalharButtonActionPerformed

    private void jExcluirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirButtonActionPerformed
        int linhaSelecionada = jTabela.getSelectedRow();
        if (linhaSelecionada == -1) {
            Mensagens.exibirAviso("Nenhum item selecionado.");
            return;
        }

        try {
            String nome = (String) jTabela.getValueAt(linhaSelecionada, 0);
            String user = (String) jTabela.getValueAt(linhaSelecionada, 3);
            String funcao = (String) jTabela.getValueAt(linhaSelecionada, 2);
            controller.excluirFuncionario(nome, user, funcao);
        } catch (SQLException | ExcluirUnicoAdministrador ex) {
            Mensagens.exibirErro(ex.getMessage());
        }
    }//GEN-LAST:event_jExcluirButtonActionPerformed

    private void jCancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarButtonActionPerformed
        jDetalhesDialog.setVisible(false);
    }//GEN-LAST:event_jCancelarButtonActionPerformed

    private void jConfirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmarButtonActionPerformed
        Funcionario f = new Funcionario();
        f.setCpf(jCpfField.getText());
        f.setNome(jNomeField.getText());
        f.setLogin(new Login(jUserField.getText(),
                new String(jSenhaField.getPassword())));
        f.setFuncao((String) jFuncaoCombo.getSelectedItem());
        try {
            controller.salvarFuncionario(userAntigo, f, insercao);
        } catch (SQLException | ExcluirUnicoAdministrador ex) {
            Mensagens.exibirErro(ex.getMessage());
        }
    }//GEN-LAST:event_jConfirmarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCancelarButton;
    private javax.swing.JButton jConfirmarButton;
    private javax.swing.JTextField jCpfField;
    private javax.swing.JButton jDetalharButton;
    private javax.swing.JDialog jDetalhesDialog;
    private javax.swing.JButton jExcluirButton;
    private javax.swing.JComboBox<String> jFuncaoCombo;
    private javax.swing.JButton jInserirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jNomeField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jSenhaField;
    private javax.swing.JTable jTabela;
    private javax.swing.JScrollPane jTabelaScrollPane;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jUserField;
    // End of variables declaration//GEN-END:variables

}
