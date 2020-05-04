/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.Relacionado;

/**
 *
 * @author David
 */
public class RelacionadoIG extends javax.swing.JInternalFrame {

    /** Creates new form RelacionadoIG2 */
    
    private DefaultTableModel mTabla;
    private DefaultComboBoxModel mCiudad;
    public RelacionadoIG() {
        initComponents();
        mTabla =(DefaultTableModel) tblPersonas.getModel();
        cmbDepar.setActionCommand("depar");
        dpkFechaDiag.setFormats("dd-MM-yyyy");
        cmbDepar.setActionCommand("depar");
        mCiudad=(DefaultComboBoxModel) cmbCiudad.getModel();
    }
    
      public String getId(){
        return txtId.getText().trim();
    }
    
    public String getNombre(){
        return txtNombre.getText().trim();
    }
    
    
    
    public int getEdad(){
        return Integer.parseInt(txtEdad.getText().trim());
    }
    
    public char getSexo(){
        return cmbSexo.getSelectedItem().toString().charAt(0);
    }
    
    public int getDeparSelected(){
        return cmbDepar.getSelectedIndex();
    }
    
    public String getDepar(){
        return cmbDepar.getSelectedItem().toString();
    }
    
     public String getIdRelacionado(){
        return jTextIdRelacion.getText().trim();
    }
     
     public Date getFecha(){
        return new java.sql.Date(dpkFechaDiag.getDate().getTime());
    }
     
    public String getLugar(){
        return jTextLugar.getText().trim();
    }
    
    public String getCiudad(){
        return cmbCiudad.getSelectedItem().toString();
    }
    
    public void setNombreInf(String nombre){
    jTextNombreInf.setText(nombre);
    }
    
    public void setDocumentoInf(String doc){
    jTextDocumentoInf.setText(doc);
    }
    
    public String getDocumentoInf(){
        return jTextDocumentoInf.getText();
    }
    
    public void setCasoInf(String caso){
    jTextCaso.setText(caso);
    }
    
    public String getCasoInf(){
        return jTextCaso.getText().trim();
    }
    
    public void limpiarTabla (){
        //mTabla.setRowCount(0);
        for(int i=mTabla.getRowCount()-1; i>=0 ; i--){
            mTabla.removeRow(i);
        }
    }
    
    public void gestionMensajes(String mensaje, String titulo, int icono){
         JOptionPane.showMessageDialog(this,mensaje, titulo, icono);
    }
    
    public void limpiarDatos(){
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        cmbSexo.setSelectedIndex(0);
        cmbDepar.setSelectedIndex(0);
        cmbCiudad.setSelectedIndex(0);
        txtNombre.requestFocus();
    }
    
    public void addListenerCmbDepar(ActionListener listenPersona){
        cmbDepar.addActionListener(listenPersona);
    }
    
     public void addListenerBtnNuevo(ActionListener listenPersona){
        btnNuevo.addActionListener(listenPersona);
    }
    
    public void addListenerBtnModificar(ActionListener listenPersona){
        btnModificar.addActionListener(listenPersona);
    }
    
    public void addListenerBtnBorrar(ActionListener listenPersona){
        btnBorrar.addActionListener(listenPersona);
    }
    
    public void cargarRelacionados(ArrayList<Relacionado> listRelacionados){
        limpiarTabla();
        for(int i= 0; i < listRelacionados.size(); i++){
            mTabla.addRow(new Object[]{
            listRelacionados.get(i).getId_relacionado(),
            listRelacionados.get(i).getId(),
            listRelacionados.get(i).getNombre(),
            listRelacionados.get(i).getEdad(),
            listRelacionados.get(i).getSexo(),
            listRelacionados.get(i).getDepartamento(),
            listRelacionados.get(i).getCiudad_O(),
            listRelacionados.get(i).getFecha(),
            listRelacionados.get(i).getLugar()
            });
        }
    }
    
     public void nuevoAction (){
       revisaDatos();
    }
     
