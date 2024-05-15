/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Partida;
import interfaces.FuenteConocimiento;

import arqui.util.Datos;
import interaces.LogicaPartida;

/**
 *
 * @author marco
 */
public class FCGuardarPartida extends FuenteConocimiento {

    LogicaPartida lp;
    @Override
    public void ejecutar(Datos datos) {

        lp = Partida.obtenerInstancia();
        lp.guardarPartida();
        
        this.board.actualizarDatos("terminarPartida");
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
