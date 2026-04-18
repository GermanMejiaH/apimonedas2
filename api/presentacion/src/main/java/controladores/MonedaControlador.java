package monedas.api.presentacion.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import monedas.api.core.servicios.*;
import monedas.api.dominio.entidades.*;
import monedas.api.dominio.dtos.*;

@RestController
@RequestMapping("/api/monedas")
public class MonedaControlador {

    @Autowired
    private IMonedaServicio servicio;

    @GetMapping(value = "/listar")
    public List<Moneda> listar() {
        return servicio.listar();
    }

    @GetMapping(value = "/obtener/{id}")
    public Moneda obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @GetMapping(value = "/buscar/{nombre}")
    public List<Moneda> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @GetMapping(value = "/buscarporpais/{nombre}")
    public Moneda buscarPorPais(@PathVariable String nombre) {
        return servicio.buscarPorPais(nombre);
    }

    @PostMapping(value = "/agregar")
    public Moneda agregar(@RequestBody Moneda moneda) {
        return servicio.agregar(moneda);
    }

    @PutMapping(value = "/modificar")
    public Moneda modificar(@RequestBody Moneda moneda) {
        return servicio.modificar(moneda);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

    @PostMapping(value = "/listarporperiodo")
    public List<Cambio> listarPorPeriodo(@RequestBody PeriodoDto periodo) {
        System.out.println(
                "periodo=" + periodo.getDesde() + " " + periodo.getHasta() + " idmoneda=" + periodo.getIdMoneda());

        return servicio.listarPorPeriodo(periodo.getIdMoneda(), periodo.getDesde(), periodo.getHasta());
    }

    // ********** Cambios
    @PostMapping(value = "/cambio")
    public Cambio agregarCambio(@RequestBody Cambio cambio) {
        return servicio.agregarCambio(cambio);
    }

    @PutMapping(value = "/cambio")
    public Cambio modificarCambio(@RequestBody Cambio cambio) {
        return servicio.modificarCambio(cambio);
    }

    @DeleteMapping(value = "/cambio/{id}")
    public boolean eliminarCambio(@PathVariable int id) {
        return servicio.eliminarCambio(id);
    }

    @GetMapping(value = "/cambios/{idmoneda}")
    public List<Cambio> listarPorMoneda(@PathVariable int idmoneda) {
        return servicio.listarPorMoneda(idmoneda);
    }

}
