package monedas.api.aplicacion.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monedas.api.core.servicios.*;
import monedas.api.core.integracion.*;
import monedas.api.dominio.entidades.*;
import monedas.api.dominio.dtos.*;
import monedas.api.infraestructura.repositorios.*;
import monedas.api.infraestructura.integracion.*;

@Service
public class PaisServicio implements IPaisServicio {

    @Autowired
    private IPaisRepositorio repositorio;

    @Autowired
    private IPaisServicioExterno integracion;

    @Override
    public List<Pais> listar() {
        return repositorio.findAll();
    }

    @Override
    public Pais obtener(int id) {
        var pais = repositorio.findById(id);
        return pais.isEmpty() ? null : pais.get();
    }

    @Override
    public List<Pais> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Pais agregar(Pais pais) {
        pais.setId(0);
        return repositorio.save(pais);
    }

    @Override
    public Pais modificar(Pais pais) {
        Optional<Pais> paisEncontrado = repositorio.findById(pais.getId());
        if (!paisEncontrado.isEmpty()) {
            return repositorio.save(pais);
        } else {
            return null;
        }
    }

    public boolean eliminar(int id) {
        try {
            var paisEncontrado = repositorio.findById(id);
            if (paisEncontrado.isEmpty()) {
                return false;
            }
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public CapitalDto getCapital(String nombre) {
        return integracion.getCapital(nombre);
    }

}
