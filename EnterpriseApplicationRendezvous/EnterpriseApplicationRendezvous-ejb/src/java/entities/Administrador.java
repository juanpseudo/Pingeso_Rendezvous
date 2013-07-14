/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juand_000
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByRutAdm", query = "SELECT a FROM Administrador a WHERE a.rutAdm = :rutAdm"),
    @NamedQuery(name = "Administrador.findByNombreAdm", query = "SELECT a FROM Administrador a WHERE a.nombreAdm = :nombreAdm"),
    @NamedQuery(name = "Administrador.findByApellidoPatAdm", query = "SELECT a FROM Administrador a WHERE a.apellidoPatAdm = :apellidoPatAdm"),
    @NamedQuery(name = "Administrador.findByApellidoMatAdm", query = "SELECT a FROM Administrador a WHERE a.apellidoMatAdm = :apellidoMatAdm"),
    @NamedQuery(name = "Administrador.findByDireccionAdm", query = "SELECT a FROM Administrador a WHERE a.direccionAdm = :direccionAdm"),
    @NamedQuery(name = "Administrador.findByTelefonoAdm", query = "SELECT a FROM Administrador a WHERE a.telefonoAdm = :telefonoAdm"),
    @NamedQuery(name = "Administrador.findByCorreoAdm", query = "SELECT a FROM Administrador a WHERE a.correoAdm = :correoAdm"),
    @NamedQuery(name = "Administrador.findByFechaNacAdm", query = "SELECT a FROM Administrador a WHERE a.fechaNacAdm = :fechaNacAdm")})
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT_ADM")
    private Integer rutAdm;
    @Size(max = 100)
    @Column(name = "NOMBRE_ADM")
    private String nombreAdm;
    @Size(max = 50)
    @Column(name = "APELLIDO_PAT_ADM")
    private String apellidoPatAdm;
    @Size(max = 50)
    @Column(name = "APELLIDO_MAT_ADM")
    private String apellidoMatAdm;
    @Size(max = 120)
    @Column(name = "DIRECCION_ADM")
    private String direccionAdm;
    @Column(name = "TELEFONO_ADM")
    private Integer telefonoAdm;
    @Size(max = 150)
    @Column(name = "CORREO_ADM")
    private String correoAdm;
    @Column(name = "FECHA_NAC_ADM")
    @Temporal(TemporalType.DATE)
    private Date fechaNacAdm;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne
    private Usuario username;

    public Administrador() {
    }

    public Administrador(Integer rutAdm) {
        this.rutAdm = rutAdm;
    }

    public Integer getRutAdm() {
        return rutAdm;
    }

    public void setRutAdm(Integer rutAdm) {
        this.rutAdm = rutAdm;
    }

    public String getNombreAdm() {
        return nombreAdm;
    }

    public void setNombreAdm(String nombreAdm) {
        this.nombreAdm = nombreAdm;
    }

    public String getApellidoPatAdm() {
        return apellidoPatAdm;
    }

    public void setApellidoPatAdm(String apellidoPatAdm) {
        this.apellidoPatAdm = apellidoPatAdm;
    }

    public String getApellidoMatAdm() {
        return apellidoMatAdm;
    }

    public void setApellidoMatAdm(String apellidoMatAdm) {
        this.apellidoMatAdm = apellidoMatAdm;
    }

    public String getDireccionAdm() {
        return direccionAdm;
    }

    public void setDireccionAdm(String direccionAdm) {
        this.direccionAdm = direccionAdm;
    }

    public Integer getTelefonoAdm() {
        return telefonoAdm;
    }

    public void setTelefonoAdm(Integer telefonoAdm) {
        this.telefonoAdm = telefonoAdm;
    }

    public String getCorreoAdm() {
        return correoAdm;
    }

    public void setCorreoAdm(String correoAdm) {
        this.correoAdm = correoAdm;
    }

    public Date getFechaNacAdm() {
        return fechaNacAdm;
    }

    public void setFechaNacAdm(Date fechaNacAdm) {
        this.fechaNacAdm = fechaNacAdm;
    }

    public Usuario getUsername() {
        return username;
    }

    public void setUsername(Usuario username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutAdm != null ? rutAdm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.rutAdm == null && other.rutAdm != null) || (this.rutAdm != null && !this.rutAdm.equals(other.rutAdm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Administrador[ rutAdm=" + rutAdm + " ]";
    }
    
}
