package galacticWarlord.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnect
{
    // init database constants

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/galacticwarlord";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "0verl00k";
    private static final String MAX_POOL = "5";

    private Connection connection;
    private Properties properties;

    public SQLConnect() throws ClassNotFoundException
    {
        Class.forName(DATABASE_DRIVER);
        properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("MaxPooledStatements", MAX_POOL);
        properties.setProperty("useSSL", "false");
    }

    // connect database
    public Connection connect() throws SQLException
    {
        connection = DriverManager.getConnection(DATABASE_URL, properties);
        return connection;
    }

    public static void main(String args[])
    {
        System.out.println("database test");
        try
        {
            SQLConnect mySQLConnect = new SQLConnect();
            Connection connection = mySQLConnect.connect();
            System.out.println(connection.toString());

            String sql = "show tables";
            PreparedStatement stmt;

            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                System.out.println(rs.getString(1));
            }
            System.out.println("statement executed");
            connection.close();
            System.out.println("database test completed");
        } catch (SQLException ex)
        {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
