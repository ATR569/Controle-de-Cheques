/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import DAO.*;
import classes.*;
import javax.swing.JOptionPane;

import static classes.Utils.quotedStr;

/**
 *
 * @author Adson Macêdo
 * @author Thairam Michel
 * @author Ramon Rodrigues
 */
public class FrameCadastraConta extends javax.swing.JFrame {

    Conta conta;
    Cliente cliente;
    Dao<Cliente> daoCliente = new ClienteDao<>();
    Dao<Conta> daoConta = new ContaDao<>();

    /**
     * Creates new form FrameCadastraConta
     */
    public FrameCadastraConta() {
        this(new Conta());
    }

    public FrameCadastraConta(Conta conta) {
        initComponents();
        this.conta = conta;
        if (conta.getId() != 0) {
            this.setTitle("Alterar Conta");
            this.jBCadastrar.setText("Alterar");
            this.jTBanco.setText(conta.getBanco());
            this.jTAg.setText(conta.getAgencia() + "");
            this.jTCnt.setText(conta.getNumConta());
            this.jTCpf.setText(conta.getCliente().getCpf());
            this.jFNome.setText(conta.getCliente().getNome());
            this.jFTel.setText(conta.getCliente().getTelefone());
        } else {
            this.jTBanco.setText("");
            this.jTAg.setText("");
            this.jTCnt.setText("");
            this.jTCpf.setText("");
            this.jFNome.setText("");
            this.jFTel.setText("");
        }
    }

    public FrameCadastraConta(Cliente cliente) {
        initComponents();
        this.conta = new Conta();
        this.conta.setCliente(cliente);
        this.cliente = cliente;
        this.jTBanco.setText("");
        this.jTAg.setText("");
        this.jTCnt.setText("");

        if (cliente.getId() != 0) {
            this.jTCpf.setText(cliente.getCpf());
            this.jTCpf.setEditable(false);
            this.jFNome.setText(cliente.getNome());
            this.jFTel.setText(cliente.getTelefone());
        } else {
            this.jTCpf.setText("");
            this.jFNome.setText("");
            this.jFTel.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLBanco = new javax.swing.JLabel();
        jTBanco = new javax.swing.JTextField();
        jLAg = new javax.swing.JLabel();
        jTAg = new javax.swing.JTextField();
        jLCnt = new javax.swing.JLabel();
        jTCnt = new javax.swing.JTextField();
        jLCpf = new javax.swing.JLabel();
        jTCpf = new javax.swing.JFormattedTextField();
        jLNome = new javax.swing.JLabel();
        jFNome = new javax.swing.JTextField();
        jLTel = new javax.swing.JLabel();
        jFTel = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jBCadastrar = new javax.swing.JButton();
        jBFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Conta");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLBanco.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLBanco.setText("Banco:");

        jTBanco.setPreferredSize(new java.awt.Dimension(160, 22));

        jLAg.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLAg.setText("Agência:");

        jTAg.setPreferredSize(new java.awt.Dimension(160, 22));
        jTAg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTAgKeyReleased(evt);
            }
        });

        jLCnt.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLCnt.setText("Conta:");

        jTCnt.setPreferredSize(new java.awt.Dimension(160, 22));

        jLCpf.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLCpf.setText("CPF Emitente:");
        jLCpf.setPreferredSize(new java.awt.Dimension(85, 17));

        try {
            jTCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTCpf.setPreferredSize(new java.awt.Dimension(98, 22));
        jTCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCpfFocusLost(evt);
            }
        });

        jLNome.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLNome.setText("Nome:");

        jFNome.setEditable(false);
        jFNome.setPreferredSize(new java.awt.Dimension(250, 22));
        jFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFNomeActionPerformed(evt);
            }
        });

        jLTel.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLTel.setText("Telefone:");

        jFTel.setEditable(false);
        try {
            jFTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTel.setPreferredSize(new java.awt.Dimension(105, 24));
        jFTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLTel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLNome, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLAg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLCnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTAg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(jTCnt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(jTBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBanco)
                    .addComponent(jTBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAg)
                    .addComponent(jTAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCnt)
                    .addComponent(jTCnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTel)
                    .addComponent(jFTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBCadastrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jBFechar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jBFechar.setText("Fechar");
        jBFechar.setPreferredSize(new java.awt.Dimension(89, 25));
        jBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBCadastrar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFNomeActionPerformed

    private void jFTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTelActionPerformed

    private void jBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jBFecharActionPerformed

    private void jTCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCpfFocusLost

        if (jTBanco.getText().equals("") || jTAg.getText().equals("") || jTCnt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Banco, Agência e Número da conta são obrigatórios!", "Campos obrigatórios", JOptionPane.INFORMATION_MESSAGE);
            jTBanco.requestFocus();
        } else {
            String fields[] = {"cpf"};
            String values[] = {quotedStr(jTCpf.getText())};
            conta.setCliente(daoCliente.find(fields, values));

            if (conta.getCliente() != null) {
                jFNome.setText(conta.getCliente().getNome());
                jFTel.setText(conta.getCliente().getTelefone());
            } else {
                int opt = JOptionPane.showConfirmDialog(null, "Cliente não encontrado!\nDeseja Cadastrar um novo?", "Cliente não encontrado", JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    FrameCadastroCliente cadCliente = new FrameCadastroCliente();
                    cadCliente.setVisible(true);
                } else {
                    jTCpf.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_jTCpfFocusLost

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        if (jTBanco.getText().equals("") || jTAg.getText().equals("") || jTCnt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Dados Insuficientes", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                conta.setBanco(jTBanco.getText());
                conta.setAgencia(Utils.toInt(jTAg.getText()));
                conta.setNumConta(jTCnt.getText());                //quando é uma nova conta o id == 0
                if (conta.getId() == 0) {
                    daoConta.insert(conta);
                } else {
                    daoConta.update(conta);
                }
                
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Falha ao salvar!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                this.dispose();
            }
        }
    }//GEN-LAST:event_jBCadastrarActionPerformed

    public Conta getConta() {
        return conta;
    }

    private void jTAgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAgKeyReleased
        jTAg.setText(jTAg.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_jTAgKeyReleased

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
            java.util.logging.Logger.getLogger(FrameCadastraConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCadastraConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCadastraConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCadastraConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCadastraConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBFechar;
    private javax.swing.JTextField jFNome;
    private javax.swing.JFormattedTextField jFTel;
    private javax.swing.JLabel jLAg;
    private javax.swing.JLabel jLBanco;
    private javax.swing.JLabel jLCnt;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLTel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTAg;
    private javax.swing.JTextField jTBanco;
    private javax.swing.JTextField jTCnt;
    private javax.swing.JFormattedTextField jTCpf;
    // End of variables declaration//GEN-END:variables
}
