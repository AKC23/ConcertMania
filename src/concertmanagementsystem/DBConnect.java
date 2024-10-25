package concertmanagementsystem;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DBConnect {
    private  Statement stmt = null;
    private Connection connection;
    
    public Connection connectToDB() throws ClassNotFoundException, SQLException{
        System.out.println("DB is connecting");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13;" + "databaseName=ConcertMania;";
        connection = DriverManager.getConnection(connectionUrl);
        System.out.println("Database is connected successfully");
        java.sql.Statement stmt = connection.createStatement();
        return connection;
      }
    
    public void disconnectFromDB(){

    try{
       // if (rs != null){rs.close();}
        if (stmt != null){stmt.close();}
        if (connection != null){connection.close();}
    }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Unable to close connection");
        }
    }

    public boolean insertDataToDB(String query)
     {
        try
        {
            java.sql.Statement stmt=connection.createStatement();
            stmt.executeUpdate(query);
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println("Unable to Insert Data");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to Insert Data");
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
    public ResultSet queryToDB(String query)
     {
        try
        {
            java.sql.Statement stmt=connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
//            rs.next();
//            Reader reader = rs.getCharacterStream(1);
//            return reader;
            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Unable to Query Data");
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
     }

}

