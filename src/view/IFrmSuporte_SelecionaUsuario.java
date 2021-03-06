/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Usuario;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Urbanski
 */
public class IFrmSuporte_SelecionaUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFrmSuporte_SelecionaUsuario
     */
    private DefaultTableModel dtmUsuario = null;
    private Usuario usuario = new Usuario();
    private Iterator i = null;
    
    public void popularTabelaUsuario(String pesquisa, int filtro){
        dtmUsuario = (DefaultTableModel)tblSuporte_VincularUsuario_Usuario.getModel();
        dtmUsuario.setNumRows(0);
        
        if(filtro < 0){
            i = usuario.retornaUsuario();

            while(i.hasNext()){
                usuario = (Usuario)i.next();
                dtmUsuario.addRow(usuario.getUsuario());
            }
        }else{
            i = usuario.retornaUsuario(pesquisa, filtro);

            while(i.hasNext()){
                usuario = (Usuario)i.next();
                dtmUsuario.addRow(usuario.getUsuario());
            }
        }
    }
    
    public void vincularUsuario(){
        int linha = tblSuporte_VincularUsuario_Usuario.getSelectedRow();
        IFrmSuporte.usuario = new Usuario();
        
        if(linha >= 0){
            int id = Integer.valueOf(dtmUsuario.getValueAt(linha, 0).toString());
            IFrmSuporte.usuario = IFrmSuporte.usuario.retornaUsuario(id);
            IFrmSuporte.txtSuporte_NovoChamado_Atendente.setText(IFrmSuporte.usuario.getPessoa().getNome());
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um usuario para continuar!","ATENÇÃO",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public IFrmSuporte_SelecionaUsuario() {
        initComponents();
        popularTabelaUsuario(null, -1);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        txtSuporte_VincularUsuario_Pesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuporte_VincularUsuario_Usuario = new javax.swing.JTable();
        txtSuporte_VincularUsuario_Vincular = new javax.swing.JButton();
        cmbSuporte_VincularUsuario_Filtro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtSuporte_VincularUsuario_Fechar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Vincular Atendente");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/025-magnifier.png"))); // NOI18N

        txtSuporte_VincularUsuario_Pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSuporte_VincularUsuario_PesquisaKeyReleased(evt);
            }
        });

        tblSuporte_VincularUsuario_Usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "LOGIN", "DATA CADASTRO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSuporte_VincularUsuario_Usuario);

        txtSuporte_VincularUsuario_Vincular.setText("Vincular Usuario");
        txtSuporte_VincularUsuario_Vincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuporte_VincularUsuario_VincularActionPerformed(evt);
            }
        });

        cmbSuporte_VincularUsuario_Filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NOME", "CPF", "LOGIN" }));

        jLabel1.setText("Pesquisar Por");

        txtSuporte_VincularUsuario_Fechar.setText("Fechar");
        txtSuporte_VincularUsuario_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuporte_VincularUsuario_FecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSuporte_VincularUsuario_Vincular)
                        .addGap(66, 66, 66)
                        .addComponent(txtSuporte_VincularUsuario_Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSuporte_VincularUsuario_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSuporte_VincularUsuario_Filtro, 0, 157, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSuporte_VincularUsuario_Pesquisa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbSuporte_VincularUsuario_Filtro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSuporte_VincularUsuario_Vincular, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSuporte_VincularUsuario_Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSuporte_VincularUsuario_PesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSuporte_VincularUsuario_PesquisaKeyReleased
        if(txtSuporte_VincularUsuario_Pesquisa.getText().equals("")){
            popularTabelaUsuario(null, -1);
        }else{
            popularTabelaUsuario(txtSuporte_VincularUsuario_Pesquisa.getText(), cmbSuporte_VincularUsuario_Filtro.getSelectedIndex());
        }
    }//GEN-LAST:event_txtSuporte_VincularUsuario_PesquisaKeyReleased

    private void txtSuporte_VincularUsuario_VincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuporte_VincularUsuario_VincularActionPerformed
        vincularUsuario();
        dispose();
    }//GEN-LAST:event_txtSuporte_VincularUsuario_VincularActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        if(txtSuporte_VincularUsuario_Pesquisa.getText().equals("")){
            popularTabelaUsuario(null, -1);
        }else{
            popularTabelaUsuario(txtSuporte_VincularUsuario_Pesquisa.getText(), cmbSuporte_VincularUsuario_Filtro.getSelectedIndex());
        }
    }//GEN-LAST:event_formComponentShown

    private void txtSuporte_VincularUsuario_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuporte_VincularUsuario_FecharActionPerformed
       dispose();
    }//GEN-LAST:event_txtSuporte_VincularUsuario_FecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbSuporte_VincularUsuario_Filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSuporte_VincularUsuario_Usuario;
    private javax.swing.JButton txtSuporte_VincularUsuario_Fechar;
    private javax.swing.JTextField txtSuporte_VincularUsuario_Pesquisa;
    private javax.swing.JButton txtSuporte_VincularUsuario_Vincular;
    // End of variables declaration//GEN-END:variables
}
