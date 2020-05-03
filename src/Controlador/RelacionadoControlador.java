/*
 * Programa	: elacionadoControlador.java
 * Fecha	: 01/05/2020
 * Objetivo	: Controlador de relacionado
 * Programador	: Deiby Rodriguez
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Relacionado;
import modelo.RelacionadoDAO;
import vista.RelacionadoIG;

/**
 *
 * @author Deiby Rodriguez
 */
public class RelacionadoControlador {
    private RelacionadoDAO modelo;
    private RelacionadoIG vista;
    
    public RelacionadoControlador(RelacionadoDAO modelo, RelacionadoIG vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.addListenerBtnNuevo(new PersonaListener());
        this.vista.addListenerBtnModificar(new PersonaListener());
        this.vista.addListenerBtnBorrar(new PersonaListener());
        
        ArrayList <Relacionado> listaRelacionado;
        listaRelacionado = this.modelo.listadoRelacionados("0");
        this.vista.cargarRelacionados(listaRelacionado);
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
            }
        }
    }
      
      
    public void cargar(){
            if (vista.revisaDatos()){
                Relacionado inf = new Relacionado();
                inf.setId(vista.getId());
                inf.setNombre(vista.getNombre());
                inf.setEdad(vista.getEdad());
                inf.setSexo(vista.getSexo());
                inf.setDepartamento(vista.getDepar());
                inf.setCiudad_O(vista.getCiudad());
                inf.setId_relacionado(vista.getIdRelacionado());
                inf.setFecha(vista.getFecha());
                inf.setLugar(vista.getLugar());
                
                int existe = modelo.listadoRelacionados(inf.getId()).size();
                
                if(existe == 0){
                    
                    int resultado2 = modelo.guardarPersona(inf);//Nuevo persona rela
                    int resultado = modelo.grabarRelacionado(inf);
                    if(resultado2 == 1 && resultado ==1){
                        vista.gestionMensajes("Registro Grabado con éxito", 
                                "Confirmación",JOptionPane.INFORMATION_MESSAGE); 
                        vista.cargarRelacionados(modelo.listadoRelacionados("0"));
                        vista.cancelarAction();
                    } else{
                        vista.gestionMensajes("Error al grabar",
                                "Confirmación",JOptionPane.ERROR_MESSAGE);                                                 
                    }
                }else{
                vista.gestionMensajes("CC ya está registrada",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);                                      
                }
            }
    }
      
        public void eliminar(){
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea eliminar el relacionado con C: " +
                    vista.getId()+ "?", 
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if(respuesta == JOptionPane.YES_OPTION){                    
                if(modelo.borrarRelacionado(vista.getIdRelacionado())==1 && modelo.borrarPersona(vista.getId()) ==  1 ){
                    JOptionPane.showMessageDialog(null, 
                            "Registro Borrado con éxtio", 
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);      
                    vista.cargarRelacionados(modelo.listadoRelacionados("0"));
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
                Relacionado inf = new Relacionado();
                inf.setId(vista.getId());
                inf.setNombre(vista.getNombre());
                inf.setEdad(vista.getEdad());
                inf.setSexo(vista.getSexo());
                inf.setDepartamento(vista.getDepar());
                inf.setCiudad_O(vista.getCiudad());
                inf.setId_relacionado(vista.getIdRelacionado());
                inf.setFecha(vista.getFecha());
                inf.setLugar(vista.getLugar());
                
                if(modelo.modificarPersona(inf) == 1&&modelo.modificarRelacionado(inf)==1){
                    vista.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE); 
                    vista.cancelarAction();
                    //vista.cargarPersonas(modelo.listadoPersonas("0"));           
                } else {
                    vista.gestionMensajes("Actualización Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);                 
                }
            }
        }
}

