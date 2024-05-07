/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import interfaces.FuenteConocimiento;
import DOMINIO.Tablero;
import DOMINIO.Jugador;
import arqui.util.Datos;
import interaces.LogicaTablero;
import interaces.LogicaConjunto;
import interaces.LogicaJugador;
import interaces.Blackboard;

/**
 *
 * @author marco
 */
public class FCDesmarcarConjuntos extends FuenteConocimiento {

    private LogicaTablero lt;
    private LogicaConjunto lc;
    private LogicaJugador lj;
    Blackboard blackboard;

    @Override
    public void ejecutar(Datos datos) {
        lt = (LogicaTablero) Tablero.obtenerInstancia();
        lj = new Jugador();

        //Validar conjuntos
        lt.validarConjuntos();

        //Validar 30 puntos si es el primer turno del jugador
        if (lj.esPrimerTurno()) {
//            lc.validar30Puntos();
        }

        //Desmarcar los conjuntos
        lt.desmarcarConjuntos();

        //Actualizar el blackboard
//        blackboard.actualizarDatos(lt);
    }

}
