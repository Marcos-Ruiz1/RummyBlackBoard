/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author natsu
 */
public class SocketRummy extends Thread {

    private final int SERVER_SOCKET = 9000;

    private int port;
    private String host;
    private final ServerSocket serverSocket;

//    private Socket[] clients; queda a sugerencia
    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Escuchando.....");
                Socket socket = this.serverSocket.accept();
                ManejadorCliente.obtenerInstancia().agregarCliente(socket);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public SocketRummy() throws IOException {
        this.serverSocket = new ServerSocket(this.SERVER_SOCKET);
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
