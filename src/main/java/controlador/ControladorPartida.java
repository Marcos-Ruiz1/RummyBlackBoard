package controlador;

import DOMINIO.Jugador;
import DOMINIO.Partida;
import arqui.util.Datos;
import fuentesDeConocimiento.FCAgregarConjunto;
import fuentesDeConocimiento.FCAgregarFicha;
import fuentesDeConocimiento.FCDesmarcarConjuntos;
import fuentesDeConocimiento.FCDividirConjunto;
import fuentesDeConocimiento.FCEliminarConjunto;
import fuentesDeConocimiento.FCEliminarFichas;
import fuentesDeConocimiento.FCGuardarPartida;
import fuentesDeConocimiento.FCRestaurarPartida;
import fuentesDeConocimiento.FCTerminarPartida;
import fuentesDeConocimiento.FCTerminarTurno;
import interaces.Blackboard;
import interaces.Observador;
import interaces.PartidaDTO;
import interfaces.FuenteConocimiento;
import java.util.HashMap;
import java.util.Map;
import util.ProxyServer;

/**
 *
 * @author
 */
public class ControladorPartida implements Observador {
    
    private final Map<String, FuenteConocimiento> fuentesConocimiento;
    
    private static ControladorPartida instancia;
    
    private Datos tmpDatos;
    
    private ControladorPartida() {
        fuentesConocimiento = new HashMap();

        //        Para agregar las fuentes de conocimiento que utilizara el controlador 
        fuentesConocimiento.put("agregarConjunto", new FCAgregarConjunto());
        fuentesConocimiento.put("agregarFicha", new FCAgregarFicha());
        fuentesConocimiento.put("dividirCongregarFicha\"junto", new FCDividirConjunto());
        fuentesConocimiento.put("eliminarConjunto", new FCEliminarConjunto());
        fuentesConocimiento.put("eliminarFichas", new FCEliminarFichas());
        fuentesConocimiento.put("desmarcarConjuntos", new FCDesmarcarConjuntos());
        fuentesConocimiento.put("guardarPartida", new FCGuardarPartida());
        fuentesConocimiento.put("restaurarPartida", new FCRestaurarPartida());
        fuentesConocimiento.put("TerminarPartida", new FCTerminarPartida());
        fuentesConocimiento.put("TerminarTurno", new FCTerminarTurno());

        //        Suscribir al publicar 
        Partida.obtenerPublicador().agregarObservador(instancia);
    }
    
    public void agregarSinConjunto(Datos datos) {
        this.tmpDatos = datos;
        fuentesConocimiento.get("agregarConjunto").ejecutar(datos);
    }
    
    public void agregarConConjunto(Datos datos) {
        this.tmpDatos = datos;
        fuentesConocimiento.get("agregarFicha").ejecutar(datos);
    }
    
    public static ControladorPartida obtenerInstancia() {
        if (ControladorPartida.instancia == null) {
            ControladorPartida.instancia = new ControladorPartida();
        }
        
        return ControladorPartida.instancia;
    }
    
    @Override
    public void notificar(Blackboard blackboard) {
       
        String mensaje = blackboard.obtenerMensaje();
        
        switch (mensaje) {
            case "Agregar conjunto" ->
                fuentesConocimiento.get("eliminarFichas").ejecutar(this.tmpDatos);
            case "guardarPartida" ->
                fuentesConocimiento.get("guardarPartida").ejecutar();
            case "terminarTurno" ->{
                PartidaDTO pdto;
                pdto = (PartidaDTO) Partida.obtenerInstancia();
                Jugador jugador = pdto.obtenerJugador();
                
                if(jugador.tieneFichas()){
                    fuentesConocimiento.get("terminarPartida").ejecutar();
                }else{
                    fuentesConocimiento.get("terminarTurno").ejecutar();
                }
            }
                
            default ->
                ProxyServer.enviarDatos(Partida.obtenerInstancia());
             
            
        }
        
    }
    
}
