/*
 * Programa	: RelacionadoDAO.java
 * Fecha	: 06/04/2020
 * Objetivo	: Modela el acceso a datos de la tabla relacionado
 * Programador	: Deiby Rodriguez
 */

package modelo;
import Servicios.Fachada;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Deiby Rodriguez
 */
public class RelacionadoDAO {

    public RelacionadoDAO() {
    }
    /**
     * 
     * @param p Objeto de la clase Relacionado a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarRelacionado(Relacionado p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO relacionado (id_focoinfec, id_relacionado,fecha,lugar) VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getId_focoinfec());
            pstm.setString(2, p.getId_relacionado());
            pstm.setString(3, p.getFecha());
            pstm.setString(4, p.getLugar());
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
     * @param p Objeto de la clase Relacionado a modificar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarRelacionado(Relacionado p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE relacionado " +
                         "SET id_focoinfec = ?, fecha = ?, lugar = ? "
                    +    "WHERE id_relacionado=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getId_focoinfec());
            pstm.setString(2, p.getFecha());
            pstm.setString(3, p.getLugar());
            pstm.setString(4, p.getId_relacionado());
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
     * @param id_relacionado id de la persona a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarRelacionado(String  id_relacionado){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM relacionado WHERE id_relacionado = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id_relacionado);
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
     * @param id_relacionado id de la persona del programa a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Relacionados
     */
    public ArrayList<Relacionado> listadoRelacionados(String id_relacionado){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Relacionado> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id_relacionado.equalsIgnoreCase("0")){
                sql = "SELECT * FROM relacionado ORDER BY id_relacionado";            
            }else{
                sql = "SELECT * FROM relacionado WHERE id_relacionado = ? "
                    + "ORDER BY id_relacionado";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id_relacionado != "0"){
                pstm.setString(1, id_relacionado);
            }
            
            rs = pstm.executeQuery();
                        
            Relacionado relacionado = null;
            while(rs.next()){
                relacionado = new Relacionado();
                relacionado.setId_relacionado(rs.getString("id_relacionado"));
                relacionado.setId_focoinfec(rs.getString("id_focoinfec"));
                relacionado.setFecha(rs.getString("fecha"));
                relacionado.setLugar(rs.getString("lugar"));
                listado.add(relacionado);
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