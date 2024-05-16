/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Conjunto;
import arqui.util.AgregarFichaConjunto;
import arqui.util.Datos;
import interaces.LogicaTablero;
import interfaces.FuenteConocimiento;

/**
 *
 * @author natsu
 */
public class FCEliminarConjunto extends FuenteConocimiento {

    @Override
    public void ejecutar(Datos datos) {

        AgregarFichaConjunto agregarFichaConjunto = (AgregarFichaConjunto) datos.getDatos();

        Conjunto conjunto = agregarFichaConjunto.getConjunto();

        LogicaTablero tablero = this.board.obtenerLogicaTablero();

        tablero.eliminarConjunto(conjunto);

        this.board.actualizarDatos("Eliminar fichas");
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
