/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Camion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aileen
 */
@Local
public interface CamionFacadeLocal {

    void create(Camion camion);

    void edit(Camion camion);

    void remove(Camion camion);

    Camion find(Object id);

    List<Camion> findAll();

    List<Camion> findRange(int[] range);

    int count();
    
}
