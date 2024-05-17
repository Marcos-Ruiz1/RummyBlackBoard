/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Ficha;
import DOMINIO.Jugador;
import DOMINIO.Partida;
import DOMINIO.Pila;
import arqui.util.Datos;
import exceptions.PozoFichasInexistentesException;
import interaces.LogicaJugador;
import interaces.LogicaPila;
import interaces.PartidaDTO;
import interaces.PilaDTO;
import interfaces.FuenteConocimiento;
import util.ProxyServer;

/**
 *
 * @author TADEO
 */
public class FCAgregarFichaAMazo extends FuenteConocimiento {

    LogicaPila logicaPila = (LogicaPila) Pila.obtenerInstancia();
    LogicaJugador logicaJugador;
    PartidaDTO partidaDTO = (PartidaDTO) Partida.obtenerInstancia();
    PilaDTO pilaDTO = (PilaDTO) Pila.obtenerInstancia();

    @Override
    public void ejecutar(Datos datos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ejecutar() {
        try {
            // Validar fichas en pozo
            logicaPila.validarFichasExistentesPozo();
        } catch (PozoFichasInexistentesException e) {
            System.err.print(e);
            this.board.actualizarMensajeError(e.toString());
        }
        
        Ficha ficha = pilaDTO.obtenerFicha();
        Jugador jugador = partidaDTO.obtenerJugador();
        logicaJugador = jugador;
        jugador.agregarFichaAMazo(ficha);

        //Validar si es o no el primer turno del jugador
        if (!jugador.esPrimerTurno()) {
            // Si no es, terminará el turno
            this.board.actualizarDatos("TerminarTurno");
        } else {
            // Si lo es, enviara los datos al server
            ProxyServer.enviarDatos(board);
        }
    }
}
