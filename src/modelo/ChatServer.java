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

    private ChatServerThread clients[] = new ChatServerThread[10];
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
                System.out.println("Error de aceptación del servidor: " + ioe);
                detener();
            }
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
        if (input.equals("chiao")) {
            clients[buscaClient(ID)].send("chiao");
            
            remove(ID);
        } else {
            for (int i = 0; i < clientCount; i++) {
                clients[i].send(input);
            }
        }
    }

    public synchronized void remove(int ID) {
        int pos = buscaClient(ID);
        if (pos >= 0) {
            ChatServerThread toTerminate = clients[pos];
            System.out.println("Removing client thread " + ID + " at " + pos);
            if (pos < clientCount - 1) {
                for (int i = pos + 1; i < clientCount; i++) {
                    clients[i - 1] = clients[i];
                }
            }
            clientCount--;
            try {
                toTerminate.close();
            } catch (IOException ioe) {
                System.out.println("Error cerrando hilo: " + ioe);
            }
            toTerminate.stop();
        }
    }

    private void addThread(Socket socket) {
        if (clientCount < clients.length) {
            System.out.println("Cliente aceptado: " + socket);
            clients[clientCount] = new ChatServerThread(this, socket);
            try {
                clients[clientCount].open();
                clients[clientCount].start();
                clientCount++;
            } catch (IOException ioe) {
                System.out.println("Error abriendo hilo: " + ioe);
            }
        } else {
            System.out.println("Client refused: maximum " + clients.length + " reached.");
        }
    }
}
