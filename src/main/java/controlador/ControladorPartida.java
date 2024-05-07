package controlador;

import arqui.util.Datos;
import fuentesDeConocimiento.FCAgregarConjunto;
import fuentesDeConocimiento.FCAgregarFicha;
import fuentesDeConocimiento.FCDesmarcarConjuntos;
import fuentesDeConocimiento.FCDividirConjunto;
import fuentesDeConocimiento.FCEliminarConjunto;
import fuentesDeConocimiento.FCEliminarFichas;
import interfaces.FuenteConocimiento;
import java.util.HashMap;
import java.util.Map;
import interfaces.Observer;

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
        fuentesConocimiento.put("dividirConjunto", new FCDividirConjunto());
        fuentesConocimiento.put("eliminarConjunto", new FCEliminarConjunto());
        fuentesConocimiento.put("eliminarFichas", new FCEliminarFichas());
        fuentesConocimiento.put("desmarcarConjuntos", new FCDesmarcarConjuntos());

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
