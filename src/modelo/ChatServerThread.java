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
    private Socket socket;
    private String tipo;
    private int puertoC;
    private int puerto;
    private String nombre;
    private DataInputStream canalEntrada;
    private DataOutputStream canalSalida;

    public ChatServerThread(ChatServer server, Socket socket) {
        this.socket = socket;
        this.server = server;
        puerto = socket.getPort();
        puertoC = 0;
        try {
            canalEntrada = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println( "ERROR abriendo calnal entrada " + puerto + ": " + ex.getMessage());
        }
        try {
            canalSalida = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println( "ERROR abriendo calnal salida " + puerto + ": " + ex.getMessage());
        }
        start();

    }
    
    public int getPuerto() {
        return puerto;
    }

    public int getPuertoC() {
        return puertoC;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPuertoC(int puertoC) {
        this.puertoC = puertoC;
    }

    public String getTipo() {
        return tipo;
    }
     

    public void enviarDatos(int codigo, String mensaje) {
        try {
            canalSalida.writeInt(codigo);
            canalSalida.writeUTF(mensaje);
            canalSalida.flush();
        } catch (IOException ioe) {
            System.out.println(nombre + " ERROR enviando: " + ioe.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void run() {
        System.out.println("Server Thread " + puerto + " running.");
        while (true) {
            try {
                int codigo = canalEntrada.readInt();
                String mensaje = canalEntrada.readUTF();
                switch (codigo) {
                    case 0:
                        server.pasarOperario(this);
                        
                        break;
                    case 1:
                        nombre = mensaje;
                        tipo = "cliente";
                        break;
                    case 2:
                        mensaje = nombre + ": " + mensaje;
                        server.handle(2, mensaje, this);
                        break;
                    case 3:
                        server.remove(this);
                        cerrar();
                        break;
                        
                    case 4:
                        if (!server.asignar(this)){
                            enviarDatos(3, "Nuestros Operarios se encuentran ocupados. "
                                    + "Por favor intente mas tarde");
                            server.remove(this);
                            cerrar();
                        }
                        
                        break;
                }
            } catch (Exception e) {
                System.out.println(nombre + " ERROR recibiendo mensaje: " + e.getMessage());
            }
        }
    }
   

    public void cerrar() throws IOException {
        if (socket != null) {
            socket.close();
        } if (canalEntrada != null) {
            canalEntrada.close();
        } if (canalSalida != null) {
            canalSalida.close();
        }
        this.stop();
    }
}
