/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shadl
 */
@Entity
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Factory.findAll", query = "SELECT f FROM Factory f")
    , @NamedQuery(name = "Factory.findById", query = "SELECT f FROM Factory f WHERE f.id = :id")
    , @NamedQuery(name = "Factory.findByFactoryId", query = "SELECT f FROM Factory f WHERE f.factoryId = :factoryId")
    , @NamedQuery(name = "Factory.findByTimeStarted", query = "SELECT f FROM Factory f WHERE f.timeStarted = :timeStarted")
})
public class Factory implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Column(name = "FACTORY_ID")
    private Integer factoryId;
    @Column(name = "TIME_STARTED")
    private Integer timeStarted;
    @JoinColumn(name = "ENTITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Entitiy entityId;

    public Factory()
    {
    }

    public Factory(Integer id)
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

    public Integer getFactoryId()
    {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId)
    {
        this.factoryId = factoryId;
    }

    public Integer getTimeStarted()
    {
        return timeStarted;
    }

    public void setTimeStarted(Integer timeStarted)
    {
        this.timeStarted = timeStarted;
    }

    public Entitiy getEntityId()
    {
        return entityId;
    }

    public void setEntityId(Entitiy entityId)
    {
        this.entityId = entityId;
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
        if (!(object instanceof Factory))
        {
            return false;
        }
        Factory other = (Factory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.Factory[ id=" + id + " ]";
    }
    
}
