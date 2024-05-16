/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Conjunto;
import DOMINIO.Ficha;
import arqui.util.AgregarFichaConjunto;
import arqui.util.Datos;
import interaces.LogicaJugador;
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
        Conjunto c = conjunto.agregarFicha(ficha, delante);

        this.board.actualizarDatos(c, "Eliminar Conjunto");
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
