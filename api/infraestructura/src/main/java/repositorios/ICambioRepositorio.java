package monedas.api.infraestructura.repositorios;

import java.util.List;
import java.time.LocalDate;

import monedas.api.dominio.entidades.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICambioRepositorio extends JpaRepository<Cambio, Integer>{

    @Query("SELECT c FROM Cambio c  WHERE c.moneda.id=?1 AND c.fecha >= ?2 AND c.fecha <= ?3")
    public List<Cambio> listarPorPeriodo(int idMoneda, LocalDate fecha1, LocalDate fecha2);

    @Query("SELECT c FROM Cambio c  WHERE c.moneda.id=?1 ORDER BY c.fecha DESC")
    public List<Cambio> listarPorMoneda(int idMoneda);

}
