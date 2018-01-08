/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author shadl
 */
@Named(value = "userBean")
@SessionScoped
public class UsersBean implements Serializable
{
    private Integer id;
    private String emailAddress;
    private String userPassword;

    public UsersBean(Integer id, String emailAddress, String userPassword)
    {
        this.id = id;
        this.emailAddress = emailAddress;
        this.userPassword = userPassword;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
    
    
}
