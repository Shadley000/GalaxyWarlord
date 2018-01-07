/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.entity;

import java.io.Serializable;
import java.util.Collection;
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
    @NamedQuery(name = "Entitiy.findAll", query = "SELECT e FROM Entitiy e")
    , @NamedQuery(name = "Entitiy.findById", query = "SELECT e FROM Entitiy e WHERE e.id = :id")
    , @NamedQuery(name = "Entitiy.findByNname", query = "SELECT e FROM Entitiy e WHERE e.nname = :nname")
    , @NamedQuery(name = "Entitiy.findByDescription", query = "SELECT e FROM Entitiy e WHERE e.description = :description")
    , @NamedQuery(name = "Entitiy.findByMass", query = "SELECT e FROM Entitiy e WHERE e.mass = :mass")
    , @NamedQuery(name = "Entitiy.findByRadius", query = "SELECT e FROM Entitiy e WHERE e.radius = :radius")
    , @NamedQuery(name = "Entitiy.findByReflectivity", query = "SELECT e FROM Entitiy e WHERE e.reflectivity = :reflectivity")
    , @NamedQuery(name = "Entitiy.findByRadiance", query = "SELECT e FROM Entitiy e WHERE e.radiance = :radiance")
    , @NamedQuery(name = "Entitiy.findByPositionX", query = "SELECT e FROM Entitiy e WHERE e.positionX = :positionX")
    , @NamedQuery(name = "Entitiy.findByPositionY", query = "SELECT e FROM Entitiy e WHERE e.positionY = :positionY")
    , @NamedQuery(name = "Entitiy.findByFacingX", query = "SELECT e FROM Entitiy e WHERE e.facingX = :facingX")
    , @NamedQuery(name = "Entitiy.findByFacingY", query = "SELECT e FROM Entitiy e WHERE e.facingY = :facingY")
    , @NamedQuery(name = "Entitiy.findByVelocityX", query = "SELECT e FROM Entitiy e WHERE e.velocityX = :velocityX")
    , @NamedQuery(name = "Entitiy.findByVelocityY", query = "SELECT e FROM Entitiy e WHERE e.velocityY = :velocityY")
})
public class Entitiy implements Serializable
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double mass;
    private Double radius;
    private Double reflectivity;
    private Double radiance;
    @Column(name = "POSITION_X")
    private Double positionX;
    @Column(name = "POSITION_Y")
    private Double positionY;
    @Column(name = "FACING_X")
    private Double facingX;
    @Column(name = "FACING_Y")
    private Double facingY;
    @Column(name = "VELOCITY_X")
    private Double velocityX;
    @Column(name = "VELOCITY_Y")
    private Double velocityY;
    @OneToMany(mappedBy = "entityId")
    private Collection<Factory> factoryCollection;
    @OneToMany(mappedBy = "entityId")
    private Collection<IngredientStorage> ingredientStorageCollection;
    @OneToMany(mappedBy = "entityId")
    private Collection<HullPieces> hullPiecesCollection;
    @OneToMany(mappedBy = "entryEntityId")
    private Collection<WarpGate> warpGateCollection;
    @OneToMany(mappedBy = "exitEntityId")
    private Collection<WarpGate> warpGateCollection1;
    @JoinColumn(name = "SOLAR_SYSTEM_ID", referencedColumnName = "ID")
    @ManyToOne
    private SolarSystem solarSystemId;
    @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Permissions permissionId;

    public Entitiy()
    {
    }

    public Entitiy(Integer id)
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

    public Double getMass()
    {
        return mass;
    }

    public void setMass(Double mass)
    {
        this.mass = mass;
    }

    public Double getRadius()
    {
        return radius;
    }

    public void setRadius(Double radius)
    {
        this.radius = radius;
    }

    public Double getReflectivity()
    {
        return reflectivity;
    }

    public void setReflectivity(Double reflectivity)
    {
        this.reflectivity = reflectivity;
    }

    public Double getRadiance()
    {
        return radiance;
    }

    public void setRadiance(Double radiance)
    {
        this.radiance = radiance;
    }

    public Double getPositionX()
    {
        return positionX;
    }

    public void setPositionX(Double positionX)
    {
        this.positionX = positionX;
    }

    public Double getPositionY()
    {
        return positionY;
    }

    public void setPositionY(Double positionY)
    {
        this.positionY = positionY;
    }

    public Double getFacingX()
    {
        return facingX;
    }

    public void setFacingX(Double facingX)
    {
        this.facingX = facingX;
    }

    public Double getFacingY()
    {
        return facingY;
    }

    public void setFacingY(Double facingY)
    {
        this.facingY = facingY;
    }

    public Double getVelocityX()
    {
        return velocityX;
    }

    public void setVelocityX(Double velocityX)
    {
        this.velocityX = velocityX;
    }

    public Double getVelocityY()
    {
        return velocityY;
    }

    public void setVelocityY(Double velocityY)
    {
        this.velocityY = velocityY;
    }

    @XmlTransient
    public Collection<Factory> getFactoryCollection()
    {
        return factoryCollection;
    }

    public void setFactoryCollection(Collection<Factory> factoryCollection)
    {
        this.factoryCollection = factoryCollection;
    }

    @XmlTransient
    public Collection<IngredientStorage> getIngredientStorageCollection()
    {
        return ingredientStorageCollection;
    }

    public void setIngredientStorageCollection(Collection<IngredientStorage> ingredientStorageCollection)
    {
        this.ingredientStorageCollection = ingredientStorageCollection;
    }

    @XmlTransient
    public Collection<HullPieces> getHullPiecesCollection()
    {
        return hullPiecesCollection;
    }

    public void setHullPiecesCollection(Collection<HullPieces> hullPiecesCollection)
    {
        this.hullPiecesCollection = hullPiecesCollection;
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

    public SolarSystem getSolarSystemId()
    {
        return solarSystemId;
    }

    public void setSolarSystemId(SolarSystem solarSystemId)
    {
        this.solarSystemId = solarSystemId;
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
        if (!(object instanceof Entitiy))
        {
            return false;
        }
        Entitiy other = (Entitiy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.Entitiy[ id=" + id + " ]";
    }
    
}
