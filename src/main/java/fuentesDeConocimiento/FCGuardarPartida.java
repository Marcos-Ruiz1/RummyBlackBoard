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
        
    }

    @Override
    public void ejecutar() {
        lp = Partida.obtenerInstancia();
        lp.guardarPartida();
        
        this.board.actualizarDatos("terminarPartida");
    }

}
