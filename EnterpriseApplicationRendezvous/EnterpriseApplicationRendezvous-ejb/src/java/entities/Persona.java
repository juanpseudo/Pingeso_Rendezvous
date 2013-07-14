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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juand_000
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPer", query = "SELECT p FROM Persona p WHERE p.idPer = :idPer"),
    @NamedQuery(name = "Persona.findByNombrePer", query = "SELECT p FROM Persona p WHERE p.nombrePer = :nombrePer"),
    @NamedQuery(name = "Persona.findByApellidoPatPer", query = "SELECT p FROM Persona p WHERE p.apellidoPatPer = :apellidoPatPer"),
    @NamedQuery(name = "Persona.findByApellidoMatPer", query = "SELECT p FROM Persona p WHERE p.apellidoMatPer = :apellidoMatPer"),
    @NamedQuery(name = "Persona.findByDireccionPer", query = "SELECT p FROM Persona p WHERE p.direccionPer = :direccionPer"),
    @NamedQuery(name = "Persona.findByTelefonoPer", query = "SELECT p FROM Persona p WHERE p.telefonoPer = :telefonoPer"),
    @NamedQuery(name = "Persona.findByCorreoPer", query = "SELECT p FROM Persona p WHERE p.correoPer = :correoPer"),
    @NamedQuery(name = "Persona.findByFechaNacPer", query = "SELECT p FROM Persona p WHERE p.fechaNacPer = :fechaNacPer")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PER")
    private Integer idPer;
    @Size(max = 100)
    @Column(name = "NOMBRE_PER")
    private String nombrePer;
    @Size(max = 50)
    @Column(name = "APELLIDO_PAT_PER")
    private String apellidoPatPer;
    @Size(max = 50)
    @Column(name = "APELLIDO_MAT_PER")
    private String apellidoMatPer;
    @Size(max = 120)
    @Column(name = "DIRECCION_PER")
    private String direccionPer;
    @Column(name = "TELEFONO_PER")
    private Integer telefonoPer;
    @Size(max = 150)
    @Column(name = "CORREO_PER")
    private String correoPer;
    @Column(name = "FECHA_NAC_PER")
    @Temporal(TemporalType.DATE)
    private Date fechaNacPer;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne
    private Usuario username;
    @OneToMany(mappedBy = "idPer")
    private Collection<Solicitud> solicitudCollection;

    public Persona() {
    }

    public Persona(Integer idPer) {
        this.idPer = idPer;
    }

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
    }

    public String getNombrePer() {
        return nombrePer;
    }

    public void setNombrePer(String nombrePer) {
        this.nombrePer = nombrePer;
    }

    public String getApellidoPatPer() {
        return apellidoPatPer;
    }

    public void setApellidoPatPer(String apellidoPatPer) {
        this.apellidoPatPer = apellidoPatPer;
    }

    public String getApellidoMatPer() {
        return apellidoMatPer;
    }

    public void setApellidoMatPer(String apellidoMatPer) {
        this.apellidoMatPer = apellidoMatPer;
    }

    public String getDireccionPer() {
        return direccionPer;
    }

    public void setDireccionPer(String direccionPer) {
        this.direccionPer = direccionPer;
    }

    public Integer getTelefonoPer() {
        return telefonoPer;
    }

    public void setTelefonoPer(Integer telefonoPer) {
        this.telefonoPer = telefonoPer;
    }

    public String getCorreoPer() {
        return correoPer;
    }

    public void setCorreoPer(String correoPer) {
        this.correoPer = correoPer;
    }

    public Date getFechaNacPer() {
        return fechaNacPer;
    }

    public void setFechaNacPer(Date fechaNacPer) {
        this.fechaNacPer = fechaNacPer;
    }

    public Usuario getUsername() {
        return username;
    }

    public void setUsername(Usuario username) {
        this.username = username;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPer != null ? idPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPer == null && other.idPer != null) || (this.idPer != null && !this.idPer.equals(other.idPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Persona[ idPer=" + idPer + " ]";
    }
    
}
