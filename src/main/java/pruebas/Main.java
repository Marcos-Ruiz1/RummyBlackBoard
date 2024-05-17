/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import DOMINIO.Conjunto;
import DOMINIO.ConjuntoGrupo;
import DOMINIO.ConjuntoSecuencia;
import DOMINIO.Ficha;
import DOMINIO.FichaNumerica;
import DOMINIO.GrupoFicha;
import DOMINIO.Jugador;
import DOMINIO.Mazo;
import DOMINIO.Partida;
import DOMINIO.Tablero;
import arqui.util.Datos;
import arqui.util.DividirConjuntoDatos;
import controlador.ControladorPartida;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natsu
 */
public class Main {

    public static void main(String[] args) {
        Jugador j1 = new Jugador();

        Mazo m = new Mazo();
        j1.setMazo(m);

        List<Ficha> fichas = new ArrayList();

        Tablero t = Tablero.obtenerInstancia();
        Partida p = Partida.obtenerInstancia();

        p.getJugadores().add(j1);

        //Para un conjunto
        FichaNumerica f = new FichaNumerica((byte) 1);
        FichaNumerica f2 = new FichaNumerica((byte) 2);
        FichaNumerica f3 = new FichaNumerica((byte) 3);
        FichaNumerica f4 = new FichaNumerica((byte) 4);
        f.setGrupoFicha(GrupoFicha.ROJO);
        f2.setGrupoFicha(GrupoFicha.ROJO);
        f3.setGrupoFicha(GrupoFicha.ROJO);
        f4.setGrupoFicha(GrupoFicha.ROJO);

        List<Ficha> conjuntoSecuencia = new ArrayList();
        conjuntoSecuencia.add(f);
        conjuntoSecuencia.add(f2);
        conjuntoSecuencia.add(f3);
        conjuntoSecuencia.add(f4);
        Conjunto c = new ConjuntoSecuencia(conjuntoSecuencia);
        t.getConjuntos().add(c);

        //Para el mazo
        FichaNumerica f5 = new FichaNumerica((byte) 5);
        FichaNumerica f6 = new FichaNumerica((byte) 6);
        FichaNumerica f7 = new FichaNumerica((byte) 7);

        f5.setGrupoFicha(GrupoFicha.ROJO);
        f6.setGrupoFicha(GrupoFicha.ROJO);
        f7.setGrupoFicha(GrupoFicha.ROJO);

        fichas.add(f5);
        fichas.add(f6);
        fichas.add(f7);

        m.setFichas(fichas);

        Datos d = new Datos();

        d.setMensaje("dividirConjunto");

        DividirConjuntoDatos datos2 = new DividirConjuntoDatos();
        datos2.setConjunto(new ConjuntoGrupo(new ArrayList(conjuntoSecuencia)));
        int a[] = {0, 2};
        datos2.setRango(a);

        d.setDatos(datos2);

        j1.setTurno(false);
        Partida.obtenerInstancia().agregarObservador(ControladorPartida.obtenerInstancia());

        ControladorPartida.obtenerInstancia().dividirConjunto(d);

    }

}
