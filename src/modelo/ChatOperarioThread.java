/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Vista.ChatOperario;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ChatOperarioThread extends Thread {

    private Socket socket = null;
    private ChatOperario vista = null;
    private DataInputStream canalEntrada = null;
    private DataOutputStream canalSalida = null;
    private boolean conectado;

    public ChatOperarioThread(ChatOperario operador) {
        this.vista = operador;
    }
    //Abre los canales de entrada y salida del cliente
    public void open() {
        try {
            canalEntrada = new DataInputStream(socket.getInputStream());
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(vista,"Error opteniendo el canal de entrada: " + ioe.getMessage());
        }
        try {
            canalSalida = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(vista,"Error opteniendo el canal de salida: " + ioe.getMessage());
        }
    }
    //cierra los canales de entrada y salida del cliente
    public void close() {
        try {
            if (canalEntrada != null) {
                canalEntrada.close();
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(vista,"Error cerrando el canal de entrada: " + ioe.getMessage());
        }
        try {
            if (canalSalida != null) {
                canalSalida.close();
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(vista,"Error cerrando el canal de salida: " + ioe.getMessage());
        }
    }
    
    //Inicia el hilo, hace la conexion al servidor 
    @Override
    public void run() {
        vista.entrada("Estableciendo conexion. Por favor espere...");
        try {
            socket = new Socket("127.0.0.1", 9999);
            vista.entrada("Connectado. " /*+ socket.getInetAddress().getHostName()*/);
            open();
            conectado = true;
            enviarDatos(1, vista.getNombreC());
            enviarDatos(0, "");
            while (conectado) {
                int codigo = canalEntrada.readInt();
                String mensaje = canalEntrada.readUTF();
                switch(codigo){
                    case 1:
                        vista.limpiar();
                        
                        break;
                    case 2:
                        vista.entrada(mensaje);
                        break;
                    case 3:
                        vista.entrada(mensaje);
                        close();
                        break;
                }
            }
        } catch (IOException ioe) {
            //JOptionPane.showMessageDialog(vista,"Excepcion inesperada: " + ioe.getMessage());
            vista.setCliente(null);
            this.stop();
        }
    }
    
  

    //envia los datos al servidor
    public void enviarDatos(int codigo, String mensaje) {
        try {
            canalSalida.writeInt(codigo);
            canalSalida.writeUTF(mensaje);
            canalSalida.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(vista, "Error al enviar el mensaje: " + e.getMessage());
        }
    }
}
