/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Conjunto;
import DOMINIO.Ficha;
import DOMINIO.Tablero;
import arqui.util.AgregarFichaConjunto;
import arqui.util.Datos;
import interaces.LogicaJugador;
import interaces.LogicaTablero;
import interfaces.FuenteConocimiento;

/**
 *
 * @author natsu
 */
public class FCAgregarFicha extends FuenteConocimiento {

    @Override
    public void ejecutar(Datos datos) {

        LogicaJugador logica = this.board.obtenerLogicaJugadorActual();

        if (logica.esPrimerTurno()) {
            this.board.actualizarMensajeError("No puedes agregar fichas en tu primer turno");
            return;
        }

        AgregarFichaConjunto agregarFichaConjunto = (AgregarFichaConjunto) datos.getDatos();
        Conjunto conjunto = agregarFichaConjunto.getConjunto();
        Ficha ficha = agregarFichaConjunto.getFicha();
        boolean delante = agregarFichaConjunto.isDelante();

        LogicaTablero logicaTablero = Tablero.obtenerLogica();
        logicaTablero.agregarFichaConjunto(conjunto, ficha, delante);

        this.board.actualizarDatos("Eliminar conjunto");
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
