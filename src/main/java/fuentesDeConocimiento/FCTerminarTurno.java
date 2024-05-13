/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;

import DOMINIO.Partida;
import arqui.util.Datos;
import interaces.Blackboard;
import interaces.LogicaPartida;
import interfaces.FuenteConocimiento;

/**
 *
 * @author marco
 */
public class FCTerminarTurno extends FuenteConocimiento{

    Blackboard blackboard;
    private LogicaPartida lp;
    
    @Override
    public void ejecutar(Datos d) {
        lp = Partida.obtenerInstancia();
        
        lp.terminarTurno();
        
        blackboard.actualizarDatos();
    }
    
}
