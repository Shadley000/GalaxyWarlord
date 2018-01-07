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
@Table(name = "solar_system")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "SolarSystem.findAll", query = "SELECT s FROM SolarSystem s")
    , @NamedQuery(name = "SolarSystem.findById", query = "SELECT s FROM SolarSystem s WHERE s.id = :id")
    , @NamedQuery(name = "SolarSystem.findByNname", query = "SELECT s FROM SolarSystem s WHERE s.nname = :nname")
    , @NamedQuery(name = "SolarSystem.findByDescription", query = "SELECT s FROM SolarSystem s WHERE s.description = :description")
})
public class SolarSystem implements Serializable
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
    @OneToMany(mappedBy = "entrySolarSystemId")
    private Collection<WarpGate> warpGateCollection;
    @OneToMany(mappedBy = "exitSolarSystemId")
    private Collection<WarpGate> warpGateCollection1;
    @OneToMany(mappedBy = "solarSystemId")
    private Collection<Entitiy> entitiyCollection;

    public SolarSystem()
    {
    }

    public SolarSystem(Integer id)
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
    public Collection<WarpGate> getWarpGateCollection()
    {
        return warpGateCollection;
    }

    public void setWarpGateCollection(Collection<WarpGate> warpGateCollection)
    {
        this.warpGateCollection = warpGateCollection;
    }

    @XmlTransient
    public Collection<WarpGate> getWarpGateCollection1()
    {
        return warpGateCollection1;
    }

    public void setWarpGateCollection1(Collection<WarpGate> warpGateCollection1)
    {
        this.warpGateCollection1 = warpGateCollection1;
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
        if (!(object instanceof SolarSystem))
        {
            return false;
        }
        SolarSystem other = (SolarSystem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.SolarSystem[ id=" + id + " ]";
    }
    
}
