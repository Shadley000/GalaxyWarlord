/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.utils;

import galacticWarlord.entities.Vector2D;

/**
 *
 * @author shadl
 */
public class MathTool
{

    static public double getRandom(double min, double max)
    {
        return min + (max - min) * Math.random();
    }

    static public Vector2D getRandomVector2D(double radius)
    {
        Vector2D v = new Vector2D();
        v.setX(getRandom(-1.0, 1.0));
        v.setY(getRandom(-1.0, 1.0));
        
        v.normalize();
        v.scale(radius);

        return v;
    }
}
