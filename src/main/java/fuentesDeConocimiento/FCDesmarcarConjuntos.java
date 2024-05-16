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
import exceptions.ConjuntoNoValidoException;
import exceptions.PuntosNoValidosException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class FCDesmarcarConjuntos extends FuenteConocimiento{

    private LogicaTablero lt;
    private LogicaJugador lj;
    private PartidaDTO pdto;
    
    @Override
    public void ejecutar(Datos datos) {
       
    }

    @Override
    public void ejecutar() {
        lt = (LogicaTablero) Tablero.obtenerInstancia();
        pdto = (PartidaDTO) Partida.obtenerInstancia();
        try {
            //Validar conjuntos
            lt.validarConjuntos();
        } catch (ConjuntoNoValidoException e) {
            System.err.print(e);
            this.board.actualizarMensajeError(e.toString());
        }

        Jugador jugador = pdto.obtenerJugador();
        lj = jugador;
        //Validar 30 puntos si es el primer turno del jugador
        if (lj.esPrimerTurno()) {
            try {
                lt.validar30Puntos();
            } catch (PuntosNoValidosException e) {
               System.err.print(e);
                this.board.actualizarMensajeError(e.toString());
            }
        }

        //Desmarcar los conjuntos
        lt.desmarcarConjuntos();

        this.board.actualizarDatos("guardarPartida");
    }

}
