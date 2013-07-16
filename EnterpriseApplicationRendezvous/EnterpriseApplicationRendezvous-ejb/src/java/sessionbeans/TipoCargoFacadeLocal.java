/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.TipoCargo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aileen
 */
@Local
public interface TipoCargoFacadeLocal {

    void create(TipoCargo tipoCargo);

    void edit(TipoCargo tipoCargo);

    void remove(TipoCargo tipoCargo);

    TipoCargo find(Object id);

    List<TipoCargo> findAll();

    List<TipoCargo> findRange(int[] range);

    int count();
    
}
