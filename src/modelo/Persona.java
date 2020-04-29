/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Victor
 */
public class Persona {
    
    
    private String nombre;
    private int edad;
    private String id;
    private char sexo;
    private String ciudad_O;
    private String departamento;

    public Persona(String nombre, int edad, String id, char sexo, String ciudad_O, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.sexo = sexo;
        this.ciudad_O = ciudad_O;
        this.departamento = departamento;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getId() {
        return id;
    }

    public char getSexo() {
        return sexo;
    }

    public String getCiudad_O() {
        return ciudad_O;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setCiudad_O(String ciudad_O) {
        this.ciudad_O = ciudad_O;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
    
    
    
}
