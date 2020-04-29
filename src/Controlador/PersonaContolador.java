/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.PersonaIG;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;


/**
 *
 * @author Victor
 */
public class PersonaContolador {
    private PersonaDAO modelo;
    private PersonaIG vista;
    private MunicipioDAO muni;

    public PersonaContolador(PersonaDAO modelo, PersonaIG vista) {
        this.modelo = modelo;
        this.vista = vista;
        muni = new MunicipioDAO();
        
        this.vista.addListenerBtnNuevo(new PersonaListener());
        this.vista.addListenerBtnModificar(new PersonaListener());
        this.vista.addListenerBtnBorrar(new PersonaListener());
        this.vista.addListenerCmbDepar(new PersonaListener());
        
        ArrayList <Persona> listPersonas;
        listPersonas = this.modelo.listadoPersonas("0");
        this.vista.cargarPersonas(listPersonas);
        
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
            } 
        }
        
        public void cargar(){
            if (vista.revisaDatos()){
                Persona persona = new Persona();
                persona.setId(vista.getId());
                persona.setNombre(vista.getNombre());
                persona.setEdad(vista.getEdad());
                persona.setSexo(vista.getSexo());
                persona.setDepartamento(vista.getDepar());
                persona.setCiudad_O(vista.getCiudad());
                
                int existe = modelo.listadoPersonas(persona.getId()).size();
                
                if(existe == 0){
                    int resultado = modelo.guardarPersona(persona);
                    if(resultado == 1){
                        vista.gestionMensajes("Registro Grabado con éxito", 
                                "Confirmación",JOptionPane.INFORMATION_MESSAGE); 
                        vista.cargarPersonas(modelo.listadoPersonas("0"));
                        vista.cancelarAction();
                    }
                    else{
                        vista.gestionMensajes("Error al grabar",
                                "Confirmación",JOptionPane.ERROR_MESSAGE);                                                 
                    }
                }else{
                    vista.gestionMensajes("Ya está registrada una perosna con ese"
                            + "DOCUMENTO", "Confirmación", JOptionPane.ERROR_MESSAGE);                                      
                }
            }
        }
        
        public void eliminar(){
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar la persona con CC: " +
                    vista.getId()+ "?", 
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if(respuesta == JOptionPane.YES_OPTION){                    
                if(modelo.borrarPersona(vista.getId()) ==  1){
                    JOptionPane.showMessageDialog(null, 
                            "Registro Borrado con éxtio", 
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);      
                    vista.cargarPersonas(modelo.listadoPersonas("0"));
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
                Persona persona = new Persona();
                persona.setId(vista.getId());
                persona.setNombre(vista.getNombre());
                persona.setEdad(vista.getEdad());
                persona.setSexo(vista.getSexo());
                persona.setDepartamento(vista.getDepar());
                persona.setCiudad_O(vista.getCiudad());
                
                if(modelo.modificarPersona(persona) == 1){
                    vista.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE); 
                    vista.cancelarAction();
                    vista.cargarPersonas(modelo.listadoPersonas("0"));           
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
