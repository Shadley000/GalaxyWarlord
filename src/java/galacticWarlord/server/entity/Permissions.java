/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shadl
 */
@Entity
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Permissions.findAll", query = "SELECT p FROM Permissions p")
    , @NamedQuery(name = "Permissions.findById", query = "SELECT p FROM Permissions p WHERE p.id = :id")
    , @NamedQuery(name = "Permissions.findByNname", query = "SELECT p FROM Permissions p WHERE p.nname = :nname")
    , @NamedQuery(name = "Permissions.findByDescription", query = "SELECT p FROM Permissions p WHERE p.description = :description")
})
public class Permissions implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 32)
    private String nname;
    @Size(max = 48)
    private String description;
    @OneToMany(mappedBy = "permissionId")
    private Collection<UsersToPermissions> usersToPermissionsCollection;
    @OneToMany(mappedBy = "permissionId")
    private Collection<Entitiy> entitiyCollection;

    public Permissions()
    {
    }

    public Permissions(Integer id)
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

    public String getNname()
    {
        return nname;
    }

    public void setNname(String nname)
    {
        this.nname = nname;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @XmlTransient
    public Collection<UsersToPermissions> getUsersToPermissionsCollection()
    {
        return usersToPermissionsCollection;
    }

    public void setUsersToPermissionsCollection(Collection<UsersToPermissions> usersToPermissionsCollection)
    {
        this.usersToPermissionsCollection = usersToPermissionsCollection;
    }

    @XmlTransient
    public Collection<Entitiy> getEntitiyCollection()
    {
        return entitiyCollection;
    }

    public void setEntitiyCollection(Collection<Entitiy> entitiyCollection)
    {
        this.entitiyCollection = entitiyCollection;
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
        if (!(object instanceof Permissions))
        {
            return false;
        }
        Permissions other = (Permissions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.Permissions[ id=" + id + " ]";
    }
    
}
