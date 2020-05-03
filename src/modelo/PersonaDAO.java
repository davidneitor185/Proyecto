/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Servicios.Fachada;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class PersonaDAO {
    
    public PersonaDAO() {
    }
    /**
     * 
     * @param p Objeto de la clase Ppersona a grabar
     * @return rtdo resultado de la operación grabar
     */
    public int guardarPersona(Persona p){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO persona (nombre, edad, sexo, ciudad_o,"
                    + " departamento, id) values (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getNombre());
            pstm.setInt(2, p.getEdad());
            pstm.setString(3,String.valueOf(p.getSexo()));
            pstm.setString(4,p.getCiudad_O());            
            pstm.setString(5,p.getDepartamento());
            pstm.setString(6, p.getId());
            
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int guardarPersona(Infectado p){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO persona (nombre, edad, sexo, ciudad_o,"
                    + " departamento, id) values (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getNombre());
            pstm.setInt(2, p.getEdad());
            pstm.setString(3,String.valueOf(p.getSexo()));
            pstm.setString(4,p.getCiudad_O());            
            pstm.setString(5,p.getDepartamento());
            pstm.setString(6, p.getId());
            
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int guardarPersona(Relacionado p){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO persona (nombre, edad, sexo, ciudad_o,"
                    + " departamento, id) values (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getNombre());
            pstm.setInt(2, p.getEdad());
            pstm.setString(3,String.valueOf(p.getSexo()));
            pstm.setString(4,p.getCiudad_O());            
            pstm.setString(5,p.getDepartamento());
            pstm.setString(6, p.getId());
            
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
     /**
     * 
     * @param p Objeto de la clase persona a modificar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarPersona(Persona p){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE persona " +
                         "SET nombre = ?, edad = ?, sexo = ?, ciudad_o = ?, departamento = ? "
                    +    "WHERE id = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, p.getNombre());
            pstm.setInt(2, p.getEdad());
            pstm.setString(3,String.valueOf(p.getSexo()));
            pstm.setString(4,p.getCiudad_O());            
            pstm.setString(5,p.getDepartamento());
            pstm.setString(6, p.getId());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
         
     public int modificarPersona(Infectado p){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE persona " +
                         "SET nombre = ?, edad = ?, sexo = ?, ciudad_o = ?, departamento = ? "
                    +    "WHERE id = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, p.getNombre());
            pstm.setInt(2, p.getEdad());
            pstm.setString(3,String.valueOf(p.getSexo()));
            pstm.setString(4,p.getCiudad_O());            
            pstm.setString(5,p.getDepartamento());
            pstm.setString(6, p.getId());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
     public int modificarPersona(Relacionado p){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE persona " +
                         "SET nombre = ?, edad = ?, sexo = ?, ciudad_o = ?, departamento = ? "
                    +    "WHERE id = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, p.getNombre());
            pstm.setInt(2, p.getEdad());
            pstm.setString(3,String.valueOf(p.getSexo()));
            pstm.setString(4,p.getCiudad_O());            
            pstm.setString(5,p.getDepartamento());
            pstm.setString(6, p.getId());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
     
    /**
     * 
     * @param id string identificador de persona a modificar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarPersona(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM persona WHERE id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    /**
     * 
     * @param id identificador de la persona a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Persona> listadoPersonas(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Persona> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql = "";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM persona ORDER BY id";            
            }else{
                sql = "SELECT * FROM persona where id = ? "
                    + "ORDER BY id";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(!id.equalsIgnoreCase("0")){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Persona persona = null;
            while(rs.next()){
                persona = new Persona();
                persona.setId(rs.getString("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setEdad(rs.getInt("edad"));
                persona.setSexo(rs.getString("sexo").charAt(0));
                persona.setCiudad_O(rs.getString("ciudad_o"));
                persona.setDepartamento(rs.getString("departamento"));
                listado.add(persona);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
}
