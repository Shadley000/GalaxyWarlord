/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.test;

import galacticWarlord.entities.Vector2D;
import org.json.JSONObject;

/**
 *
 * @author shadl
 */
public class Test
{

    
    
    public static void main(String args[])

    {
        JSONObject jsonObj1 = new JSONObject();

        jsonObj1.put("key1", 1);
        jsonObj1.put("key2", "more data");
        
        JSONObject jsonObj2 = new JSONObject();

        jsonObj2.put("key3", 12);
        jsonObj2.put("key4", "mordsfgase data");
        
        jsonObj1.put("subobject", jsonObj2);

        Vector2D vector = new Vector2D(0,0);
         jsonObj1.put("location", vector);
        
        
        System.out.println(jsonObj1.toString());
    }
}
