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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "hull_type")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "HullType.findAll", query = "SELECT h FROM HullType h")
    , @NamedQuery(name = "HullType.findById", query = "SELECT h FROM HullType h WHERE h.id = :id")
    , @NamedQuery(name = "HullType.findByContributingFactoryQuantity", query = "SELECT h FROM HullType h WHERE h.contributingFactoryQuantity = :contributingFactoryQuantity")
    , @NamedQuery(name = "HullType.findByContributingStorageQuantity", query = "SELECT h FROM HullType h WHERE h.contributingStorageQuantity = :contributingStorageQuantity")
    , @NamedQuery(name = "HullType.findByNname", query = "SELECT h FROM HullType h WHERE h.nname = :nname")
    , @NamedQuery(name = "HullType.findByDescription", query = "SELECT h FROM HullType h WHERE h.description = :description")
    , @NamedQuery(name = "HullType.findBySymbol", query = "SELECT h FROM HullType h WHERE h.symbol = :symbol")
})
public class HullType implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CONTRIBUTING_FACTORY_QUANTITY")
    private Double contributingFactoryQuantity;
    @Column(name = "CONTRIBUTING_STORAGE_QUANTITY")
    private Double contributingStorageQuantity;
    @Size(max = 32)
    private String nname;
    @Size(max = 256)
    private String description;
    @Size(max = 32)
    private String symbol;
    @OneToMany(mappedBy = "hullTypeId")
    private Collection<HullPieces> hullPiecesCollection;
    @JoinColumn(name = "CONTRIBUTING_FACTORY_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private FactoryType contributingFactoryTypeId;
    @JoinColumn(name = "CONTRIBUTING_STORAGE_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Ingredient contributingStorageTypeId;

    public HullType()
    {
    }

    public HullType(Integer id)
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

    public Double getContributingFactoryQuantity()
    {
        return contributingFactoryQuantity;
    }

    public void setContributingFactoryQuantity(Double contributingFactoryQuantity)
    {
        this.contributingFactoryQuantity = contributingFactoryQuantity;
    }

    public Double getContributingStorageQuantity()
    {
        return contributingStorageQuantity;
    }

    public void setContributingStorageQuantity(Double contributingStorageQuantity)
    {
        this.contributingStorageQuantity = contributingStorageQuantity;
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

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
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

    public FactoryType getContributingFactoryTypeId()
    {
        return contributingFactoryTypeId;
    }

    public void setContributingFactoryTypeId(FactoryType contributingFactoryTypeId)
    {
        this.contributingFactoryTypeId = contributingFactoryTypeId;
    }

    public Ingredient getContributingStorageTypeId()
    {
        return contributingStorageTypeId;
    }

    public void setContributingStorageTypeId(Ingredient contributingStorageTypeId)
    {
        this.contributingStorageTypeId = contributingStorageTypeId;
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
        if (!(object instanceof HullType))
        {
            return false;
        }
        HullType other = (HullType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.HullType[ id=" + id + " ]";
    }
    
}
