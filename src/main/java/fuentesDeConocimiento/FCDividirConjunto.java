/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Tablero;
import arqui.util.Datos;
import arqui.util.DividirConjuntoDatos;
import interaces.LogicaJugador;
import interaces.LogicaTablero;
import interfaces.FuenteConocimiento;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author natsu
 */
public class FCDividirConjunto extends FuenteConocimiento {

    @Override
    public void ejecutar(Datos datos) {

        LogicaJugador jugador = this.board.obtenerLogicaJugadorActual();

        if (jugador.esPrimerTurno()) {
            this.board.actualizarMensajeError("No puedes dividir en el primer turno");
            return;
        }

        DividirConjuntoDatos dividirConjuntoDatos = (DividirConjuntoDatos) datos.getDatos();

        LogicaTablero logicaTablero = Tablero.obtenerInstancia();

        Map<String, Integer> mapa = new HashMap();
        mapa.put("inicio", dividirConjuntoDatos.getRango()[0]);
        mapa.put("final", dividirConjuntoDatos.getRango()[1]);

        logicaTablero.dividirConjunto(dividirConjuntoDatos.getConjunto(), mapa);

        this.board.actualizarDatos("Finalizo");
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
