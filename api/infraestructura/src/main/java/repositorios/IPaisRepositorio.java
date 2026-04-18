package monedas.api.infraestructura.repositorios;

import java.util.List;

import monedas.api.dominio.entidades.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisRepositorio extends JpaRepository<Pais, Integer> {

    @Query("SELECT p FROM Pais p WHERE p.nombre LIKE '%' || ?1 || '%'")
    List<Pais> buscar(String nombre);

}