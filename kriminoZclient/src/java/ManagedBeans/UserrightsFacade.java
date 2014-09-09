/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import dbase.Userrights;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class UserrightsFacade extends AbstractFacade<Userrights> {
    @PersistenceContext(unitName = "kriminoZclientPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserrightsFacade() {
        super(Userrights.class);
    }
    
}
