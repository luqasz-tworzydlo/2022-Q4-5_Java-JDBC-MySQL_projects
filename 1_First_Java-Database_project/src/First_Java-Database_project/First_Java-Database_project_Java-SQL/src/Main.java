import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/1_car-rental", "root", "");
        // odczyt danych z tabeli pracwnikow
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM pracownik");

        while(rs.next())
            System.out.println(rs.getString(3));
    }
}