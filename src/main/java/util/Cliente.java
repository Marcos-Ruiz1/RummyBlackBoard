/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import DOMINIO.PartidaDTOClazz;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author natsu
 */
public class Cliente extends Thread {

    private final Socket socket;
    private final ObjectOutputStream ous;
    private final ObjectInputStream ois;

    public Cliente(Socket socket) throws IOException {
        this.socket = socket;
        this.ous = new ObjectOutputStream(socket.getOutputStream());
        this.ois = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {

        try {
            while (true) {
                Object obj = ois.readObject();
                ProxyServer.obtenerInstancia().notificar(obj);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void enviarDatos(PartidaDTOClazz partida) {

        try {
            ous.writeUnshared(partida);
            ous.reset();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("No pudo escribir");
        }

    }

}
