/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.entities;

import java.text.ParseException;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author shadl
 */
public class GalacticEntity implements IJSONEnabled
{

    int id;
    String name;
    String type;

    Vector2D location;
    Vector2D heading;

    HullMap hullMap;
    List<IngredientStorage> ingredientStorageList;
    List<Factory> factoryList;

    public GalacticEntity()
    {
    }

    public GalacticEntity(JSONObject data) throws ParseException
    {
        parseJSON(data);
    }

    @Override
    public JSONObject toJSON()
    {
        JSONObject obj = new JSONObject();

        obj.put("id", id);
        obj.put("name", name);
        obj.put("type", type);
        obj.put("location", location.toJSON());
        obj.put("heading", heading.toJSON());
        return obj;
    }

    @Override
    public void parseJSON(JSONObject data) throws ParseException
    {

        id = data.getInt("id");
        name = data.getString("name");
        type = data.getString("type");
        location = new Vector2D(data.getJSONObject("location"));
        heading = new Vector2D(data.getJSONObject("heading"));

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Vector2D getLocation()
    {
        return location;
    }

    public void setLocation(Vector2D location)
    {
        this.location = location;
    }

    public Vector2D getHeading()
    {
        return heading;
    }

    public void setHeading(Vector2D heading)
    {
        this.heading = heading;
    }

}
