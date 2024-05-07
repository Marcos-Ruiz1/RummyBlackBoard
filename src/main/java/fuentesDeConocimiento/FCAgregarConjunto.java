/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Conjunto;
import arqui.util.Datos;
import interfaces.FuenteConocimiento;
import java.util.List;

/**
 *
 * @author natsu
 */
public class FCAgregarConjunto extends FuenteConocimiento {

    @Override
    public void ejecutar(Datos d) {

        List<Conjunto> conjuntos = (List<Conjunto>) d.getDatos();

        for (Conjunto c : conjuntos) {

            System.out.println(c.toString());

        }

    }

}
