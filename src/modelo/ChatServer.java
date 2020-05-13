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

public class ChatServer implements Runnable {

    private ChatServerThread clients[] = new ChatServerThread[2];
    private ServerSocket server = null;
    private Thread thread = null;
    private int clientCount = 0;

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

    private int buscaClient(int ID) {
        for (int i = 0; i < clientCount; i++) {
            if (clients[i].getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public synchronized void handle(int ID, String input) {
        /*if (input.equals("chiao")) {
            clients[buscaClient(ID)].send("chiao");
            
            remove(ID);
        } else {*/
            for (int i = 0; i < clientCount; i++) {
                clients[i].enviarDatos(ID, input);
            }
        //}
    }

    public synchronized void remove(int ID) {
        int pos = buscaClient(ID);
        if (pos >= 0) {
            ChatServerThread terminar = clients[pos];
            System.out.println("Removiendo el cliente con el puerto " + ID + " en posicion " + pos);
            if (pos < clientCount - 1) {
                for (int i = pos + 1; i < clientCount; i++) {
                    clients[i - 1] = clients[i];
                }
            }
            clientCount--;
            try {
                terminar.cerrar();
            } catch (IOException ioe) {
                System.out.println("Error cerrando hilo: " + ioe);
            }
            terminar.stop();
        }
    }

    private void addThread(Socket socket) {
        if (clientCount < clients.length) {
            System.out.println("Cliente aceptado: " + socket);
            clients[clientCount] = new ChatServerThread(this, socket);
            clientCount++;
        }else{
            DataOutputStream canalSalida = null;
            try {
                canalSalida = new DataOutputStream(socket.getOutputStream());
                canalSalida.writeUTF("Todos nuestros asesores estan ocupados. \nPor favor intente mas tarde");
            } catch (IOException ex) {
                System.out.println("Error abriendo canal de salida: " + ex.getMessage());
            } finally {
                try {
                    canalSalida.close();
                } catch (IOException ex) {
                    System.out.println("Error cerrando canal de salida: " + ex.getMessage());
                }
            }
        }
    }
    
}
