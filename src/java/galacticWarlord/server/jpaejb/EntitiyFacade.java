/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.jpaejb;

import galacticWarlord.server.entity.Entitiy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shadl
 */
@Stateless
public class EntitiyFacade extends AbstractFacade<Entitiy>
{

    @PersistenceContext(unitName = "GalacticWarlordPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public EntitiyFacade()
    {
        super(Entitiy.class);
    }
    
}