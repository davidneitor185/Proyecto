/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.util.ArrayList;
import modelo.Infectado;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Santiago
 */
public class Grafico {

    public Grafico() {
     
    }
    
    
    
    public ChartPanel rela(ArrayList<Infectado> list){
        
        int rela =0;
        int impor =0;
        for(int i =0;i<list.size();i++){
            if(list.get(i).getTipo_cont().equalsIgnoreCase("Relacionado")){
                rela++;
            }
            else if(list.get(i).getTipo_cont().equalsIgnoreCase("Importado")){
                impor++;
            }
    }
        DefaultPieDataset data= new DefaultPieDataset();
        data.setValue("Relacionado : "+String.valueOf(rela),rela);
        data.setValue("impor : "+String.valueOf(impor),impor);
        
        JFreeChart cha = ChartFactory.createPieChart3D("Distribución por tipo", data,true,true,true);
        
        ChartPanel cp = new ChartPanel(cha);
        cp.setBounds(500,40,500,400);
        cp.setVisible(true);
        return cp;
    }
    
    public ChartPanel edad(ArrayList<Infectado> list){
        
        int infancia =0;
        int adol =0;
        int junv =0;
        int adul =0;
        int persoM =0;
        for(int i =0;i<list.size();i++){
            if(list.get(i).getEdad()<=11){
                infancia++;
            }
            else if(list.get(i).getEdad()<=18){
                adol++;
            }
            else if(list.get(i).getEdad()<=26){
                junv++;
            }
            else if(list.get(i).getEdad()<=64){
                adul++;
            }
            else{
                persoM++;
                }
            
    }
        DefaultCategoryDataset data= new DefaultCategoryDataset();
        data.addValue(infancia,"Infancia","0-11 años");
        data.addValue(adol,"Adolecencia","12 - 18 años");
        data.addValue(junv,"Juventud","19-26 años");
        data.addValue(adul,"Adultez","27-64 años");
        data.addValue(persoM,"Anciano","65+ años");
        
        JFreeChart cha = ChartFactory.createBarChart3D("Distribución por Edad","Edad",
                "Años", data,PlotOrientation.HORIZONTAL,true,true,true);
        
        ChartPanel cp = new ChartPanel(cha);
        cp.setBounds(500,40,500,400);
        cp.setVisible(true);
        
        return cp;
    }

    
}
