/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;


import entities.TipoCargo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.TipoCargoFacadeLocal;

/**
 *
 * @author juand_000
 */
@Named(value = "managedBeanCargo")
@RequestScoped
public class ManagedBeanCargo {
    @EJB
    private TipoCargoFacadeLocal tipoCargoFacade;

    private String nombreCargo;
    private List<TipoCargo> tipoCargos;
    public ManagedBeanCargo() {
    }
    @PostConstruct
    public void init(){
        tipoCargos = tipoCargoFacade.findAll();
    }
    
    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public List<TipoCargo> getTipoCargos() {
        return tipoCargos;
    }

    public void setTipoCargos(List<TipoCargo> tipoCargos) {
        this.tipoCargos = tipoCargos;
    }
    
}
