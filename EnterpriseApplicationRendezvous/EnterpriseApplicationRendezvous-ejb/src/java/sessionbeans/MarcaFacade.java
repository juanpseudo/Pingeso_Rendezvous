/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Marca;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aileen
 */
@Stateless
public class MarcaFacade extends AbstractFacade<Marca> implements MarcaFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseApplicationRendezvous-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaFacade() {
        super(Marca.class);
    }
    
}
