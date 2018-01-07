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
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")
    , @NamedQuery(name = "Ingredient.findById", query = "SELECT i FROM Ingredient i WHERE i.id = :id")
    , @NamedQuery(name = "Ingredient.findByNname", query = "SELECT i FROM Ingredient i WHERE i.nname = :nname")
    , @NamedQuery(name = "Ingredient.findByDescription", query = "SELECT i FROM Ingredient i WHERE i.description = :description")
    , @NamedQuery(name = "Ingredient.findByMassPerUnit", query = "SELECT i FROM Ingredient i WHERE i.massPerUnit = :massPerUnit")
})
public class Ingredient implements Serializable
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
    @Column(name = "MASS_PER_UNIT")
    private Double massPerUnit;
    @OneToMany(mappedBy = "ingredientId")
    private Collection<IngredientStorage> ingredientStorageCollection;
    @OneToMany(mappedBy = "ingredientId")
    private Collection<RecipeIngredients> recipeIngredientsCollection;
    @OneToMany(mappedBy = "contributingStorageTypeId")
    private Collection<HullType> hullTypeCollection;

    public Ingredient()
    {
    }

    public Ingredient(Integer id)
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

    public Double getMassPerUnit()
    {
        return massPerUnit;
    }

    public void setMassPerUnit(Double massPerUnit)
    {
        this.massPerUnit = massPerUnit;
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
    public Collection<RecipeIngredients> getRecipeIngredientsCollection()
    {
        return recipeIngredientsCollection;
    }

    public void setRecipeIngredientsCollection(Collection<RecipeIngredients> recipeIngredientsCollection)
    {
        this.recipeIngredientsCollection = recipeIngredientsCollection;
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
        if (!(object instanceof Ingredient))
        {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.Ingredient[ id=" + id + " ]";
    }
    
}
