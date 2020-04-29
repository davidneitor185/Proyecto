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
public class MunicipioDAO {
    
    public ArrayList<String> listadoMuni(int id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<String> listado = new ArrayList<>();
        try{
            if (id == 0){
                listado.add(" ");
            }else{
                con = Fachada.getConnection();
                String sql = "";
                sql = "SELECT municipio FROM municipios where id_departamento = ? "
                    + "ORDER BY municipio";                    
                pstm = con.prepareStatement(sql);

                pstm.setInt(1, id);

                rs = pstm.executeQuery();

                while(rs.next()){
                    listado.add(rs.getString(1));
                }
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
