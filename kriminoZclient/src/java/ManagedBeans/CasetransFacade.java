/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import dbase.Casetrans;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class CasetransFacade extends AbstractFacade<Casetrans> {
    @PersistenceContext(unitName = "kriminoZclientPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasetransFacade() {
        super(Casetrans.class);
    }
    
}
