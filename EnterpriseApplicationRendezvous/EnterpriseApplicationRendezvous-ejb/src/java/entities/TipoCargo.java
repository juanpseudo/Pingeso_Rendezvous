/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aileen
 */
@Entity
@Table(name = "tipo_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCargo.findAll", query = "SELECT t FROM TipoCargo t"),
    @NamedQuery(name = "TipoCargo.findByIdCargo", query = "SELECT t FROM TipoCargo t WHERE t.idCargo = :idCargo"),
    @NamedQuery(name = "TipoCargo.findByNombreCargo", query = "SELECT t FROM TipoCargo t WHERE t.nombreCargo = :nombreCargo")})
public class TipoCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARGO")
    private Integer idCargo;
    @Size(max = 50)
    @Column(name = "NOMBRE_CARGO")
    private String nombreCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargo")
    private Collection<Trabajador> trabajadorCollection;

    public TipoCargo() {
    }

    public TipoCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    @XmlTransient
    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCargo)) {
            return false;
        }
        TipoCargo other = (TipoCargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoCargo[ idCargo=" + idCargo + " ]";
    }
    
}
