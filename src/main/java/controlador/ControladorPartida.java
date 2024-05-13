package controlador;

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
import interfaces.FuenteConocimiento;
import java.util.HashMap;
import java.util.Map;
import interaces.Observer;

/**
 *
 * @author
 */
public class ControladorPartida implements Observer {

    private final Map<String, FuenteConocimiento> fuentesConocimiento;

    private static ControladorPartida instancia;

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

    }

    public void agregarSinConjunto(Datos datos) {
        fuentesConocimiento.get("agregarConjunto").ejecutar(datos);
    }

    public static ControladorPartida obtenerInstancia() {
        if (ControladorPartida.instancia == null) {
            ControladorPartida.instancia = new ControladorPartida();
        }

        return ControladorPartida.instancia;
    }

    @Override
    public void notificar() {
  
    }

}
