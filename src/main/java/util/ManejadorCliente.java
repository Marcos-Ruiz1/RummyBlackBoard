/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author natsu
 */
public class ManejadorCliente {

    private final List<Cliente> socketsClientes;
    private static ManejadorCliente instancia;

    private ManejadorCliente() {
        this.socketsClientes = new LinkedList();
    }

    public static ManejadorCliente obtenerInstancia() {
        if (ManejadorCliente.instancia == null) {
            ManejadorCliente.instancia = new ManejadorCliente();
        }

        return ManejadorCliente.instancia;
    }

    public void agregarCliente(Socket socket) {

        try {
            Cliente c = new Cliente(socket);
            c.start();
            socketsClientes.add(c);
        } catch (Exception e) {
            System.out.println("Error al intentar agregar al usuario");
        }

    }

    public Cliente obtenerCliente(int numero) {
        return socketsClientes.get(numero);
    }

}
