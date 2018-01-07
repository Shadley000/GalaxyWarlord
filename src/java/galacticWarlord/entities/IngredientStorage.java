/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.entities;

import java.text.ParseException;
import org.json.JSONObject;

/**
 *
 * @author shadl
 */
public class IngredientStorage implements IJSONEnabled
{

    int ingredientId;
    double maximum;
    double current;

    public IngredientStorage()
    {
        maximum = 0;
        current = 0;

    }

    public IngredientStorage(int ingredientId, double maximum, double current)
    {
        this.ingredientId = ingredientId;
        this.current = current;
        this.maximum = maximum;

    }

    public double getCapactityRatio()
    {
        return current / maximum;
    }

    public IngredientStorage(JSONObject data) throws ParseException
    {
        parseJSON(data);
    }

    @Override
    public JSONObject toJSON()
    {
        JSONObject obj = new JSONObject();
        obj.put("ingredient", ingredientId);
        obj.put("maximum", maximum);
        obj.put("current", current);
        return obj;
    }

    @Override
    public void parseJSON(JSONObject data) throws ParseException
    {
        ingredientId = data.getInt("ingredientId");
        maximum = data.getDouble("maximum");
        current = data.getDouble("current");
    }
}
