package monedas.api.aplicacion.servicios;

import java.util.Optional;
import java.util.List;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import monedas.api.core.servicios.*;
import monedas.api.dominio.entidades.*;
import monedas.api.infraestructura.repositorios.*;


@Service
public class MonedaServicio implements IMonedaServicio {

    @Autowired
    private IMonedaRepositorio repositorio;

    @Autowired
    private ICambioRepositorio repositorioCambio;

    public List<Moneda> listar() {
        return repositorio.findAll();
    }

    public Moneda obtener(int id) {
        var moneda = repositorio.findById(id);
        return moneda.isEmpty() ? null : moneda.get();
    }

    public List<Moneda> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    public Moneda buscarPorPais(String nombre) {
        return repositorio.buscarPorPais(nombre);
    }

    public Moneda agregar(Moneda moneda) {
        moneda.setId(0);
        return repositorio.save(moneda);
    }

    public Moneda modificar(Moneda moneda) {
        var monedaEncontrada = repositorio.findById(moneda.getId());
        return monedaEncontrada.isEmpty() ? null : repositorio.save(moneda);
    }

    public boolean eliminar(int id) {
        try {
            var monedaEncontrada = repositorio.findById(id);
            if (monedaEncontrada.isEmpty()) {
                return false;
            }
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

     //********** Cambios  

    public Cambio agregarCambio(Cambio cambio){
        cambio.setId(0);
        return repositorioCambio.save(cambio);
    }

    public Cambio modificarCambio(Cambio cambio){
        var cambioEncontrado = repositorioCambio.findById(cambio.getId());
        return cambioEncontrado.isEmpty() ? null : repositorioCambio.save(cambio);
    }

    public boolean eliminarCambio(int id){
        try {
            var cambioEncontrado = repositorioCambio.findById(id);
            if (cambioEncontrado.isEmpty()) {
                return false;
            }
            repositorioCambio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<Cambio> listarPorMoneda(int idMoneda) {
        return repositorioCambio.listarPorMoneda(idMoneda);
    }

    public List<Cambio> listarPorPeriodo(int idMoneda, LocalDate fecha1, LocalDate fecha2) {
        return repositorioCambio.listarPorPeriodo(idMoneda, fecha1, fecha2);
    }

}
