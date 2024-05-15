/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import interfaces.FuenteConocimiento;
import DOMINIO.Tablero;
import DOMINIO.Jugador;
import DOMINIO.Partida;
import arqui.util.Datos;
import interaces.LogicaTablero;
import interaces.LogicaJugador;
import interaces.PartidaDTO;

/**
 *
 * @author marco
 */
public class FCDesmarcarConjuntos extends FuenteConocimiento {

    private LogicaTablero lt;
    private LogicaJugador lj;
    private PartidaDTO pdto;
    
    @Override
    public void ejecutar(Datos datos) {
        
        lt = (LogicaTablero) Tablero.obtenerInstancia();
        pdto = (PartidaDTO) Partida.obtenerInstancia();
        //Validar conjuntos
        lt.validarConjuntos();

        Jugador jugador = pdto.obtenerJugador();
        lj = jugador;
        //Validar 30 puntos si es el primer turno del jugador
        if (lj.esPrimerTurno()) {
            lt.validar30Puntos();
        }

        //Desmarcar los conjuntos
        lt.desmarcarConjuntos();

        this.board.actualizarDatos("guardarPartida");
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
