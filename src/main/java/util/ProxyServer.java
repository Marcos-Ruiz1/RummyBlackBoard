/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import arqui.util.Datos;
import controlador.ControladorPartida;
import interaces.Blackboard;
import java.io.ObjectInput;

/**
 *
 * @author natsu
 */
public class ProxyServer {

    private static SocketRummy socket;

    private static ProxyServer instancia;

    public void notificar(ObjectInput stream) {

        try {
            Datos d = (Datos) stream.readObject();

            switch (d.getMensaje()) {
                case "Agregar sin conjunto" ->
                    ControladorPartida.obtenerInstancia().agregarSinConjunto(d);
                default ->
                    throw new AssertionError();
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Error en el proxy");
        }

    }

    public static ProxyServer obtenerInstancia() {
        if (ProxyServer.instancia == null) {
            ProxyServer.instancia = new ProxyServer();
        }
        return instancia;
    }

    public static void enviarDatos(Blackboard blackboard) {

        try {

            socket.sendData(blackboard);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private ProxyServer() {

    }

}
