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

    private int buscaClient(int puerto) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getPuerto() == puerto) {
                return i;
            }
        }
        return -1;
    }
    
    public synchronized boolean asignar(ChatServerThread cliente){
        if(operarios.size() > 0 ){
            int i = 0;
            ChatServerThread operario = null;
            while (operarios.get(i).getPuertoC()!= 0 && i <operarios.size()){
                i++;
            }
            if (i <operarios.size() ){
                cliente.setPuertoC(operarios.get(i).getPuerto());
                operarios.get(i).setPuertoC(cliente.getPuerto());
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
            }
        }
    }
    
    public synchronized void pasarOperario(int puerto) {
        int pos = buscaClient(puerto);
        if (pos >= 0) {
            ChatServerThread cambio = clientes.get(pos);
            clientes.remove(pos);
            System.out.println("cambiando usuario a operarios " + puerto + " en " + pos);
            operarios.add(cambio);
        }    
    }

    public synchronized void remove(ChatServerThread cliente) {
        ChatServerThread terminar = cliente;
        for (ChatServerThread p : operarios) {
            if (p.getPuerto() == cliente.getPuertoC()) {
                p.setPuertoC(0);
            }
        }
        System.out.println("Removiendo hilo " + cliente.getPuerto());
        clientes.remove(cliente);
        try {
            terminar.cerrar();
        } catch (IOException ioe) {
            System.out.println("Error cerrando hilo: " + ioe);
        }

    }

    private void addThread(Socket socket) { {
            System.out.println("Cliente aceptado: " + socket);
            clientes.add( new ChatServerThread(this, socket));
        }
    }   
}
