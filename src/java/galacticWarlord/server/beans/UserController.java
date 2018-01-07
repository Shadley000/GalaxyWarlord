/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.beans;

import galacticWarlord.server.entity.Users;
import galacticWarlord.server.jpaejb.UsersFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "userController")

@SessionScoped
public class UserController implements Serializable
{

    @EJB
    UsersFacade usersFacade;

    @Inject
    UsersBean usersBean;

    public List<Users> getAll()
    {
        return usersFacade.findAll();
    }

    public int count()
    {
        return usersFacade.count();
    }

    public String delete(Users u)
    {
        usersFacade.remove(u);
        return null;

    }

    public String add()
    {
        Users u = new Users();
        u.setId(0);
        u.setEmailAddress("test");
        u.setUserPassword("password");
        usersFacade.create(u);
        return "index";
    }

    public String edit(Users u)
    {
        usersBean.setId(u.getId());
        usersBean.setEmailAddress(u.getEmailAddress());
        usersBean.setUserPassword(u.getUserPassword());

        return "update";

    }

    public String save()
    {
        Users u = new Users(usersBean.getId());
        u.setEmailAddress(usersBean.getEmailAddress());
        u.setUserPassword(usersBean.getUserPassword());

        usersFacade.edit(u);
        return "index";
    }
}
