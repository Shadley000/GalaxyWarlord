/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.databasebuilder;

import galacticWarlord.utils.SQLConnect;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadl
 */
public class Main
{

    public static void main(String args[]) throws SQLException
    {
        SQLConnect mySQLConnect;
        try
        {
            mySQLConnect = new SQLConnect();

            Connection connection = mySQLConnect.connect();
            
            new EntityTypeLoader().load(connection, "ENTITY_TYPE.csv");
            new HullTypeLoader().load(connection, "HULL_TYPE.csv");
            new HullMapLoader().load(connection, "Star.bpt");
            new HullMapLoader().load(connection, "Large Planet.bpt");
            new HullMapLoader().load(connection, "Small Planet.bpt");
            new HullMapLoader().load(connection, "Moon.bpt");
            new HullMapLoader().load(connection, "Asteroid.bpt");
            new HullMapLoader().load(connection, "Comet.bpt");
            new HullMapLoader().load(connection, "Space Station.bpt");
            new HullMapLoader().load(connection, "Flagship.bpt");
            new HullMapLoader().load(connection, "Cruiser.bpt");
            new HullMapLoader().load(connection, "Destroyer.bpt");
            new HullMapLoader().load(connection, "Corvette.bpt");
            new HullMapLoader().load(connection, "Patrol Boat.bpt");
            new HullMapLoader().load(connection, "Drone.bpt");
            new IngredientTypeLoader().load(connection, "INGREDIENT_TYPE.csv");
            new FactoryTypeLoader().load(connection, "FACTORY_TYPE.csv");
            
            connection.close();
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
}
