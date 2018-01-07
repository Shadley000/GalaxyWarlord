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
class HullSection  implements IJSONEnabled
{
    String type;
    
    
    
    public HullSection()
    {
    }
    
    public HullSection(JSONObject data)  throws ParseException
    {   parseJSON( data);
    }

    @Override
    public JSONObject toJSON()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void parseJSON(JSONObject data) throws ParseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
