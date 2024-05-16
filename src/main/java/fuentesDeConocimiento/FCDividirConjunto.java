/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import arqui.util.Datos;
import arqui.util.DividirConjuntoDatos;
import interaces.LogicaConjunto;
import interaces.LogicaJugador;
import interfaces.FuenteConocimiento;

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

        LogicaConjunto conjunto = dividirConjuntoDatos.getConjunto();
        conjunto.
        
        int[] rango = dividirConjuntoDatos.getRango();

    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
