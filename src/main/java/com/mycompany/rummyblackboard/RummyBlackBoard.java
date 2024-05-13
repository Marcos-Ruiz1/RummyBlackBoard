/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rummyblackboard;
import controlador.*;
import fuentesDeConocimiento.*;
import DOMINIO.*;
import interaces.Observer;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author marco
 */
public class RummyBlackBoard {

    public static void main(String[] args) {
        System.out.println("Proyecto rumyyyyy :8)");
        
        Partida.obtenerInstancia();
        Partida.obtenerInstancia().subscribir(ControladorPartida.obtenerInstancia());
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugador1.setTurno(false);
        jugador2.setTurno(false);
        
        List<Jugador> jugadoresDePartida = new ArrayList<>();
        jugadoresDePartida.add(jugador1);
        jugadoresDePartida.add(jugador2);
        FichaNumerica fichanumerica1 = new FichaNumerica();
        fichanumerica1.setNumero((byte)4);
        FichaNumerica fichanumerica2 = new FichaNumerica();
        fichanumerica2.setNumero((byte)5);
        Comodin fichaComodin= new Comodin();
        FichaNumerica fichanumerica3 = new FichaNumerica();
        fichanumerica3.setNumero((byte)5);
        
        List<Ficha> fichas = new ArrayList<>();
        
        fichas.add(fichanumerica1);
        fichas.add(fichanumerica2);
        fichas.add(fichaComodin);
        fichas.add(fichanumerica3);
        
        Conjunto conjuntoPrueba = new ConjuntoGrupo();
        
        conjuntoPrueba.setFichas(fichas);
        List<Conjunto> listaConjuntos = new ArrayList<>();
        listaConjuntos.add(conjuntoPrueba);
        Tablero.obtenerInstancia().setConjuntos(listaConjuntos);
        
        Partida.obtenerInstancia().setTablero(Tablero.obtenerInstancia());
        Partida.obtenerInstancia().setJugadores(jugadoresDePartida);
       
    }
}
