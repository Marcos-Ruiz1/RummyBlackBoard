/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Conjunto;
import DOMINIO.ConjuntoGrupo;
import DOMINIO.Ficha;
import arqui.util.Datos;
import interaces.LogicaConjunto;
import interfaces.FuenteConocimiento;
import java.util.List;

/**
 *
 * @author natsu
 */
public class FCAgregarConjunto extends FuenteConocimiento {

    @Override
    public void ejecutar(Datos d) {

        List<Ficha> fichas = (List<Ficha>) d.getDatos();
//        Esto nomas esta para poder guardar las fichas en algun conjunto
        LogicaConjunto c = new ConjuntoGrupo(fichas);
        Conjunto conjuntoAGuardar = c.verificarColorFicha();

        this.board.actualizarDatos(conjuntoAGuardar);

    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
