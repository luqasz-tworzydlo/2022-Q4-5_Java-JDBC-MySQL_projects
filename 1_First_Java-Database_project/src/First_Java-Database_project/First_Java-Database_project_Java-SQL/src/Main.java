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
                "jdbc:mysql://localhost:3306/1_car-rental", "root", "");

        // odczyt danych z tabeli pracwnikow
        Statement stmt = con.createStatement();

        // wykonanie kodu SQL: SELECT * FROM pracownik
        ResultSet rs = stmt.executeQuery("SELECT * FROM pracownik");
        while(rs.next())
            System.out.println(rs.getString(3)); // wyświetlenie nazwisk

        System.out.println("");

        // wykonanie kodu SQL: SELECT * FROM miejsce"
        ResultSet lc = stmt.executeQuery("SELECT * FROM miejsce");
        while(lc.next())
            System.out.println(lc.getString(4)); // wświetlenie miast

        // dodawanie nowego rekordu do bazy danych SQL
        PreparedStatement stmtt = con.prepareStatement("INSERT INTO miejsce (ulica, numer, miasto, kod, telefon) VALUES (?, ?, ?, ?, ?)");

        stmtt.setString(1, "Grunwaldza");
        stmtt.setString(2, "170");
        stmtt.setString(3, "Gdańsk");
        stmtt.setString(4, "81-532");
        stmtt.setString(5, "567-876-543");

        stmtt.executeUpdate();
    }
}