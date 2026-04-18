package monedas.api.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import monedas.api.dominio.dtos.*;
import monedas.api.dominio.entidades.*;
import monedas.api.core.servicios.*;

@RestController
@RequestMapping("/api")
public class UsuarioControlador {

    @Autowired
    private IUsuarioServicio servicio;

    @PostMapping(value = "/login")
    public UsuarioLoginDto login(@RequestBody UsuarioLoginDto usuarioLogin) {
        return servicio.login(usuarioLogin.getUsername(), usuarioLogin.getPassword());
    }

   @GetMapping(value = "/usuarios")
    public List<Usuario> listar() {
        return servicio.listar();
    }

    @GetMapping(value = "/usuarios/obtener/{id}")
    public Usuario obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/usuarios/buscar/{nombre}", method = RequestMethod.GET)
    public List<Usuario> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @PostMapping(value = "/usuarios")
    public Usuario crear(@RequestBody Usuario usuario) {
        return servicio.agregar(usuario);
    }

    @PutMapping(value = "/usuarios")
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return servicio.modificar(usuario);
    }

    @DeleteMapping(value = "/usuarios/{id}")
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

}
