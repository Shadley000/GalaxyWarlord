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
public class HullMap implements IJSONEnabled
{

    int xMax;
    int yMax;
    HullSection hullMap[][];
    
   

    public HullMap(int xMax, int yMax)
    {
        this.xMax = xMax;
        this.yMax = yMax;
        hullMap = new HullSection[xMax][yMax];

    }

    public int getXMax()
    {
        return xMax;
    }

    public int getYMax()
    {
        return yMax;
    }
    
    public HullSection get(int x, int y)
    {
        return hullMap[x][y];
    }

    public HullMap(JSONObject data) throws ParseException
    {
        parseJSON(data);

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
