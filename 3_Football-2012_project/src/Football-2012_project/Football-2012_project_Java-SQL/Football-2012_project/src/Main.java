import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // odniesienie do lokalnej bazy danych
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/4.2_football-2012", "root", "");

        // usuwanie istniejącego już rekordu do bazy danych SQL
        PreparedStatement stmtt = con.prepareStatement("DELETE FROM goal WHERE player=?");

        // stmtt.setString(1, "Robert Lewandowski");
        stmtt.setString(1, "Dimitris Salpingidis");

        stmtt.executeUpdate();
    }
}