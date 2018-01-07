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
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")
    , @NamedQuery(name = "Recipe.findById", query = "SELECT r FROM Recipe r WHERE r.id = :id")
    , @NamedQuery(name = "Recipe.findByNname", query = "SELECT r FROM Recipe r WHERE r.nname = :nname")
    , @NamedQuery(name = "Recipe.findByDescription", query = "SELECT r FROM Recipe r WHERE r.description = :description")
    , @NamedQuery(name = "Recipe.findByTimeSeconds", query = "SELECT r FROM Recipe r WHERE r.timeSeconds = :timeSeconds")
})
public class Recipe implements Serializable
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
    @Column(name = "TIME_SECONDS")
    private Integer timeSeconds;
    @OneToMany(mappedBy = "recipeId")
    private Collection<RecipeIngredients> recipeIngredientsCollection;

    public Recipe()
    {
    }

    public Recipe(Integer id)
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

    public Integer getTimeSeconds()
    {
        return timeSeconds;
    }

    public void setTimeSeconds(Integer timeSeconds)
    {
        this.timeSeconds = timeSeconds;
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
        if (!(object instanceof Recipe))
        {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "galacticWarlord.jpa.Recipe[ id=" + id + " ]";
    }
    
}
