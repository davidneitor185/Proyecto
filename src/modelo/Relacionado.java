/*
 * Programa	: Relacionado.java
 * Fecha	: 06/04/2020
 * Objetivo	: Modela la tabla relacionado
 * Programador	: Deiby Rodriguez
 */
package modelo;

/**
 *
 * @author Deiby Rodriguez
 */
public class Relacionado extends Persona{
    
    private String id_focoinfec;
    private String id_relacionado;
    private String fecha;
    private String lugar;

    public Relacionado() {
    }

    public Relacionado(String id_focoinfec, String id_relacionado, String fecha, String lugar) {
        
        this.id_focoinfec = id_focoinfec;
        this.id_relacionado = id_relacionado;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getId_focoinfec() {
        return id_focoinfec;
    }

    public void setId_focoinfec(String id_infectado) {
        this.id_focoinfec = id_infectado;
    }

    public String getId_relacionado() {
        return id_relacionado;
    }

    public void setId_relacionado(String id_persona) {
        this.id_relacionado = id_persona;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
