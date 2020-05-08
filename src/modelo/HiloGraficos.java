/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Graficos.Grafico;
import static Vista.Principal.jDesktopPane1;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Yovany
 */
public class HiloGraficos implements Runnable {

    private Grafico grafico;
    JDesktopPane panel;
    private InfectadoDAO antesList;
    private ArrayList<Infectado> list;
    private Grafico graf;
    private ChartPanel graficoR;
    private ChartPanel graficoE;
    private ChartPanel graficoD;
    private ChartPanel graficoS;
    private ChartPanel graficoW;

    public HiloGraficos(Grafico grafico, JDesktopPane panel) {
        this.grafico = grafico;
        this.panel = panel;
        this.antesList = new InfectadoDAO();
        this.list = this.antesList.listadoInf("0");
        this.graf = new Grafico();
        this.graficoR = graf.rela(this.list);
        this.graficoE = graf.edad(this.list);
        this.graficoD = graf.departamentos(this.list);
        this.graficoS = graf.fecha(this.list);
        this.graficoW = graf.estado(this.list);
        this.panel.add(this.graficoR);
        this.panel.add(this.graficoE);
        this.panel.add(this.graficoD);
        this.panel.add(this.graficoS);
        this.panel.add(this.graficoW);
        graficoR.setBounds(30, 0, 530, 270);
        graficoE.setBounds(30, 272, 530, 270);
        graficoW.setBounds(30, 544, 530, 270);
        graficoD.setBounds(630, 0, 750, 400);
        graficoS.setBounds(630, 412, 750, 400);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3000; i++) {
            this.list = this.antesList.listadoInf("0");
            this.panel.remove(this.graficoR);
            this.panel.remove(this.graficoE);
            this.panel.remove(this.graficoD);
            this.panel.remove(this.graficoS);
            this.panel.remove(this.graficoW);

            this.graficoR = graf.rela(this.list);
            this.graficoE = graf.edad(this.list);
            this.graficoD = graf.departamentos(this.list);
            this.graficoS = graf.fecha(this.list);
            this.graficoW = graf.estado(this.list);
            graficoR.setVisible(false);
            graficoE.setVisible(false);
            graficoW.setVisible(false);
            graficoD.setVisible(false);
            graficoS.setVisible(false);
            this.panel.add(graficoR);
            this.panel.add(graficoE);
            this.panel.add(graficoD);
            this.panel.add(graficoS);
            this.panel.add(graficoW);
            
            graficoR.setBounds(30, 0, 530, 270);
            graficoE.setBounds(30, 272, 530, 270);
            graficoW.setBounds(30, 544, 530, 270);
            graficoD.setBounds(630, 0, 750, 400);
            graficoS.setBounds(630, 412, 750, 400);
            graficoR.setVisible(true);
            graficoE.setVisible(true);
            graficoW.setVisible(true);
            graficoD.setVisible(true);
            graficoS.setVisible(true);
            
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                System.out.println("Finalizado");
            }
        }
    }

}
