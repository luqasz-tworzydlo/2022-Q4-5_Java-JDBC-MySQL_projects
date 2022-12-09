import com.sun.security.jgss.GSSUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // odniesienie do lokalnej bazy danych
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/4.1_music-collection", "root", "");

        // dodanie nowego rekordu do tabeli [1.1]
        PreparedStatement stmt1a = con.prepareStatement
                ("INSERT INTO band (name, genre, albums) VALUES (?, ?, ?)");
        ((PreparedStatement)stmt1a).setString(1, "LQ"); // nazwa wykonawcy
        stmt1a.setString(2, "classic"); // rodzaj muzyki
        stmt1a.setString(3, "CM-22"); // nazwa albumu/ów
        stmt1a.executeUpdate();
        // dodanie nowego rekordu do tabeli [1.2]
        PreparedStatement stmt1b = con.prepareStatement
                ("INSERT INTO band (name, genre, albums) VALUES (?, ?, ?)");
        ((PreparedStatement)stmt1b).setString(1, "JTT"); // nazwa wykonawcy
        stmt1b.setString(2, "modern"); // rodzaj muzyki
        stmt1b.setString(3, "MM-22"); // nazwa albumu/ów
        stmt1b.executeUpdate();

        // dodanie nowego rekordu do tabeli [2.1]
        PreparedStatement stmt2a = con.prepareStatement
                ("INSERT INTO album (title, tracks, year) VALUES (?, ?, ?)");
        ((PreparedStatement)stmt2a).setString(1, "LAlbum"); // nazwa albumu
        stmt2a.setString(2, "21"); // ilość utworów
        stmt2a.setString(3, "2012"); // rok albumu
        stmt2a.executeUpdate();

        // dodanie nowego rekordu do tabeli [2.2]
        PreparedStatement stmt2b = con.prepareStatement
                ("INSERT INTO album (title, tracks, year) VALUES (?, ?, ?)");
        ((PreparedStatement)stmt2b).setString(1, "JAlbum"); // nazwa albumu
        stmt2b.setString(2, "300"); // ilość utworów
        stmt2b.setString(3, "2021"); // rok albumu
        stmt2b.executeUpdate();

        // dodanie nowego rekordu do tabeli [2.3]
        PreparedStatement stmt2c = con.prepareStatement
                ("INSERT INTO album (title, tracks, year) VALUES (?, ?, ?)");
        ((PreparedStatement)stmt2c).setString(1, "LJ-Album"); // nazwa albumu
        stmt2c.setString(2, "to be revealed"); // ilość utworów
        stmt2c.setString(3, "2023"); // rok albumu
        stmt2c.executeUpdate();

        var option_number = 0;
            System.out.println("1. Dodaj wykonawcę");
            System.out.println("2. Dodaj album");
            System.out.println("3. Wypisz wykonawców");
            System.out.println("4. Wypisz albumy [wszystkie]");
            System.out.println("5. Wypisz albumy [z wybranego roku]");
            System.out.println("6. Zakończ program.");
            option_number = sc.nextInt();
            switch (option_number) {
                default:
                    option_number = 6;
                    break;
                case 5:
                    showSelectedAlbums();
                    break;
                case 4:
                    showAlbums();
                    break;
                case 3:
                    showCreators();
                    break;
                case 2:
                    addAlbum();
                    break;
                case 1:
                    addCreator();
                    break;
        }
    }
    public static  void showSelectedAlbums() // c1
    {
        System.out.println("Podaj rok, z którego mają być wypisane albumy:");
        var selectYear = 0;
        selectYear = sc.nextInt();
        // ???
    }
    public static void showAlbums() // c2
    {
        System.out.println("Wszystkie albumy [z kządego roku]:");
        // ???
    }

    public static void showCreators() // c3
    {
        System.out.println("Lista wszystkich wykonawców:");
        // ???
    }
    public static void addAlbum() // c4
    {
        System.out.println("Dodaj nowy album do bazy danych:");
        // ???
    }
    public static void addCreator() // c5
    {
        System.out.println("Ddaj nowego wykonawcę do bazy danych:");
        // ???
    }
}