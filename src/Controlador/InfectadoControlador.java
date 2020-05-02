/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Vista.InfectadoIG;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.RelacionadoIG;
/**
 *
 * @author Santiago y Victor
 */
public class InfectadoControlador {
    private InfectadoDAO modelo;
    private InfectadoIG vista;
    private MunicipioDAO muni;
    
    public InfectadoControlador(InfectadoDAO modelo, InfectadoIG vista) {
        this.modelo = modelo;
        this.vista = vista;
        muni = new MunicipioDAO();
        
        this.vista.addListenerBtnNuevo(new PersonaListener());
        this.vista.addListenerBtnModificar(new PersonaListener());
        this.vista.addListenerBtnBorrar(new PersonaListener());
        this.vista.addListenerCmbDepar(new PersonaListener());
        
        ArrayList <Infectado> listaInfec;
        listaInfec = this.modelo.listadoInf("0");
        this.vista.cargarInfectados(listaInfec);
  
        
    }
     
    class PersonaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equalsIgnoreCase("nuevo")){
                cargar();
            }else if(e.getActionCommand().equalsIgnoreCase("modificar")){
                modifica();
            }else if(e.getActionCommand().equalsIgnoreCase("eliminar")){
                eliminar();
            }else if(e.getActionCommand().equalsIgnoreCase("cancelar")){
                vista.cancelarAction();
            }else if(e.getActionCommand().equalsIgnoreCase("depar")){
                municipios();
            }else if(e.getActionCommand().equalsIgnoreCase("Relacionado")){
                relacionado();
            }   
        }
        
        public void relacionado(){
         RelacionadoIG vista = new RelacionadoIG();
         vista.setVisible(true);
         RelacionadoDAO modelo = new RelacionadoDAO();
         //here
         }    
      
      
        public void cargar(){
            if (vista.revisaDatos()){
                Infectado inf = new Infectado();
                inf.setId(vista.getId());
                inf.setNombre(vista.getNombre());
                inf.setEdad(vista.getEdad());
                inf.setSexo(vista.getSexo());
                inf.setDepartamento(vista.getDepar());
                inf.setCiudad_O(vista.getCiudad());
                inf.setEstado(vista.getEstado());
                inf.setFecha_D(vista.getFechaDiag());
                inf.setId_Infectado(vista.getIdInfec());
                inf.setPais_Pro(vista.getPaisProc());
                inf.setTipo_cont(vista.getTipoCont());
                
                int existeInf = modelo.listadoInf(inf.getId_Infectado()).size();
                int existePer = modelo.listadoPersonas(inf.getId()).size();
                
                if(existeInf == 0 && existePer == 0){
                    
                    int resultado2 = modelo.guardarPersona2(inf);
                    int resultado = modelo.grabarInf(inf);
                    if(resultado2 == 1 && resultado ==1){
                        vista.gestionMensajes("Registro Grabado con éxito", 
                                "Confirmación",JOptionPane.INFORMATION_MESSAGE); 
                        vista.cargarInfectados(modelo.listadoInf("0"));
                        vista.cancelarAction();
                    }
                    else{
                        vista.gestionMensajes("Error al grabar",
                                "Confirmación",JOptionPane.ERROR_MESSAGE);                                                 
                    }
                }else{
                    if (existePer > 0){
                        vista.gestionMensajes("Ya existe una PERSONA con ese DOCUMENTO",
                                "Confirmación", JOptionPane.ERROR_MESSAGE);
                    }else{
                        vista.gestionMensajes("Ya existe un CASO con ese NUMERO",
                                "Confirmación", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
      
        public void eliminar(){
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar el infectado con C: " +
                    vista.getId()+ "?", 
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if(respuesta == JOptionPane.YES_OPTION){                    
                if(modelo.borrarInf(vista.getIdInfec())==1 && modelo.borrarPersona(vista.getId()) ==  1 ){
                    JOptionPane.showMessageDialog(null, 
                            "Registro Borrado con éxtio", 
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);      
                    vista.cargarInfectados(modelo.listadoInf("0"));
                    vista.cancelarAction();
                }
                else{
                    JOptionPane.showMessageDialog(null, 
                            "Error al borrar",
                            "Confirmación de acción", JOptionPane.ERROR_MESSAGE);                    
                }
            }
        }
             
        public void modifica(){
            if (vista.revisaDatos()){
                Infectado inf = new Infectado();
                inf.setId(vista.getId());
                inf.setNombre(vista.getNombre());
                inf.setEdad(vista.getEdad());
                inf.setSexo(vista.getSexo());
                inf.setDepartamento(vista.getDepar());
                inf.setCiudad_O(vista.getCiudad());
                inf.setEstado(vista.getEstado());
                inf.setFecha_D(vista.getFechaDiag());
                inf.setId_Infectado(vista.getIdInfec());
                inf.setPais_Pro(vista.getPaisProc());
                inf.setTipo_cont(vista.getTipoCont());
                
                if(modelo.modificarPersona2(inf) == 1&&modelo.modificarInf(inf)==1){
                    vista.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE); 
                    vista.cancelarAction();
                    vista.cargarInfectados(modelo.listadoInf("0"));
                    //vista.cargarPersonas(modelo.listadoPersonas("0"));           
                } else {
                    vista.gestionMensajes("Actualización Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        public void municipios(){
            ArrayList <String> listMuni;
            listMuni = muni.listadoMuni(vista.deparSelec());
            vista.cargarMunicipio(listMuni);
        }
    }
}
