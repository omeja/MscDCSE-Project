/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import dbase.Income;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class IncomeFacade extends AbstractFacade<Income> {
    @PersistenceContext(unitName = "kriminoZclientPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncomeFacade() {
        super(Income.class);
    }
    
}
