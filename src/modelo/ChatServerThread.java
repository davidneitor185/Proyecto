/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.*;
import java.net.*;

/**
 *
 * @author Victor
 */
public class ChatServerThread extends Thread {

    private ChatServer server = null;
    private Socket socket = null;
    private int ID = -1;
    private DataInputStream canalEntrada = null;
    private DataOutputStream canalSalida = null;

    public ChatServerThread(ChatServer server, Socket socket) {
        super();
        this.server = server;
        this.socket = socket;
        ID = socket.getPort();
    }

    public void send(String msg) {
        try {
            canalSalida.writeUTF(msg);
            canalSalida.flush();
        } catch (IOException ioe) {
            System.out.println(ID + " ERROR enviando: " + ioe.getMessage());
            server.remove(ID);
            stop();
        }
    }

    public int getID() {
        return ID;
    }

    public void run() {
        System.out.println("Server Thread " + ID + " running.");
        while (true) {
            try {
                server.handle(ID, canalEntrada.readUTF());
            } catch (IOException ioe) {
                System.out.println(ID + " ERROR reading: " + ioe.getMessage());
                server.remove(ID);
                stop();
            }
        }
    }

    public void open() throws IOException {
        canalEntrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        canalSalida = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        } if (canalEntrada != null) {
            canalEntrada.close();
        } if (canalSalida != null) {
            canalSalida.close();
        }
    }
}
