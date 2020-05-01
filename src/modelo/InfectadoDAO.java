/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class InfectadoDAO extends PersonaDAO {
    
    public int grabarInf(Infectado inf){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO infectado (estado,fecha_d,id_infectado,id_persona,pais_pro,tipo_cont)"
                    + " VALUES(?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, inf.getEstado());
            pstm.setString(2, inf.getFecha_D());
            pstm.setString(3,inf.getId_Infectado());
            pstm.setString(4,inf.getId());
            pstm.setString(5,inf.getPais_Pro());
            pstm.setString(6,inf.getTipo_cont());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ID : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"ID : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
     /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarInf(Infectado inf){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE infectado " +
                         "SET estado = ?, fecha_d = ?" +
                         ", pais_pro = ?, tipo_cont = ? "
                    +    "WHERE id_infectado = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, inf.getEstado());
            pstm.setString(2, inf.getFecha_D());
            pstm.setString(3, inf.getPais_Pro());
            pstm.setString(4, inf.getTipo_cont());
            pstm.setString(5, inf.getId_Infectado());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ID : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"ID : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
            
    /**
     * 
     * @param codigo código del programa a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarInf(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM infectado WHERE id_infectado = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ID : " + 
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
     * @param codigo codigo del programa a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Infectado> listadoInf(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
           
        ArrayList<Infectado> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM infectado JOIN persona on infectado.id_persona=persona.id ORDER BY id_infectado";            
            }else{
                sql = "SELECT * FROM infectado JOIN persona on infectado.id_persona=persona.id where id_infectado = ?"
                    + "ORDER BY id_infectado";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Infectado inf = null;
            while(rs.next()){
                inf = new Infectado();
                inf.setEstado(rs.getString("estado"));
                inf.setFecha_D(rs.getString("fecha_d"));
                inf.setId_Infectado(rs.getString("id_infectado"));
                inf.setPais_Pro(rs.getString("pais_pro"));
                inf.setTipo_cont(rs.getString("tipo_cont"));
                inf.setId(rs.getString("id"));
                inf.setNombre(rs.getString("nombre"));
                inf.setEdad(rs.getInt("edad"));
                inf.setSexo(rs.getString("sexo").charAt(0));
                inf.setCiudad_O(rs.getString("ciudad_o"));
                inf.setDepartamento(rs.getString("departamento"));
                
                listado.add(inf);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ID : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"ID : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
}
