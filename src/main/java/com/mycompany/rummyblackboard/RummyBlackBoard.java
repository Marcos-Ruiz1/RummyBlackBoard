/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.rummyblackboard;

import DOMINIO.Conjunto;
import DOMINIO.ConjuntoGrupo;
import DOMINIO.Ficha;
import DOMINIO.FichaNumerica;
import DOMINIO.GrupoFicha;
import DOMINIO.Jugador;
import DOMINIO.Mazo;
import DOMINIO.Partida;
import DOMINIO.Pila;
import DOMINIO.Tablero;
import java.util.ArrayList;
import java.util.List;
import util.SocketRummy;

/**
 *
 * @author marco
 */
public class RummyBlackBoard {

    public static void main(String[] args) {
        System.out.println("Proyecto rumyyyyy :8)");
        Partida.obtenerInstancia();

        //Declaración de jugadores
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugador1.setTurno(true);
        jugador2.setTurno(false);
        Mazo mazo1 = new Mazo();
        Ficha fichamazo1 = new FichaNumerica((byte) 13);
        fichamazo1.setGrupoFicha(GrupoFicha.ROJO);
        Ficha fichamazo2 = new FichaNumerica((byte) 14);
        Ficha fichamazo3 = new FichaNumerica((byte) 15);
        Ficha fichamazo4 = new FichaNumerica((byte) 16);
        Ficha fichamazo5 = new FichaNumerica((byte) 17);
        fichamazo5.setGrupoFicha(GrupoFicha.ROJO);
        Ficha fichamazo6 = new FichaNumerica((byte) 18);
        fichamazo6.setGrupoFicha(GrupoFicha.ROJO);
        List<Ficha> fichasenmazo = new ArrayList<>();
        fichasenmazo.add(fichamazo1);
        fichasenmazo.add(fichamazo2);
        fichasenmazo.add(fichamazo3);
        fichasenmazo.add(fichamazo4);
        fichasenmazo.add(fichamazo5);
        fichasenmazo.add(fichamazo6);
        mazo1.setFichas(fichasenmazo);
        jugador1.setMazo(mazo1);
        // Crear un nuevo mazo para el jugador 2
        Mazo mazo2 = new Mazo();

        // Crear nuevas fichas para el mazo del jugador 2
        Ficha fichamazo7 = new FichaNumerica((byte) 19);
        Ficha fichamazo8 = new FichaNumerica((byte) 20);
        Ficha fichamazo9 = new FichaNumerica((byte) 21);
        Ficha fichamazo10 = new FichaNumerica((byte) 22);
        Ficha fichamazo11 = new FichaNumerica((byte) 23);
        Ficha fichamazo12 = new FichaNumerica((byte) 24);

        // Crear una lista para almacenar las fichas en el mazo del jugador 2
        List<Ficha> fichasenmazo2 = new ArrayList<>();
        fichasenmazo2.add(fichamazo7);
        fichasenmazo2.add(fichamazo8);
        fichasenmazo2.add(fichamazo9);
        fichasenmazo2.add(fichamazo10);
        fichasenmazo2.add(fichamazo11);
        fichasenmazo2.add(fichamazo12);

        // Asignar las fichas al mazo del jugador 2
        mazo2.setFichas(fichasenmazo2);

        // Asignar el mazo al jugador 2
        jugador2.setMazo(mazo2);
        List<Jugador> jugadoresDePartida = new ArrayList<>();
        jugadoresDePartida.add(jugador1);
        jugadoresDePartida.add(jugador2);

        //Creación de fichas para los conjuntos
        FichaNumerica fichanumerica1 = new FichaNumerica();
        fichanumerica1.setNumero((byte) 10);
        FichaNumerica fichanumerica2 = new FichaNumerica();
        fichanumerica2.setNumero((byte) 11);
        FichaNumerica fichanumerica3 = new FichaNumerica();
        fichanumerica3.setNumero((byte) 12);

        List<Ficha> fichas = new ArrayList<>();

        fichas.add(fichanumerica1);
        fichas.add(fichanumerica2);
        fichas.add(fichanumerica3);

        //Tablero y conjuntos agregados al tablero
        Conjunto conjuntoPrueba = new ConjuntoGrupo();
        conjuntoPrueba.setFichas(fichas);
        List<Conjunto> listaConjuntos = new ArrayList<>();
        listaConjuntos.add(conjuntoPrueba);
        Tablero.obtenerInstancia().setConjuntos(listaConjuntos);

        //Pila
        Ficha fichamazo13 = new FichaNumerica((byte) 30);
        Ficha fichamazo14 = new FichaNumerica((byte) 31);
        Ficha fichamazo15 = new FichaNumerica((byte) 32);
        List<Ficha> fichasPozo = new ArrayList<>();
        fichasPozo.add(fichamazo13);
        fichasPozo.add(fichamazo14);
        fichasPozo.add(fichamazo15);
        Pila.obtenerInstancia().setFichas(fichasPozo);

        //Agregación de componentes a la partida
        Partida.obtenerInstancia().setTablero(Tablero.obtenerInstancia());
        Partida.obtenerInstancia().setJugadores(jugadoresDePartida);
        Partida.obtenerInstancia().setNumeroJugador(0);
        Partida.obtenerInstancia().setPila(Pila.obtenerInstancia());

        try {
            SocketRummy rummy = new SocketRummy();
            rummy.start();
        } catch (Exception e) {
            System.out.println("Error al crear el servidor");
        }
    }
}
