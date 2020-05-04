/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.util.ArrayList;
import modelo.Infectado;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Santiago
 */
public class Grafico {

    public Grafico() {
    }
    
    
    
    public void tortaEdad(ArrayList<Infectado> list){
        
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
        data.setValue("Importado : "+String.valueOf(impor),impor);
        
        JFreeChart cha = ChartFactory.createPieChart3D("Distribución por tipo", data,true,true,true);
        
        
    }
    
}
