/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Comuna;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.ComunaFacadeLocal;

/**
 *
 * @author juand_000
 */
@Named(value = "managedBeanComuna")
@RequestScoped
public class ManagedBeanComuna {
    @EJB
    private ComunaFacadeLocal comunaFacade;


    private String nombreComuna;
    private List<Comuna> comunas; 
    public ManagedBeanComuna() {
    }
    
    @PostConstruct
    public void init(){
        comunas= comunaFacade.findAll();
    }
    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public List<Comuna> getComunas() {
        return comunas;
    }

    public void setComunas(List<Comuna> comunas) {
        this.comunas = comunas;
    }


    
}
