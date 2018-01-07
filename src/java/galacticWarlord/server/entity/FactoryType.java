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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "factory_type")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "FactoryType.findAll", query = "SELECT f FROM FactoryType f")
    , @NamedQuery(name = "FactoryType.findById", query = "SELECT f FROM FactoryType f WHERE f.id = :id")
    , @NamedQuery(name = "FactoryType.findByNname", query = "SELECT f FROM FactoryType f WHERE f.nname = :nname")
    , @NamedQuery(name = "FactoryType.findByDescription", query = "SELECT f FROM FactoryType f WHERE f.description = :description")
})
public class FactoryType implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 32)
    private String nname;
    @Size(max = 256)
    private String description;
    @OneToMany(mappedBy = "contributingFactoryTypeId")
    private Collection<HullType> hullTypeCollection;

    public FactoryType()
    {
    }

    public FactoryType(Integer id)
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
    public Collection<HullType> getHullTypeCollection()
    {
        return hullTypeCollection;
    }

    public void setHullTypeCollection(Collection<HullType> hullTypeCollection)
    {
        this.hullTypeCollection = hullTypeCollection;
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
        if (!(object instanceof FactoryType))
        {
            return false;
        }
        FactoryType other = (FactoryType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.FactoryType[ id=" + id + " ]";
    }
    
}
