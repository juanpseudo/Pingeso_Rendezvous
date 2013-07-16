/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aileen
 */
@Entity
@Table(name = "camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c"),
    @NamedQuery(name = "Camion.findByPatente", query = "SELECT c FROM Camion c WHERE c.patente = :patente"),
    @NamedQuery(name = "Camion.findByCapacidad", query = "SELECT c FROM Camion c WHERE c.capacidad = :capacidad"),
    @NamedQuery(name = "Camion.findByNombre", query = "SELECT c FROM Camion c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Camion.findByFecha", query = "SELECT c FROM Camion c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Camion.findByDisponibilidad", query = "SELECT c FROM Camion c WHERE c.disponibilidad = :disponibilidad"),
    @NamedQuery(name = "Camion.findByDescripcion", query = "SELECT c FROM Camion c WHERE c.descripcion = :descripcion")})
public class Camion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PATENTE")
    private String patente;
    @Column(name = "CAPACIDAD")
    private Integer capacidad;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "DISPONIBILIDAD")
    private Boolean disponibilidad;
    @Size(max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinTable(name = "asignar_camion", joinColumns = {
        @JoinColumn(name = "PATENTE", referencedColumnName = "PATENTE")}, inverseJoinColumns = {
        @JoinColumn(name = "RUT_TRAB", referencedColumnName = "RUT_TRAB")})
    @ManyToMany
    private Collection<Trabajador> trabajadorCollection;
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    @ManyToOne
    private Modelo idModelo;

    public Camion() {
    }

    public Camion(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patente != null ? patente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.patente == null && other.patente != null) || (this.patente != null && !this.patente.equals(other.patente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Camion[ patente=" + patente + " ]";
    }
    
}
