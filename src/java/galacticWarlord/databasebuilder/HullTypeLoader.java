/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.databasebuilder;

import galacticWarlord.utils.CSVLine;
import galacticWarlord.utils.SQLConnect;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadl
 */
public class HullTypeLoader
{

    public void load(Connection connection, String csvFile)
    {
        BufferedReader reader;
        try
        {

            reader = new BufferedReader(new FileReader(csvFile));

            String nextLine;

            int lineNumber = 0;
            while ((nextLine = reader.readLine()) != null)
            {
                CSVLine csvLine = new CSVLine(nextLine);
                if (lineNumber != 0)  ///header line
                {
                    String nname = csvLine.getColumn(0);
                    String symbol = csvLine.getColumn(1);
                    String description = csvLine.getColumn(2);

                    addHullType(connection, nname, symbol, description);
                }
                lineNumber++;
            }

        } catch (Exception ex)
        {
            Logger.getLogger(HullTypeLoader.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    void addHullType(Connection connection, String nname, String symbol, String description)
    {
        String sql = "insert into HULL_TYPE (NNAME,SYMBOL,DESCRIPTION) values (?,?,?)";
        PreparedStatement stmt;
        try
        {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nname);
            stmt.setString(2, symbol);
            stmt.setString(3, description);

            stmt.execute();

        } catch (SQLException ex)
        {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
