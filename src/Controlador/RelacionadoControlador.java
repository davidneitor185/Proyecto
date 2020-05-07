/*
 * Programa	: elacionadoControlador.java
 * Fecha	: 01/05/2020
 * Objetivo	: Controlador de relacionado
 * Programador	: Deiby Rodriguez
 */
package Controlador;

import Vista.RelacionadoIG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MunicipioDAO;
import modelo.Relacionado;
import modelo.RelacionadoDAO;

/**
 *
 * @author Deiby Rodriguez
 */
public class RelacionadoControlador {

    private RelacionadoDAO modelo;
    private RelacionadoIG vista;
    private MunicipioDAO muni;

    public RelacionadoControlador(RelacionadoDAO modelo, RelacionadoIG vista, String id) {
        this.modelo = modelo;
        this.vista = vista;
        this.muni = new MunicipioDAO();
        this.vista.setCasoInf(id);
        this.vista.addListenerBtnNuevo(new PersonaListener());
        this.vista.addListenerBtnModificar(new PersonaListener());
        this.vista.addListenerBtnBorrar(new PersonaListener());
        this.vista.addListenerCmbDepar(new PersonaListener());

        ArrayList<Relacionado> listaRelacionado;
        listaRelacionado = this.modelo.listadoRelacionados(id);
        this.vista.cargarRelacionados(listaRelacionado);
        //this.vista.setVisible(true);
    }

    class PersonaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("nuevo")) {
                cargar();
            } else if (e.getActionCommand().equalsIgnoreCase("modificar")) {
                modifica();
            } else if (e.getActionCommand().equalsIgnoreCase("eliminar")) {
                eliminar();
            } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
                vista.cancelarAction();
            } else if (e.getActionCommand().equalsIgnoreCase("depar")) {
                municipios();
            }
        }
    }

    public void municipios() {
        ArrayList<String> listMuni;
        listMuni = muni.listadoMuni(vista.getDeparSelected());
        vista.cargarMunicipio(listMuni);
    }

    public void cargar() {
        if (vista.revisaDatos()) {
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
            inf.setId_focoinfec(vista.getCasoInf());

            int existe = modelo.listadoPersonas(inf.getId()).size();

            if (existe == 0) {

                int resultado2 = modelo.guardarPersona(inf);//Nuevo persona rela
                int resultado = modelo.grabarRelacionado(inf);
                if (resultado2 == 1 && resultado == 1) {
                    vista.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vista.cargarRelacionados(modelo.listadoRelacionados(vista.getCasoInf()));
                    vista.cancelarAction();
                } else {
                    vista.gestionMensajes("Error al grabar",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (modelo.listadoPersonas(inf.getId()).get(0).getNombre().equalsIgnoreCase(vista.getNombre())
                        && modelo.listadoPersonas(inf.getId()).get(0).getEdad() == vista.getEdad()
                        && modelo.listadoPersonas(inf.getId()).get(0).getSexo() == vista.getSexo()
                        && modelo.listadoPersonas(inf.getId()).get(0).getDepartamento().equalsIgnoreCase(vista.getDepar())
                        && !(modelo.listadoRelacionado2(inf.getId()).get(0).getId_focoinfec().equals(vista.getCasoInf()))) {
                    //Hola soy el caso ese
                    int num = JOptionPane.showConfirmDialog(vista, "Esta persona ya se encuentra en nuestra base de datos,"
                            + " ¿Desea agregar otra realacion a esta persona?", "confirmacion", existe);
                    if (num == 0) {

                        int resultado = modelo.grabarRelacionado(inf);

                        if (resultado == 1) {

                            vista.gestionMensajes("Registro Grabado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            vista.cargarRelacionados(modelo.listadoRelacionados(vista.getCasoInf()));
                            vista.cancelarAction();
                        } else {
                            vista.gestionMensajes("Error al grabar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "A weno te me kuidas");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor verifique los datos de la persona");
                }
            }
        }
    }

    public void eliminar() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Desea eliminar el relacionado con C: "
                + vista.getId() + "?",
                "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            if (modelo.borrarRelacionado(vista.getIdRelacionado()) == 1) {
                JOptionPane.showMessageDialog(null,
                        "Registro Borrado con éxtio",
                        "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);
                vista.cargarRelacionados(modelo.listadoRelacionados(vista.getCasoInf()));
                vista.cancelarAction();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar",
                        "Confirmación de acción", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void modifica() {
        if (vista.revisaDatos()) {
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
            inf.setId_focoinfec(vista.getCasoInf());

            if (modelo.modificarPersona(inf) == 1 && modelo.modificarRelacionado(inf) == 1) {
                vista.gestionMensajes("Actualización exitosa",
                        "Confirmación ", JOptionPane.INFORMATION_MESSAGE);
                vista.cancelarAction();
                vista.cargarRelacionados(modelo.listadoRelacionados(vista.getCasoInf()));
            } else {
                vista.gestionMensajes("Actualización Falida",
                        "Confirmación ", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
