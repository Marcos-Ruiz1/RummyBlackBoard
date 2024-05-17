/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import DOMINIO.PartidaDTOClazz;
import arqui.util.Datos;
import controlador.ControladorPartida;
import interfaces.FuenteConocimiento;
import java.util.Map;

/**
 *
 * @author Rosa preciosa chula!!
 */
public class ProxyServer {

    private static SocketRummy socket;

    private static ProxyServer instancia;

    synchronized public void notificar(Object obj) {

        ControladorPartida cp = ControladorPartida.obtenerInstancia();

        try {
            Datos d = (Datos) obj;

            switch (d.getMensaje()) {
                case "Agregar sin conjunto" ->
                    ControladorPartida.obtenerInstancia().agregarSinConjunto(d);
                case "terminar turno" -> {

                    Map<String, FuenteConocimiento> fuentes
                            = ControladorPartida.obtenerInstancia().fuentesConocimiento;

                    ControladorPartida
                            .obtenerInstancia()
                            .desmarcarConjuntos();
                }
                case "restaurar partida" ->
                    ControladorPartida.obtenerInstancia().restuararPartida();
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

    public static void enviarDatos(PartidaDTOClazz partida, int numSocket) {

        try {

            ManejadorCliente.obtenerInstancia()
                    .obtenerCliente(numSocket)
                    .enviarDatos(partida);

        } catch (Exception e) {
            System.out.println("Error en proxyServer ln 61");
            System.out.println(e.getMessage());
        }

    }

    private ProxyServer() {

    }

}
