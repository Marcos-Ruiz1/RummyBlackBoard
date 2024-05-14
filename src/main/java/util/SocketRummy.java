/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import arqui.util.Datos;
import interaces.Blackboard;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natsu
 */
public class SocketRummy extends Thread {

    private final int SERVER_SOCKET = 9000;

    private int port;
    private String host;
    private final Socket clientSocket;
    private final ServerSocket serverSocket;

    private ObjectOutput output;
    private ObjectInput input;

//    private Socket[] clients; queda a sugerencia
    @Override
    public void run() {

        try {
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            Logger.getLogger(SocketRummy.class.getName()).log(Level.SEVERE, null, ex);
        }

        Datos d;

        try {

            while (true) {

                ProxyServer.obtenerInstancia().notificar(input);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void sendData(Blackboard blackboard) throws IOException {

        output.writeObject(blackboard);

    }

    public SocketRummy(String host, int port) throws IOException {

        this.port = port;
        this.host = host;

        this.serverSocket = new ServerSocket(this.SERVER_SOCKET);

        this.clientSocket = this.serverSocket.accept();

    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

}
