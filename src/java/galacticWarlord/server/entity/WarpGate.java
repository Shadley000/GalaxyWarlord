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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "warp_gate")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "WarpGate.findAll", query = "SELECT w FROM WarpGate w")
    , @NamedQuery(name = "WarpGate.findById", query = "SELECT w FROM WarpGate w WHERE w.id = :id")
    , @NamedQuery(name = "WarpGate.findByNname", query = "SELECT w FROM WarpGate w WHERE w.nname = :nname")
    , @NamedQuery(name = "WarpGate.findByDescription", query = "SELECT w FROM WarpGate w WHERE w.description = :description")
})
public class WarpGate implements Serializable
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
    @JoinColumn(name = "ENTRY_SOLAR_SYSTEM_ID", referencedColumnName = "ID")
    @ManyToOne
    private SolarSystem entrySolarSystemId;
    @JoinColumn(name = "ENTRY_ENTITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Entitiy entryEntityId;
    @JoinColumn(name = "EXIT_SOLAR_SYSTEM_ID", referencedColumnName = "ID")
    @ManyToOne
    private SolarSystem exitSolarSystemId;
    @JoinColumn(name = "EXIT_ENTITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Entitiy exitEntityId;

    public WarpGate()
    {
    }

    public WarpGate(Integer id)
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

    public SolarSystem getEntrySolarSystemId()
    {
        return entrySolarSystemId;
    }

    public void setEntrySolarSystemId(SolarSystem entrySolarSystemId)
    {
        this.entrySolarSystemId = entrySolarSystemId;
    }

    public Entitiy getEntryEntityId()
    {
        return entryEntityId;
    }

    public void setEntryEntityId(Entitiy entryEntityId)
    {
        this.entryEntityId = entryEntityId;
    }

    public SolarSystem getExitSolarSystemId()
    {
        return exitSolarSystemId;
    }

    public void setExitSolarSystemId(SolarSystem exitSolarSystemId)
    {
        this.exitSolarSystemId = exitSolarSystemId;
    }

    public Entitiy getExitEntityId()
    {
        return exitEntityId;
    }

    public void setExitEntityId(Entitiy exitEntityId)
    {
        this.exitEntityId = exitEntityId;
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
        if (!(object instanceof WarpGate))
        {
            return false;
        }
        WarpGate other = (WarpGate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.WarpGate[ id=" + id + " ]";
    }
    
}
