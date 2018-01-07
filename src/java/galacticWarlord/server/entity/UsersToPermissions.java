/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "users_to_permissions")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "UsersToPermissions.findAll", query = "SELECT u FROM UsersToPermissions u")
    , @NamedQuery(name = "UsersToPermissions.findById", query = "SELECT u FROM UsersToPermissions u WHERE u.id = :id")
})
public class UsersToPermissions implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Users userId;
    @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Permissions permissionId;

    public UsersToPermissions()
    {
    }

    public UsersToPermissions(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Users getUserId()
    {
        return userId;
    }

    public void setUserId(Users userId)
    {
        this.userId = userId;
    }

    public Permissions getPermissionId()
    {
        return permissionId;
    }

    public void setPermissionId(Permissions permissionId)
    {
        this.permissionId = permissionId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersToPermissions))
        {
            return false;
        }
        UsersToPermissions other = (UsersToPermissions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.UsersToPermissions[ id=" + id + " ]";
    }
    
}
