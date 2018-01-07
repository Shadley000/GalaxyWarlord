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
public interface IJSONEnabled
{
    public JSONObject toJSON();
    public void parseJSON(JSONObject data) throws ParseException;
}
