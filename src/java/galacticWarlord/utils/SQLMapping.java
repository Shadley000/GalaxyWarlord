/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.utils;

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
public class SQLMapping
{
    Map<String, String> myMap = new HashMap();
    
    public SQLMapping(Connection connection,String tableName, String keyName, String valueName)
    {
        String sql = "select "+keyName+", "+valueName+" from "+tableName;
        PreparedStatement stmt;
        try
        {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                String name = rs.getString(keyName);
                String value = rs.getString(valueName);
                myMap.put(name, value);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public String getValue(String key) {return myMap.get(key);}
}
