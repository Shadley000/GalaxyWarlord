/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.databasebuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author shadl
 */
public class FactoryTypeLoader
{

    public FactoryTypeLoader()
    {
    }

    void load(Connection connection, String fileName)
    {
        BufferedReader reader;

        try
        {

            reader = new BufferedReader(new FileReader(fileName));

            String nextLine;
            StringBuffer sb = new StringBuffer();

            while ((nextLine = reader.readLine()) != null)
            {
                sb.append(nextLine);
            }
            reader.close();

            JSONArray factoryArray = new JSONArray(sb.toString());
            for (Iterator it = factoryArray.iterator(); it.hasNext();)
            {
                JSONObject jsonFactoryDefinition = (JSONObject) it.next();
                String nname = jsonFactoryDefinition.getString("NNAME");
                String description = jsonFactoryDefinition.getString("DESCRIPTION");
                int timeInSeconds = jsonFactoryDefinition.getInt("TIME_SECONDS");
                JSONArray ingredientArr = jsonFactoryDefinition.getJSONArray("INGREDIENTS");
                for (Iterator it2 = ingredientArr.iterator(); it2.hasNext();)
                {
                    JSONObject jsonIngredientDefinition = (JSONObject) it2.next();
                    String ingredientName = jsonFactoryDefinition.getString("NNAME");
                    int quantity = jsonFactoryDefinition.getInt("QUANTITY");
                }
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(FactoryTypeLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(FactoryTypeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
