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
import interaces.PartidaDTO;
import interfaces.FuenteConocimiento;
import interaces.Observador;
import java.util.HashMap;
import java.util.Map;
import util.ProxyServer;

/**
 *
 * @author Dios todo poderoso
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
        fuentesConocimiento.put("dividirConjunto", new FCDividirConjunto());
        fuentesConocimiento.put("eliminarConjunto", new FCEliminarConjunto());
        fuentesConocimiento.put("eliminarFichas", new FCEliminarFichas());
        fuentesConocimiento.put("desmarcarConjuntos", new FCDesmarcarConjuntos());
        fuentesConocimiento.put("guardarPartida", new FCGuardarPartida());
        fuentesConocimiento.put("restaurarPartida", new FCRestaurarPartida());
        fuentesConocimiento.put("TerminarPartida", new FCTerminarPartida());
        fuentesConocimiento.put("TerminarTurno", new FCTerminarTurno());

    }

    public void agregarSinConjunto(Datos datos) {
        this.tmpDatos = datos;
        fuentesConocimiento.get("agregarConjunto").ejecutar(datos);
    }

    public void agregarConConjunto(Datos datos) {
        this.tmpDatos = datos;
        fuentesConocimiento.get("agregarFicha").ejecutar(datos);
    }

    public void desmarcarConjuntos() {
        fuentesConocimiento.get("desmarcarConjuntos").ejecutar();
    }

    public void restuararPartida() {
        fuentesConocimiento.get("restaurarPartida").ejecutar();
    }

    public void dividirConjunto(Datos datos) {
        this.tmpDatos = datos;
        fuentesConocimiento.get("dividirConjunto").ejecutar(datos);
    }

    public static ControladorPartida obtenerInstancia() {
        if (ControladorPartida.instancia == null) {
            ControladorPartida.instancia = new ControladorPartida();
            //        Suscribir al publicar 
            Partida.obtenerPublicador().agregarObservador(ControladorPartida.instancia);
        }

        return ControladorPartida.instancia;
    }

    @Override
    public void notificar(Blackboard blackboard) {

        String mensaje = blackboard.obtenerMensaje();

        switch (mensaje) {
            case "Eliminar fichas" ->
                fuentesConocimiento.get("eliminarFichas").ejecutar(this.tmpDatos);
            case "Eliminar conjunto" ->
                fuentesConocimiento.get("eliminarConjunto").ejecutar(this.tmpDatos);
            case "Agregar conjunto" ->
                fuentesConocimiento.get("eliminarFichas").ejecutar(this.tmpDatos);
            case "guardarPartida" ->
                fuentesConocimiento.get("guardarPartida").ejecutar();
            case "terminarPartida" -> {
                PartidaDTO pdto;
                pdto = (PartidaDTO) Partida.obtenerInstancia();
                Jugador jugador = pdto.obtenerJugador();
                
                 if(jugador.tieneFichas()){
                    fuentesConocimiento.get("TerminarTurno").ejecutar();
                }else{
                    fuentesConocimiento.get("TerminarTurno").ejecutar();
                }
            }

            default ->
                ProxyServer.enviarDatos(Partida.obtenerInstancia());

        }

    }

}
