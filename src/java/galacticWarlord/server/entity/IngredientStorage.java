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
@Table(name = "ingredient_storage")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "IngredientStorage.findAll", query = "SELECT i FROM IngredientStorage i")
    , @NamedQuery(name = "IngredientStorage.findById", query = "SELECT i FROM IngredientStorage i WHERE i.id = :id")
    , @NamedQuery(name = "IngredientStorage.findByMaximum", query = "SELECT i FROM IngredientStorage i WHERE i.maximum = :maximum")
    , @NamedQuery(name = "IngredientStorage.findByCurrentQuantity", query = "SELECT i FROM IngredientStorage i WHERE i.currentQuantity = :currentQuantity")
})
public class IngredientStorage implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double maximum;
    @Column(name = "CURRENT_QUANTITY")
    private Double currentQuantity;
    @JoinColumn(name = "ENTITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Entitiy entityId;
    @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Ingredient ingredientId;

    public IngredientStorage()
    {
    }

    public IngredientStorage(Integer id)
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

    public Double getMaximum()
    {
        return maximum;
    }

    public void setMaximum(Double maximum)
    {
        this.maximum = maximum;
    }

    public Double getCurrentQuantity()
    {
        return currentQuantity;
    }

    public void setCurrentQuantity(Double currentQuantity)
    {
        this.currentQuantity = currentQuantity;
    }

    public Entitiy getEntityId()
    {
        return entityId;
    }

    public void setEntityId(Entitiy entityId)
    {
        this.entityId = entityId;
    }

    public Ingredient getIngredientId()
    {
        return ingredientId;
    }

    public void setIngredientId(Ingredient ingredientId)
    {
        this.ingredientId = ingredientId;
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
        if (!(object instanceof IngredientStorage))
        {
            return false;
        }
        IngredientStorage other = (IngredientStorage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.IngredientStorage[ id=" + id + " ]";
    }
    
}
