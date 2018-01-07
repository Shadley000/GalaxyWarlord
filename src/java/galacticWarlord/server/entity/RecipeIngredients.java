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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "recipe_ingredients")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "RecipeIngredients.findAll", query = "SELECT r FROM RecipeIngredients r")
    , @NamedQuery(name = "RecipeIngredients.findById", query = "SELECT r FROM RecipeIngredients r WHERE r.id = :id")
    , @NamedQuery(name = "RecipeIngredients.findByQuantity", query = "SELECT r FROM RecipeIngredients r WHERE r.quantity = :quantity")
})
public class RecipeIngredients implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double quantity;
    @JoinColumn(name = "RECIPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Recipe recipeId;
    @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Ingredient ingredientId;

    public RecipeIngredients()
    {
    }

    public RecipeIngredients(Integer id)
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

    public Double getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Double quantity)
    {
        this.quantity = quantity;
    }

    public Recipe getRecipeId()
    {
        return recipeId;
    }

    public void setRecipeId(Recipe recipeId)
    {
        this.recipeId = recipeId;
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
        if (!(object instanceof RecipeIngredients))
        {
            return false;
        }
        RecipeIngredients other = (RecipeIngredients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.RecipeIngredients[ id=" + id + " ]";
    }
    
}
