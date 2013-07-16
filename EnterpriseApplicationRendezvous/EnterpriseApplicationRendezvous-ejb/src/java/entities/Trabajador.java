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
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t"),
    @NamedQuery(name = "Trabajador.findByRutTrab", query = "SELECT t FROM Trabajador t WHERE t.rutTrab = :rutTrab"),
    @NamedQuery(name = "Trabajador.findByNombreTrab", query = "SELECT t FROM Trabajador t WHERE t.nombreTrab = :nombreTrab"),
    @NamedQuery(name = "Trabajador.findByApellidoPatTrab", query = "SELECT t FROM Trabajador t WHERE t.apellidoPatTrab = :apellidoPatTrab"),
    @NamedQuery(name = "Trabajador.findByApellidoMatTrab", query = "SELECT t FROM Trabajador t WHERE t.apellidoMatTrab = :apellidoMatTrab"),
    @NamedQuery(name = "Trabajador.findByDireccionTrab", query = "SELECT t FROM Trabajador t WHERE t.direccionTrab = :direccionTrab"),
    @NamedQuery(name = "Trabajador.findByTelefonoTrab", query = "SELECT t FROM Trabajador t WHERE t.telefonoTrab = :telefonoTrab"),
    @NamedQuery(name = "Trabajador.findByCorreoTrab", query = "SELECT t FROM Trabajador t WHERE t.correoTrab = :correoTrab"),
    @NamedQuery(name = "Trabajador.findByFechaNacTrab", query = "SELECT t FROM Trabajador t WHERE t.fechaNacTrab = :fechaNacTrab")})
public class Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT_TRAB")
    private Integer rutTrab;
    @Size(max = 100)
    @Column(name = "NOMBRE_TRAB")
    private String nombreTrab;
    @Size(max = 50)
    @Column(name = "APELLIDO_PAT_TRAB")
    private String apellidoPatTrab;
    @Size(max = 50)
    @Column(name = "APELLIDO_MAT_TRAB")
    private String apellidoMatTrab;
    @Size(max = 120)
    @Column(name = "DIRECCION_TRAB")
    private String direccionTrab;
    @Column(name = "TELEFONO_TRAB")
    private Integer telefonoTrab;
    @Size(max = 150)
    @Column(name = "CORREO_TRAB")
    private String correoTrab;
    @Column(name = "FECHA_NAC_TRAB")
    @Temporal(TemporalType.DATE)
    private Date fechaNacTrab;
    @ManyToMany(mappedBy = "trabajadorCollection")
    private Collection<Camion> camionCollection;
    @JoinColumn(name = "ID_COMUNA", referencedColumnName = "ID_COMUNA")
    @ManyToOne
    private Comuna idComuna;
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private TipoCargo idCargo;

    public Trabajador() {
    }

    public Trabajador(Integer rutTrab) {
        this.rutTrab = rutTrab;
    }
        public Trabajador(Integer rutTrab, String nombreTrab, String apellidoPatTrab, String apellidoMatTrab,String direccionTrab, Integer telefonoTrab, String correoTrab) {
        this.rutTrab = rutTrab;
        this.nombreTrab = nombreTrab;
        this.apellidoPatTrab = apellidoPatTrab;
        this.apellidoMatTrab = apellidoMatTrab;
        this.direccionTrab = direccionTrab;
        this.telefonoTrab = telefonoTrab;
        this.correoTrab = correoTrab;
    }

    public Integer getRutTrab() {
        return rutTrab;
    }

    public void setRutTrab(Integer rutTrab) {
        this.rutTrab = rutTrab;
    }

    public String getNombreTrab() {
        return nombreTrab;
    }

    public void setNombreTrab(String nombreTrab) {
        this.nombreTrab = nombreTrab;
    }

    public String getApellidoPatTrab() {
        return apellidoPatTrab;
    }

    public void setApellidoPatTrab(String apellidoPatTrab) {
        this.apellidoPatTrab = apellidoPatTrab;
    }

    public String getApellidoMatTrab() {
        return apellidoMatTrab;
    }

    public void setApellidoMatTrab(String apellidoMatTrab) {
        this.apellidoMatTrab = apellidoMatTrab;
    }

    public String getDireccionTrab() {
        return direccionTrab;
    }

    public void setDireccionTrab(String direccionTrab) {
        this.direccionTrab = direccionTrab;
    }

    public Integer getTelefonoTrab() {
        return telefonoTrab;
    }

    public void setTelefonoTrab(Integer telefonoTrab) {
        this.telefonoTrab = telefonoTrab;
    }

    public String getCorreoTrab() {
        return correoTrab;
    }

    public void setCorreoTrab(String correoTrab) {
        this.correoTrab = correoTrab;
    }

    public Date getFechaNacTrab() {
        return fechaNacTrab;
    }

    public void setFechaNacTrab(Date fechaNacTrab) {
        this.fechaNacTrab = fechaNacTrab;
    }

    @XmlTransient
    public Collection<Camion> getCamionCollection() {
        return camionCollection;
    }

    public void setCamionCollection(Collection<Camion> camionCollection) {
        this.camionCollection = camionCollection;
    }

    public Comuna getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Comuna idComuna) {
        this.idComuna = idComuna;
    }

    public TipoCargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(TipoCargo idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutTrab != null ? rutTrab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.rutTrab == null && other.rutTrab != null) || (this.rutTrab != null && !this.rutTrab.equals(other.rutTrab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Trabajador[ rutTrab=" + rutTrab + " ]";
    }
    
}
