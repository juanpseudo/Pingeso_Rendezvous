/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Trabajador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juand_000
 */
@Local
public interface TrabajadorFacadeLocal {

    void create(Trabajador trabajador);

    void edit(Trabajador trabajador);

    void remove(Trabajador trabajador);

    Trabajador find(Object id);

    List<Trabajador> findAll();

    List<Trabajador> findRange(int[] range);

    int count();
    
}
