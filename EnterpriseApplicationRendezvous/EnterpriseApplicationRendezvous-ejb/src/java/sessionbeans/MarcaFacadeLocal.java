/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Marca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aileen
 */
@Local
public interface MarcaFacadeLocal {

    void create(Marca marca);

    void edit(Marca marca);

    void remove(Marca marca);

    Marca find(Object id);

    List<Marca> findAll();

    List<Marca> findRange(int[] range);

    int count();
    
}
