/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Modelo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aileen
 */
@Stateless
public class ModeloFacade extends AbstractFacade<Modelo> implements ModeloFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseApplicationRendezvous-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloFacade() {
        super(Modelo.class);
    }
    
}
