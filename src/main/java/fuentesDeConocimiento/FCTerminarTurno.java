/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Partida;
import arqui.util.Datos;
import interaces.LogicaPartida;
import interfaces.FuenteConocimiento;

/**
 *
 * @author marco
 */
public class FCTerminarTurno extends FuenteConocimiento {

    private LogicaPartida lp;

    @Override
    public void ejecutar(Datos d) {

    }

    @Override
    public void ejecutar() {
        lp = Partida.obtenerInstancia();

        lp.terminarTurno();

        this.board.actualizarDatos("Finalizar");
    }

}