     public boolean revisaDatos(){
        if (txtNombre.getText().replaceAll(" ", "").isEmpty()||txtId.getText().replaceAll(" ", "").isEmpty()||
                txtEdad.getText().replaceAll(" ", "").isEmpty()|| cmbDepar.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this,"Datos incompletos, por favor llene todos lo campos");
            return false;
        }
        return true;
    }
     
     public void cargarMunicipio(ArrayList<String> listMuni){
        mCiudad.removeAllElements();
        for (int i=0; i< listMuni.size();i++){
            mCiudad.addElement(listMuni.get(i));
      }
    }
    
    public void cancelarAction (){
        btnBorrar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnNuevo.setText("Nuevo");
        btnNuevo.setActionCommand("nuevo");
        txtId.setEnabled(true);
        tblPersonas.clearSelection();
        limpiarDatos();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextNombreInf = new javax.swing.JTextField();
        jTextDocumentoInf = new javax.swing.JTextField();
        jTextCaso = new javax.swing.JTextField();
        panDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblCiudadO = new javax.swing.JLabel();
        lblDeparta = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        cmbSexo = new javax.swing.JComboBox<>();
        txtEdad = new javax.swing.JTextField();
        jTextIdRelacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextLugar = new javax.swing.JTextField();
        cmbDepar = new javax.swing.JComboBox<>();
        cmbCiudad = new javax.swing.JComboBox<>();
        dpkFechaDiag = new org.jdesktop.swingx.JXDatePicker();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();

        setClosable(true);
        setAutoscrolls(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del infectado con quien se relacionó"));

        jLabel2.setText("Nombre");

        jLabel3.setText("Identificacion");

        jLabel4.setText("Caso de infectado #");

        jTextNombreInf.setEditable(false);
        jTextNombreInf.setEnabled(false);

        jTextDocumentoInf.setEditable(false);
        jTextDocumentoInf.setEnabled(false);

        jTextCaso.setEditable(false);
        jTextCaso.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextNombreInf, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextDocumentoInf, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextNombreInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDocumentoInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Relacionado"));

        lblNombre.setText("Nombre:");

        lblId.setText("Documento:");

        lblSexo.setText("Sexo:");

        lblEdad.setText("Edad:");

        lblCiudadO.setText("Ciudad:");

        lblDeparta.setText("Departamento:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        cmbSexo.setEditable(true);
        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        jLabel1.setText("Id relacionado");

        jLabel5.setText("Fecha de contacto");

        jLabel6.setText("Lugar de contacto");

        cmbDepar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Antioquia", "Atlantico", "D. C. Santa Fe de Bogotá", "Bolivar", "Boyaca", "Caldas", "Caqueta", "Cauca", "Cesar", "Cordova", "Cundinamarca", "Choco", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Quindio", "Risaralda", "Santander", "Sucre", "Tolima", "Valle", "Arauca", "Casanare", "Putumayo", "San Andres", "Amazonas", "Guainia", "Guaviare", "Vaupes", "Vichada" }));
        cmbDepar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDeparItemStateChanged(evt);
            }
        });

        dpkFechaDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpkFechaDiagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panDatosLayout = new javax.swing.GroupLayout(panDatos);
        panDatos.setLayout(panDatosLayout);
        panDatosLayout.setHorizontalGroup(
            panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblId)
                    .addComponent(lblDeparta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId)
                    .addComponent(txtNombre)
                    .addComponent(cmbDepar, 0, 150, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDatosLayout.createSequentialGroup()
                        .addComponent(lblEdad)
                        .addGap(18, 18, 18)
                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panDatosLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDatosLayout.createSequentialGroup()
                        .addComponent(lblCiudadO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDatosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(panDatosLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextIdRelacion)
                    .addComponent(jTextLugar)
                    .addComponent(dpkFechaDiag, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panDatosLayout.setVerticalGroup(
            panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDatosLayout.createSequentialGroup()
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextIdRelacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(dpkFechaDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeparta)
                    .addComponent(lblCiudadO)
                    .addComponent(jLabel6)
                    .addComponent(jTextLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDepar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevo.setText("Nuevo");

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);

        btnBorrar.setText("Eliminar");
        btnBorrar.setEnabled(false);

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id relacionado", "Documento", "Nombre", "Edad", "Sexo", "Departamento", "Ciudad", "Fecha Contacto", "Lugar Contacto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPersonas.getTableHeader().setReorderingAllowed(false);
        tblPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void tblPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonasMouseClicked
        int sel = tblPersonas.getSelectedRow();
        if(sel == -1){
            if(tblPersonas.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"No hay registros");
            }
        }else {
            txtId.setText(tblPersonas.getValueAt(sel, 0).toString());
            txtId.setEnabled(false);
            txtNombre.setText(tblPersonas.getValueAt(sel, 1).toString());
            txtEdad.setText(tblPersonas.getValueAt(sel, 2).toString());
            cmbSexo.setSelectedItem(tblPersonas.getValueAt(sel, 3).toString());
            cmbDepar.setSelectedItem(tblPersonas.getValueAt(sel, 4).toString());
            cmbCiudad.setSelectedItem(tblPersonas.getValueAt(sel, 5).toString());
            btnModificar.setEnabled(true);
            btnBorrar.setEnabled(true);
            btnNuevo.setText("Cancelar");
            btnNuevo.setActionCommand("cancelar");
        }
    }//GEN-LAST:event_tblPersonasMouseClicked

    private void cmbDeparItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDeparItemStateChanged
        int sel = cmbDepar.getSelectedIndex();
    }//GEN-LAST:event_cmbDeparItemStateChanged

    private void dpkFechaDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpkFechaDiagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpkFechaDiagActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbCiudad;
    private javax.swing.JComboBox<String> cmbDepar;
    private javax.swing.JComboBox<String> cmbSexo;
    private org.jdesktop.swingx.JXDatePicker dpkFechaDiag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCaso;
    private javax.swing.JTextField jTextDocumentoInf;
    private javax.swing.JTextField jTextIdRelacion;
    private javax.swing.JTextField jTextLugar;
    private javax.swing.JTextField jTextNombreInf;
    private javax.swing.JLabel lblCiudadO;
    private javax.swing.JLabel lblDeparta;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JPanel panDatos;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
