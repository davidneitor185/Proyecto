package Vista;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Infectado;

/**
 *
 * @author Victor
 */
public class InfectadoIG extends javax.swing.JInternalFrame {

    /**
     * Creates new form NuevoPersona
     */
    public InfectadoIG() {
        initComponents();
        mTabla =(DefaultTableModel) tblPersonas.getModel();
        mCiudad = (DefaultComboBoxModel)cmbCiudad.getModel();
        dpkFechaDiag.setFormats("dd-MM-yyyy");
        cmbDepar.setActionCommand("depar");
        jButtonRelacionado.setActionCommand("Relacionado");
    }
    
    public void agregar(RelacionadoIG vista){
        this.add(vista);    
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
    
    public String getDepar(){
        return cmbDepar.getSelectedItem().toString();
    }
    
    public String getCiudad(){
        return cmbCiudad.getSelectedItem().toString();
    }
    
    public String getIdInfec(){
        return jTextCaso.getText().trim();
    }
    
    public Date getFechaDiag(){
        return new java.sql.Date(dpkFechaDiag.getDate().getTime());
    }
    
    public String getPaisProc(){
        return jTextPaisProc.getText().trim();
    }
    
    public String getEstado(){
        return cmbEstado.getSelectedItem().toString();
    }
    
    public String getTipoCont(){
        return cmbTipo.getSelectedItem().toString();
    }
    
    public void limpiarTabla (){
        //mTabla.setRowCount(0);
        for(int i=mTabla.getRowCount()-1; i>=0 ; i--){
            mTabla.removeRow(i);
        }
    }
    
    public void cargarMunicipio(ArrayList<String> listMuni){
        mCiudad.removeAllElements();
        for (int i=0; i< listMuni.size();i++){
            mCiudad.addElement(listMuni.get(i));
      }
    }
    
    public void cargarInfectados(ArrayList<Infectado> listInfectados){
        limpiarTabla();
        for(int i= 0; i < listInfectados.size(); i++){
            mTabla.addRow(new Object[]{
            listInfectados.get(i).getId_Infectado(),
            listInfectados.get(i).getId(),
            listInfectados.get(i).getNombre(),
            listInfectados.get(i).getEdad(),
            listInfectados.get(i).getSexo(),
            listInfectados.get(i).getDepartamento(),
            listInfectados.get(i).getCiudad_O(),
            listInfectados.get(i).getEstado(),
            listInfectados.get(i).getFecha_D(),
            listInfectados.get(i).getPais_Pro(),
            listInfectados.get(i).getTipo_cont()
            });
        }
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
    
    public void addListenerjButtonRelacionado(ActionListener listenPersona){
        jButtonRelacionado.addActionListener(listenPersona);
    }
    
    public void nuevoAction (){
       revisaDatos();
    }
    
    public void cancelarAction (){
        btnBorrar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnNuevo.setText("Nuevo");
        btnNuevo.setActionCommand("nuevo");
        txtId.setEnabled(true);
        jTextCaso.setEnabled(true);
        tblPersonas.clearSelection();
        jButtonRelacionado.setEnabled(false);
        limpiarDatos();
    }
    
    public void modificarAction (){
        
    }
    
    public void borrarAction (){
        
    }
    
    public boolean revisaDatos(){
        if (txtNombre.getText().replaceAll(" ", "").isEmpty()||txtId.getText().replaceAll(" ", "").isEmpty()||
                txtEdad.getText().replaceAll(" ", "").isEmpty()|| cmbDepar.getSelectedIndex() == 0
                ||jTextCaso.getText().replaceAll(" ", "").isEmpty()||cmbEstado.getSelectedIndex() == 0
                ||dpkFechaDiag.getDate() == null||jTextPaisProc.getText().replaceAll(" ", "").isEmpty()
                ||cmbTipo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this,"Datos incompletos, por favor llene todos lo campos");
            return false;
        }
        return true;
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
        jTextCaso.setText("");
        cmbEstado.setSelectedIndex(0);
        dpkFechaDiag.setDate(null);
        jTextPaisProc.setText("");
        cmbTipo.setSelectedIndex(0);
    }
    
    
    
    public int deparSelec(){
        return cmbDepar.getSelectedIndex();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        cmbDepar = new javax.swing.JComboBox<>();
        cmbCiudad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextCaso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextPaisProc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dpkFechaDiag = new org.jdesktop.swingx.JXDatePicker();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        jButtonRelacionado = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Infectado");

        panDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Persona"));

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

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        cmbDepar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Antioquia", "Atlantico", "Bogotá D.C.", "Bolivar", "Boyaca", "Caldas", "Caqueta", "Cauca", "Cesar", "Cordova", "Cundinamarca", "Choco", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Quindio", "Risaralda", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Arauca", "Casanare", "Putumayo", "San Andres", "Amazonas", "Guainia", "Guaviare", "Vaupes", "Vichada" }));
        cmbDepar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDeparItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panDatosLayout = new javax.swing.GroupLayout(panDatos);
        panDatos.setLayout(panDatosLayout);
        panDatosLayout.setHorizontalGroup(
            panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDatosLayout.createSequentialGroup()
                        .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblId))
                        .addGap(28, 28, 28)
                        .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSexo)
                            .addComponent(lblEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad)))
                    .addGroup(panDatosLayout.createSequentialGroup()
                        .addComponent(lblDeparta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDepar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCiudadO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCiudad, 0, 132, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panDatosLayout.setVerticalGroup(
            panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSexo)
                    .addComponent(lblSexo)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeparta)
                    .addComponent(cmbDepar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCiudadO))
                .addGap(17, 17, 17))
        );

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso", "Documento", "Nombre", "Edad", "Sexo", "Departamento", "Ciudad", "Estado", "Fecha Diag.", "Pais Proc.", "Tipo Contagio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
        if (tblPersonas.getColumnModel().getColumnCount() > 0) {
            tblPersonas.getColumnModel().getColumn(0).setMaxWidth(60);
            tblPersonas.getColumnModel().getColumn(1).setMaxWidth(100);
            tblPersonas.getColumnModel().getColumn(2).setMinWidth(200);
            tblPersonas.getColumnModel().getColumn(3).setMaxWidth(60);
            tblPersonas.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        btnNuevo.setText("Nuevo");

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);

        btnBorrar.setText("Eliminar");
        btnBorrar.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Infeccion por COVID-19"));
        jPanel1.setName("Datos Infectado"); // NOI18N

        jLabel1.setText("Caso");

        jLabel2.setText("Fecha Diagnostico");

        jLabel3.setText("Pais de procedencia");

        jLabel4.setText("Estado");

        jLabel5.setText("Tipo de contagio");

        dpkFechaDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpkFechaDiagActionPerformed(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Fallecido", "Grave", "Leve", "Moderado", "Recuperado" }));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Importado", "Relacionado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpkFechaDiag, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbEstado, 0, 1, Short.MAX_VALUE)
                            .addComponent(jTextCaso, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextPaisProc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextPaisProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dpkFechaDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonRelacionado.setText("Relacionado");
        jButtonRelacionado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRelacionado))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRelacionado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panDatos.getAccessibleContext().setAccessibleName("Datos Infectado");
        jPanel1.getAccessibleContext().setAccessibleName("Datos de Infectado");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonasMouseClicked
        int sel = tblPersonas.getSelectedRow();
        if(sel == -1){
            if(tblPersonas.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"No hay registros");
            }
        }else {
            DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            jTextCaso.setText(tblPersonas.getValueAt(sel, 0).toString());
            jTextCaso.setEnabled(false);
            txtId.setText(tblPersonas.getValueAt(sel, 1).toString());
            txtId.setEnabled(false);           
            txtNombre.setText(tblPersonas.getValueAt(sel, 2).toString());
            txtEdad.setText(tblPersonas.getValueAt(sel, 3).toString());
            cmbSexo.setSelectedItem(tblPersonas.getValueAt(sel, 4).toString());
            cmbDepar.setSelectedItem(tblPersonas.getValueAt(sel, 5).toString());
            cmbCiudad.setSelectedItem(tblPersonas.getValueAt(sel, 6).toString());
            cmbEstado.setSelectedItem(tblPersonas.getValueAt(sel, 7).toString());
            dpkFechaDiag.setDate((Date)tblPersonas.getValueAt(sel, 8));
            jTextPaisProc.setText(tblPersonas.getValueAt(sel, 9).toString());
            cmbTipo.setSelectedItem(tblPersonas.getValueAt(sel, 10).toString());
            btnModificar.setEnabled(true);
            btnBorrar.setEnabled(true);
            btnNuevo.setText("Cancelar");
            btnNuevo.setActionCommand("cancelar");
            jButtonRelacionado.setEnabled(true);
        }
    }//GEN-LAST:event_tblPersonasMouseClicked

    private void cmbDeparItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDeparItemStateChanged
        int sel = cmbDepar.getSelectedIndex();
    }//GEN-LAST:event_cmbDeparItemStateChanged

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void dpkFechaDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpkFechaDiagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpkFechaDiagActionPerformed



    
    private DefaultComboBoxModel mCiudad;
    private DefaultTableModel mTabla;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbCiudad;
    private javax.swing.JComboBox<String> cmbDepar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JComboBox<String> cmbTipo;
    private org.jdesktop.swingx.JXDatePicker dpkFechaDiag;
    private javax.swing.JButton jButtonRelacionado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCaso;
    private javax.swing.JTextField jTextPaisProc;
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
