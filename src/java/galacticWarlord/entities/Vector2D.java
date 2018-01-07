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
public class Vector2D implements IJSONEnabled
{

    double x;
    double y;

    public Vector2D()
    {
        x = 0;
        y = 0;

    }

    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;

    }
    
    public Vector2D(JSONObject data)  throws ParseException
    {   parseJSON( data);
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double length()
    {
        return Math.sqrt(x * x + y * y);
    }

    public void scale(double r)
    {
        x = x * r;
        y = y * r;

    }

    public void normalize()
    {
        scale(1 / length());
    }

    public void set(double x, double y)
    {
        this.x = x;
        this.y = y;

    }

    public void set(Vector2D v)
    {
        x += getX();
        y += getY();

    }

    public void add(Vector2D v)
    {
        x += v.getX();
        y += v.getY();

    }

    public void subtract(Vector2D v)
    {
        x -= getX();
        y -= getY();

    }

    @Override
    public JSONObject toJSON()
    {
        JSONObject obj = new JSONObject();
        obj.put("x", x);
        obj.put("y", y);
        return obj;
    }

    @Override
    public void parseJSON(JSONObject data) throws ParseException
    {
        x = data.getDouble("x");
        y = data.getDouble("y");
    }
    
    public String toString()
    {
        return "["+x+", "+y+"]";
    }

}
