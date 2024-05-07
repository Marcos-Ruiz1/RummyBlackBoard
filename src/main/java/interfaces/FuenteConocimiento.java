/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DOMINIO.Partida;
import interaces.Blackboard;

/**
 *
 * @author marco
 */
public abstract class FuenteConocimiento {

    protected Blackboard board;

    public FuenteConocimiento() {
        this.board = Partida.obtenerInstancia();
    }

    public abstract void ejecutar();
}
