/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import DAO.ContaDao;
import DAO.Dao;
import classes.Conta;
import classes.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thairam Michel
 */
public class FrameConta extends javax.swing.JFrame {

    ArrayList<Conta> lista;
    Dao<Conta> daoConta = new ContaDao<>();
    Cliente cliente;

    /**
     * Creates new form FrameConta
     */
    public FrameConta() {
        initComponents();
    }

    public FrameConta(Cliente c) {
        this();
        this.cliente = c;
        this.jLNome.setText(c.getNome());
        updateLista("SELECT * FROM conta WHERE conta.id_cliente = " + this.cliente.getId());
    }

    private void updateLista(String sql) {
        lista = daoConta.query(sql);
        DefaultTableModel modelo = (DefaultTableModel) jTableConta.getModel();
        modelo.setRowCount(0);
        for (Conta c : lista) {
            modelo.addRow(new Object[]{c.getBanco(), c.getAgencia(), c.getNumConta()});
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
        jLNome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConta = new javax.swing.JTable();
        jBUpdateLista = new javax.swing.JButton();
        jBAlterConta = new javax.swing.JButton();
        jNewConta = new javax.swing.JButton();
        jBDelConta = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome do Cliente"));

        jLNome.setText("Thairam Michel Santos Ataíde");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLNome)
                .addContainerGap())
        );

        jTableConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Banco", "Agência", "Número da Conta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConta);

        jBUpdateLista.setText("Atualizar Lista");
        jBUpdateLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBUpdateLista))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBUpdateLista)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jBAlterConta.setText("Alterar Conta");
        jBAlterConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterContaActionPerformed(evt);
            }
        });

        jNewConta.setText("Nova Conta");
        jNewConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewContaActionPerformed(evt);
            }
        });

        jBDelConta.setText("Excluir Conta");
        jBDelConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDelContaActionPerformed(evt);
            }
        });

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBSair)
                        .addGap(18, 18, 18)
                        .addComponent(jBAlterConta)
                        .addGap(10, 10, 10)
                        .addComponent(jNewConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBDelConta))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAlterConta)
                    .addComponent(jNewConta)
                    .addComponent(jBDelConta)
                    .addComponent(jBSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBAlterContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterContaActionPerformed
        int id = jTableConta.getSelectedRow();
        if (id >= 0) {
            Conta conta = lista.get(id);
            FrameCadastraConta fraConta = new FrameCadastraConta(conta);
            fraConta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Não há item selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBAlterContaActionPerformed

    private void jNewContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewContaActionPerformed
        FrameCadastraConta conta = new FrameCadastraConta(this.cliente);
        conta.setVisible(true);
    }//GEN-LAST:event_jNewContaActionPerformed

    private void jBDelContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDelContaActionPerformed
        int id = jTableConta.getSelectedRow();
        if (id >= 0) {
            Conta conta = lista.get(id);
            if (JOptionPane.showConfirmDialog(null, "Deseja EXCLUIR a conta " + conta.getNumConta() + "\ndo cliente " + conta.getCliente().getNome() + " permanentemente?", "Excluir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                daoConta.delete(conta);
                updateLista("SELECT * FROM conta WHERE conta.id_cliente = " + this.cliente.getId());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há item selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBDelContaActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBUpdateListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateListaActionPerformed
        // TODO add your handling code here:
        updateLista("SELECT * FROM conta WHERE conta.id_cliente = " + this.cliente.getId());
    }//GEN-LAST:event_jBUpdateListaActionPerformed

    private void jTableContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContaMouseClicked
        Conta conta = lista.get(jTableConta.getSelectedRow());
        Cliente emitente = conta.getCliente();

        jLNome.setText(emitente.getNome());
    }//GEN-LAST:event_jTableContaMouseClicked

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
            java.util.logging.Logger.getLogger(FrameConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterConta;
    private javax.swing.JButton jBDelConta;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBUpdateLista;
    private javax.swing.JLabel jLNome;
    private javax.swing.JButton jNewConta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConta;
    // End of variables declaration//GEN-END:variables
}
