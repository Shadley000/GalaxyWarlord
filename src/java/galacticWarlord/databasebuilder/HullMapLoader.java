/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.databasebuilder;

import galacticWarlord.utils.SQLConnect;
import galacticWarlord.utils.SQLMapping;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadl
 */
public class HullMapLoader
{

    public HullMapLoader()
    {
    }

    public void load(Connection connection, String fileName) throws SQLException
    {
        try
        {
            int entityId = 0; ///this is in error
            
            SQLMapping symbolMap = new SQLMapping(connection,"HULL_TYPE","SYMBOL", "ID");

            BufferedReader myReader = new BufferedReader(new FileReader(fileName));
            String line = myReader.readLine();
            int row = 0;
            while (line != null)
            {
                if (line.startsWith("--"))  //comment.  skip the line
                {

                } else
                {
                    for (int col = 0; col < line.length(); col++)
                    {
                        char symbol = line.charAt(col);
                        if (symbol == ' ')
                        {
                            //empty space skip this
                        } else if (symbol == '|')
                        {
                            break;//end of line
                        } else
                        {
                            int hullTypeId = new Integer(symbolMap.getValue("" + symbol)).intValue();
                            addHullPiece(connection, entityId, row, col, hullTypeId);
                        }
                    }
                    row++;
                }
            }

        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(HullMapLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(HullMapLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void addHullPiece(Connection connection, int entityId, int row, int col, int hullTypeId)
    {
        String sql = "insert into HULL_PIECES (ENTITY_ID,HULL_TYPE_ID,TILE_X,TILE_Y) values (?,?,?,?)";
        PreparedStatement stmt;
        try
        {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, entityId);
            stmt.setInt(2, hullTypeId);
            stmt.setInt(3, col);
            stmt.setInt(4, row);
            stmt.execute();

        } catch (SQLException ex)
        {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
