/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.jpaejb;

import galacticWarlord.server.entity.HullType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shadl
 */
@Stateless
public class HullTypeFacade extends AbstractFacade<HullType>
{

    @PersistenceContext(unitName = "GalacticWarlordPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public HullTypeFacade()
    {
        super(HullType.class);
    }
    
}
