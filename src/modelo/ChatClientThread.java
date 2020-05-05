/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import Vista.ChatClient;
import java.net.*;
import java.io.*;

/**
 *
 * @author Victor
 */

public class ChatClientThread extends Thread
{  
    private Socket socket = null;
    private ChatClient client = null;
    private DataInputStream canalEntrada = null;

    public ChatClientThread(ChatClient client, Socket socket)
    {  this.client = client;
       this.socket = socket;
       open();  
       start();
    }
    public void open(){  
        try{
            canalEntrada  = new DataInputStream(socket.getInputStream());
       }
       catch(IOException ioe){
            System.out.println("Error opteniendo el canal de entrada: " + ioe);
            //client.stop();
       }
    }
    
    public void close(){
        try{
            if (canalEntrada != null) 
                canalEntrada.close();
        }catch(IOException ioe){
            client.entrada("Error cerrando el canal de entrada: " + ioe);
       }
    }   
    public void run()
    {  while (true){
        try{
            client.handle(canalEntrada.readUTF());
        }catch(IOException ioe){
            client.entrada("Error al escuchar: " + ioe.getMessage());
            //client.stop();
          }
       }
    }
}
