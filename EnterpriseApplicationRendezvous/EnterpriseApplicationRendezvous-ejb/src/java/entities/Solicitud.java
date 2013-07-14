/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juand_000
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdSol", query = "SELECT s FROM Solicitud s WHERE s.idSol = :idSol"),
    @NamedQuery(name = "Solicitud.findByCantidadSol", query = "SELECT s FROM Solicitud s WHERE s.cantidadSol = :cantidadSol"),
    @NamedQuery(name = "Solicitud.findByEstadoSol", query = "SELECT s FROM Solicitud s WHERE s.estadoSol = :estadoSol")})
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOL")
    private Integer idSol;
    @Column(name = "CANTIDAD_SOL")
    private Integer cantidadSol;
    @Column(name = "ESTADO_SOL")
    private Boolean estadoSol;
    @ManyToMany(mappedBy = "solicitudCollection")
    private Collection<Dia> diaCollection;
    @JoinColumn(name = "ID_PER", referencedColumnName = "ID_PER")
    @ManyToOne
    private Persona idPer;

    public Solicitud() {
    }

    public Solicitud(Integer idSol) {
        this.idSol = idSol;
    }

    public Integer getIdSol() {
        return idSol;
    }

    public void setIdSol(Integer idSol) {
        this.idSol = idSol;
    }

    public Integer getCantidadSol() {
        return cantidadSol;
    }

    public void setCantidadSol(Integer cantidadSol) {
        this.cantidadSol = cantidadSol;
    }

    public Boolean getEstadoSol() {
        return estadoSol;
    }

    public void setEstadoSol(Boolean estadoSol) {
        this.estadoSol = estadoSol;
    }

    @XmlTransient
    public Collection<Dia> getDiaCollection() {
        return diaCollection;
    }

    public void setDiaCollection(Collection<Dia> diaCollection) {
        this.diaCollection = diaCollection;
    }

    public Persona getIdPer() {
        return idPer;
    }

    public void setIdPer(Persona idPer) {
        this.idPer = idPer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSol != null ? idSol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSol == null && other.idSol != null) || (this.idSol != null && !this.idSol.equals(other.idSol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Solicitud[ idSol=" + idSol + " ]";
    }
    
}
