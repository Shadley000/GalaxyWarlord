/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.jpaejb;

import galacticWarlord.server.entity.SolarSystem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shadl
 */
@Stateless
public class SolarSystemFacade extends AbstractFacade<SolarSystem>
{

    @PersistenceContext(unitName = "GalacticWarlordPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public SolarSystemFacade()
    {
        super(SolarSystem.class);
    }
    
}
