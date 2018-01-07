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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "hull_pieces")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "HullPieces.findAll", query = "SELECT h FROM HullPieces h")
    , @NamedQuery(name = "HullPieces.findById", query = "SELECT h FROM HullPieces h WHERE h.id = :id")
    , @NamedQuery(name = "HullPieces.findByTileX", query = "SELECT h FROM HullPieces h WHERE h.tileX = :tileX")
    , @NamedQuery(name = "HullPieces.findByTileY", query = "SELECT h FROM HullPieces h WHERE h.tileY = :tileY")
    , @NamedQuery(name = "HullPieces.findByHealth", query = "SELECT h FROM HullPieces h WHERE h.health = :health")
})
public class HullPieces implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Column(name = "TILE_X")
    private Integer tileX;
    @Column(name = "TILE_Y")
    private Integer tileY;
    private Integer health;
    @JoinColumn(name = "ENTITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Entitiy entityId;
    @JoinColumn(name = "HULL_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private HullType hullTypeId;

    public HullPieces()
    {
    }

    public HullPieces(Integer id)
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

    public Integer getTileX()
    {
        return tileX;
    }

    public void setTileX(Integer tileX)
    {
        this.tileX = tileX;
    }

    public Integer getTileY()
    {
        return tileY;
    }

    public void setTileY(Integer tileY)
    {
        this.tileY = tileY;
    }

    public Integer getHealth()
    {
        return health;
    }

    public void setHealth(Integer health)
    {
        this.health = health;
    }

    public Entitiy getEntityId()
    {
        return entityId;
    }

    public void setEntityId(Entitiy entityId)
    {
        this.entityId = entityId;
    }

    public HullType getHullTypeId()
    {
        return hullTypeId;
    }

    public void setHullTypeId(HullType hullTypeId)
    {
        this.hullTypeId = hullTypeId;
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
        if (!(object instanceof HullPieces))
        {
            return false;
        }
        HullPieces other = (HullPieces) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.HullPieces[ id=" + id + " ]";
    }
    
}
