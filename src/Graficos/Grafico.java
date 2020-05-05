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
        data.setValue("importado : "+String.valueOf(impor),impor);
        
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
        if(dif(infancia)){
            data.addValue(infancia,"Infancia","0-11 años");
        }
        if(dif(adol)){
            data.addValue(adol,"Adolecencia","12 - 18 años");
        }
        if(dif(junv)){
            data.addValue(junv,"Juventud","19-26 años");
        }
        if(dif(adul)){
            data.addValue(adul,"Adultez","27-64 años");
        }
        if(dif(persoM)){
            data.addValue(persoM,"Anciano","65+ años");
        }
        
        
        
        JFreeChart cha = ChartFactory.createBarChart3D("Distribución por Edad","Edad",
                "Años", data,PlotOrientation.HORIZONTAL,true,true,true);
        
        ChartPanel cp = new ChartPanel(cha);
        cp.setBounds(500,40,500,400);
        cp.setVisible(true);
        
        return cp;
    }
    
    
        public ChartPanel estado(ArrayList<Infectado> list){
        
        int Leve =0;
        int Fallecido =0;
        int Grave =0;
        int Moderado =0;
        int Recuperado =0;
        
        for(int i =0;i<list.size();i++){
            if(list.get(i).getEstado().equalsIgnoreCase("Leve")){
                Leve++;
            }
            else if(list.get(i).getEstado().equalsIgnoreCase("Fallecido")){
                Fallecido++;
            }
            else if(list.get(i).getEstado().equalsIgnoreCase("Grave")){
                Grave++;
            }
            else if(list.get(i).getEstado().equalsIgnoreCase("Moderado")){
                Moderado++;
            }
            else if(list.get(i).getEstado().equalsIgnoreCase("Recuperado")){
                Recuperado++;
            }
            
    }
        DefaultCategoryDataset data= new DefaultCategoryDataset();
        if(dif(Leve)){
            data.addValue(Leve,"Leve","Leve");
        }
        if(dif(Fallecido)){
            data.addValue(Fallecido,"Fallecido","Fallecido");
        }
        if(dif(Grave)){
            data.addValue(Grave,"Grave","Grave");
        }
        if(dif(Moderado)){
            data.addValue(Leve,"Moderado","Moderado");
        }
        if(dif(Recuperado)){
            data.addValue(Recuperado,"Recuperado","Recuperado");
        }
        
        
        
        JFreeChart cha = ChartFactory.createLineChart3D("Estado de los Infectados","Estado",
                "Cantidad", data,PlotOrientation.HORIZONTAL,true,true,true);
        
        ChartPanel cp = new ChartPanel(cha);
        cp.setBounds(500,40,500,400);
        cp.setVisible(true);
        
        return cp;
    }
    
    public boolean dif(int i){
        boolean x=true;
        if(i==0){
            x=false;
        }
        return x;
    }
    
    public ChartPanel departamentos(ArrayList<Infectado> list){
        
        int Antioquia =0;
        int Atlantico = 0;
        int D_C_Santa_Fe_Bogota = 0;
        int Bolivar =0;
        int Boyaca =0;
        int Caldas =0;
        int Caqueta =0;
        int Cauca =0;
        int Cesar =0;
        int Cordova =0;
        int Cundinamarca =0;
        int Choco =0;
        int Huila =0;
        int La_Guajira =0;
        int Magdalena =0;
        int Meta =0;
        int Nariño =0;
        int Norte_de_Santander =0;
        int Quindio =0;
        int Risaralda =0;
        int Santander =0;
        int Sucre =0;
        int Tolima =0;
        int Valle =0;
        int Arauca =0;
        int Casanare =0;
        int Putumayo =0;
        int San_Andres =0;
        int Amazonas =0;
        int Guainia =0;
        int Guaviare =0;
        int Vaupes =0;
        int Vichada =0;
        
        for(int i =0;i<list.size();i++){
            if(list.get(i).getDepartamento().equalsIgnoreCase("Antioquia")){
                Antioquia++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Atlantico")){
                Atlantico++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("D. C. Santa Fe Bogota")){
                D_C_Santa_Fe_Bogota++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Bolivar")){
                Bolivar++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Boyaca")){
                Boyaca++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Caldas")){
                Caldas++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Caqueta")){
                Caqueta++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Cauca")){
                Cauca++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Cesar")){
                Cesar++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Cordova")){
                Cordova++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Cundinamarca")){
                Cundinamarca++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Choco")){
                Choco++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Huila")){
                Huila++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("La Guajira")){
                La_Guajira++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Magdalena")){
                Magdalena++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Meta")){
                Meta++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Nariño")){
                Nariño++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Norte de Santander")){
                Norte_de_Santander++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Quindio")){
                Quindio++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Risaralda")){
                Risaralda++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Santander")){
                Santander++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Sucre")){
                Sucre++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Tolima")){
                Tolima++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Valle")){
                Valle++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Arauca")){
                Arauca++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Casanare")){
                Casanare++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Putumayo")){
                Putumayo++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("San Andres")){
                San_Andres++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Amazonas")){
                Amazonas++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Guainia")){
                Guainia++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Guaviare")){
                Guaviare++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Vaupes")){
                Vaupes++;
            }
            else if(list.get(i).getDepartamento().equalsIgnoreCase("Vichada")){
                Vichada++;
            }
        }
            
        
        DefaultPieDataset data= new DefaultPieDataset();
        if(dif(Antioquia)){
            data.setValue("Antioquia : "+String.valueOf(Antioquia),Antioquia);
        }
        if(dif(Atlantico)){
            data.setValue("Atlantico : "+String.valueOf(Atlantico),Atlantico);
        }
        if(dif(D_C_Santa_Fe_Bogota)){
            data.setValue("D. C. Santa Fe Bogota : "+String.valueOf(D_C_Santa_Fe_Bogota),D_C_Santa_Fe_Bogota);
        }
        if(dif(Bolivar)){
            data.setValue("Bolivar : "+String.valueOf(Bolivar),Bolivar);
        }
        if(dif(Boyaca)){
            data.setValue("Boyaca : "+String.valueOf(Boyaca),Boyaca);
        }
        if(dif(Caldas)){
            data.setValue("Caldas : "+String.valueOf(Caldas),Caldas);
        }
        if(dif(Caqueta)){
            data.setValue("Caqueta : "+String.valueOf(Caqueta),Caqueta);
        }
        if(dif(Cauca)){
            data.setValue("Cauca : "+String.valueOf(Cauca),Cauca);
        }
        if(dif(Cesar)){
            data.setValue("Cesar : "+String.valueOf(Cesar),Cesar);
        }
        if(dif(Cordova)){
            data.setValue("Cordova : "+String.valueOf(Cordova),Cordova);
        }
        if(dif(Cundinamarca)){
            data.setValue("Cundinamarca : "+String.valueOf(Cundinamarca),Cundinamarca);
        }
        if(dif(Choco)){
            data.setValue("Choco : "+String.valueOf(Choco),Choco);
        }
        if(dif(Huila)){
            data.setValue("Huila : "+String.valueOf(Huila),Huila);
        }
        if(dif(La_Guajira)){
            data.setValue("La Guajira : "+String.valueOf(La_Guajira),La_Guajira);
        }
        if(dif(Magdalena)){
            data.setValue("Magdalena : "+String.valueOf(Magdalena),Magdalena);
        }
        if(dif(Meta)){
            data.setValue("Meta : "+String.valueOf(Meta),Meta);
        }
        if(dif(Nariño)){
            data.setValue("Nariño : "+String.valueOf(Nariño),Nariño);
        }
        if(dif(Norte_de_Santander)){
            data.setValue("Norte de Santander : "+String.valueOf(Norte_de_Santander),Norte_de_Santander);
        }
        if(dif(Quindio)){
            data.setValue("Quindio : "+String.valueOf(Quindio),Quindio);
        }
        if(dif(Risaralda)){
            data.setValue("Risaralda : "+String.valueOf(Risaralda),Risaralda);
        }
        if(dif(Santander)){
            data.setValue("Santander : "+String.valueOf(Santander),Santander);
        }
        if(dif(Sucre)){
            data.setValue("Sucre : "+String.valueOf(Sucre),Sucre);
        }
        if(dif(Tolima)){
            data.setValue("Tolima : "+String.valueOf(Tolima),Tolima);
        }
        if(dif(Valle)){
            data.setValue("Valle : "+String.valueOf(Valle),Valle);
        }
        if(dif(Arauca)){
            data.setValue("Arauca : "+String.valueOf(Arauca),Arauca);
        }
        if(dif(Casanare)){
            data.setValue("Casanare : "+String.valueOf(Casanare),Casanare);
        }
        if(dif(Putumayo)){
            data.setValue("Putumayo : "+String.valueOf(Putumayo),Putumayo);
        }
        if(dif(San_Andres)){
            data.setValue("San Andres : "+String.valueOf(San_Andres),San_Andres);
        }
        if(dif(Amazonas)){
            data.setValue("Amazonas : "+String.valueOf(Amazonas),Amazonas);
        }
        if(dif(Guainia)){
            data.setValue("Guainia : "+String.valueOf(Guainia),Guainia);
        }
        if(dif(Guaviare)){
            data.setValue("Guaviare : "+String.valueOf(Guaviare),Guaviare);
        }
        if(dif(Vaupes)){
            data.setValue("Vaupes : "+String.valueOf(Vaupes),Vaupes);
        }
        if(dif(Vichada)){
            data.setValue("Vichada : "+String.valueOf(Vichada),Vichada);
        }
        
        
       
        
        JFreeChart cha = ChartFactory.createPieChart3D("Infectados por Departamento", data,true,true,true);
        
        ChartPanel cp = new ChartPanel(cha);
        cp.setBounds(500,40,500,400);
        cp.setVisible(true);
        return cp;
    }

    
}

