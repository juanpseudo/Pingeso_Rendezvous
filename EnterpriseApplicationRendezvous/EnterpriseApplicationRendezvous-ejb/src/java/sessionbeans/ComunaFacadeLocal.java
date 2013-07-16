/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Comuna;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aileen
 */
@Local
public interface ComunaFacadeLocal {

    void create(Comuna comuna);

    void edit(Comuna comuna);

    void remove(Comuna comuna);

    Comuna find(Object id);

    List<Comuna> findAll();

    List<Comuna> findRange(int[] range);

    int count();
    
}
