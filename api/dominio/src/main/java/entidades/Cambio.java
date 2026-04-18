package monedas.api.dominio.entidades;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cambiomoneda")
public class Cambio {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_cambio")
    @SequenceGenerator(name = "secuencia_cambio", sequenceName = "secuencia_cambio", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idmoneda", referencedColumnName = "id")
    private Moneda moneda;

    @Column(name = "cambio")
    private double valor;

    @Column(name = "fecha")
    private Date fecha;

    public Cambio() {
    }

    public Cambio(int id, Moneda moneda, double valor, Date fecha) {
        this.id = id;
        this.moneda = moneda;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

}
