/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Ficha;
import arqui.util.Datos;
import interaces.LogicaMazo;
import interfaces.FuenteConocimiento;
import java.util.List;

/**
 *
 * @author natsu
 */
public class FCEliminarFichas extends FuenteConocimiento {

    @Override
    public void ejecutar(Datos datos) {

        List<Ficha> fichas = (List<Ficha>) datos.getDatos();

        LogicaMazo logicaMazo = this.board.obtenerLogicaMazoJugadorActual();;
        for (Ficha ficha : fichas) {
            logicaMazo.eliminarFichasJugador(ficha);
        }

        this.board.actualizarDatos("FCEliminarFichas");

    }

    @Override
    public void ejecutar() {

    }

}
