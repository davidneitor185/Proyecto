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
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ChatServer implements Runnable {

    private ArrayList<ChatServerThread> clientes = new ArrayList();
    private ArrayList<ChatServerThread> operarios = new ArrayList();
    private ServerSocket server = null;
    private Thread thread = null;

    public ChatServer(int port) {
        try {
            System.out.println("Enlace a puerto: " + port + ", por favor espere");
            server = new ServerSocket(port);
            System.out.println("Servidor iniciado: " + server);
            iniciar();
        } catch (IOException ioe) {
            System.out.println("No se puede conectar al puerto " + port + ": " + ioe.getMessage());
        }
    }

    public void run() {
        while (thread != null) {
            try {
                System.out.println("Esperando por un cliente...");
                addThread(server.accept());
            } catch (IOException ioe) {
                System.out.println("Error de aceptación del servidor: " + ioe.getMessage());
            }
        }
        try {
            server.close();
        } catch (Exception e) {
            System.out.println("Error cerrando el servidor: " + e.getMessage());
        }
    }

    public void iniciar() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void detener() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }

    }

    
    public synchronized boolean asignar(ChatServerThread cliente){
        if(operarios.size() > 0 ){
            int i = 0;
            while (operarios.get(i).getPuertoC()!= 0 && i <operarios.size()){
                i++;
            }
            if (i <operarios.size() ){
                cliente.setPuertoC(operarios.get(i).getPuerto());
                operarios.get(i).setPuertoC(cliente.getPuerto());
                cliente.enviarDatos(2, "Bienvenido sera atendido por " + operarios.get(i).getNombre() );
                operarios.get(i).enviarDatos(2, "Cliente aceptado " + cliente.getNombre());
                return true;
            }
        }        
        return false;
    }
 
    public synchronized void handle(int codigo, String mensaje, ChatServerThread cliente) {
        ArrayList<ChatServerThread> lista;
        if (cliente.getTipo().equalsIgnoreCase("cliente"))
            lista = operarios;
        else
            lista = clientes;
        
        for (ChatServerThread p : lista) {
            if (p.getPuerto() == cliente.getPuertoC()) {
                p.enviarDatos(codigo, mensaje);
                cliente.enviarDatos(codigo, mensaje);
            }
        }
    }
    
    public synchronized void pasarOperario(ChatServerThread operario) {
        clientes.remove(operario);
        System.out.println("cambiando usuario a operarios " + operario.getPuerto());
        operario.setTipo("operario");
        operario.enviarDatos(2, "Esperando por un cliente");
        operarios.add(operario);
    }

    public synchronized void remove(ChatServerThread cliente) {
        if (cliente.getTipo().equalsIgnoreCase("cliente")){
            for (ChatServerThread p : operarios) {
                if (p.getPuerto() == cliente.getPuertoC()) {
                    p.enviarDatos(2, cliente.getNombre() + " ha dejado la sala. \nEsperando cliente nuevo");
                    p.setPuertoC(0);
                }
            }
            System.out.println("Removiendo hilo " + cliente.getPuerto());
            clientes.remove(cliente);
        }else{
            for (ChatServerThread p : clientes) {
                if (p.getPuerto() == cliente.getPuertoC()) {
                    p.setPuertoC(0);
                }
            }
            System.out.println("Removiendo hilo " + cliente.getPuerto());
            operarios.remove(cliente);
        }
        cliente.enviarDatos(2, "Se a desconectado del servidor");
    }

    private void addThread(Socket socket) { {
            System.out.println("Cliente aceptado: " + socket);
            clientes.add( new ChatServerThread(this, socket));
        }
    }   
}
