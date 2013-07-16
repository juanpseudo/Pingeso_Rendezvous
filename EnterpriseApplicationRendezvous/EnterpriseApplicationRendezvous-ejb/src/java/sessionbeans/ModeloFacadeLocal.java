/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Modelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aileen
 */
@Local
public interface ModeloFacadeLocal {

    void create(Modelo modelo);

    void edit(Modelo modelo);

    void remove(Modelo modelo);

    Modelo find(Object id);

    List<Modelo> findAll();

    List<Modelo> findRange(int[] range);

    int count();
    
}
