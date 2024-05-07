/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuentesDeConocimiento;
import DOMINIO.Conjunto;
import DOMINIO.Tablero;
import DOMINIO.ConjuntoGrupo;
import DOMINIO.ConjuntoSecuencia;
import DOMINIO.Jugador;
import interaces.LogicaTablero;
import interaces.LogicaConjunto;
import interaces.LogicaJugador;
import interaces.Blackboard;
/**
 *
 * @author marco
 */
public class FCDesmarcarConjuntos implements FuenteConocimiento{

    private LogicaTablero lt;
    private LogicaConjunto lc;
    private LogicaJugador lj;
    Blackboard blackboard;
    
    @Override
    public void ejecutar() {
        lt = Tablero.obtenerInstancia();
        lj = new Jugador();
        
        //Validar conjuntos
        lt.validarConjuntos();
        
        //Validar 30 puntos si es el primer turno del jugador
        if(lj.esPrimerTurno()){
           lc.validar30Puntos();
        }
        
        //Desmarcar los conjuntos
        
        
        lt.desmarcarConjuntos();
        
        //Actualizar el blackboard
        blackboard.actualizarDatos(lt);
    }
    
}
