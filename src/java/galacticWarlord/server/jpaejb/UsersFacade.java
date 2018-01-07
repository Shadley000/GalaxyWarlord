/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.jpaejb;

import galacticWarlord.server.entity.Users;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shadl
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users>
{

    @PersistenceContext(unitName = "GalacticWarlordPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public UsersFacade()
    {
        super(Users.class);
    }

    public void save(int id,String emailAddress, String password)
    {
        try
        {
            Users mUsers = new Users(id,emailAddress,password);
            System.out.println("user created");
            em.persist(mUsers);
            System.out.println("user saved");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new EJBException(e.getMessage());
        }
    }
}
