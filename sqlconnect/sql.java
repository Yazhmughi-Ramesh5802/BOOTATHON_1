package sqlconnect;
import java.sql.*;

public class sql {
    private static Connection conn;
    private static Statement st;
    sql()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp", "root", "1234567890");
            st = conn.createStatement();
            System.out.println("Connection Success");
        }
        catch(Exception e)
        {
            System.out.println("Connection Failed");
        }
    }
    
    public static boolean checklogin(String user, String password) throws SQLException
    {
        new sql();
        ResultSet rs = st.executeQuery("select password from login where username = '" + user + "';");
        String pass = " ";
        while(rs.next())
        pass = rs.getString(1);
        if(pass.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean updatepass(String user, String password)
    {
        try
        {
            new sql();
            st.executeUpdate("update login set password = '" + password + "' where username = '" + user + "';");
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}