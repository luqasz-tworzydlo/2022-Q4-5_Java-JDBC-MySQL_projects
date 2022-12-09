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

        /*// dodanie nowego rekordu do tabeli [1.1]
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
        stmt2c.executeUpdate();*/

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
    public static  void showSelectedAlbums() // c5
    {
        System.out.println("Podaj rok, z którego mają być wypisane albumy:");
        System.out.println("1. Wybierz rok 2012");
        System.out.println("2. Wybierz rok 2021");
        System.out.println("3. Wybierz rok 2023");
        var selectYear = 0;
        selectYear = sc.nextInt();
        switch (selectYear) {
            default:
                selectYear = 0;
                break;
            case 1:
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection
                            ("jdbc:mysql://localhost:3306/4.1_music-collection", "root", "");

                    Statement stmt_2012 = con.createStatement();

                    ResultSet lc_2012F = stmt_2012.executeQuery
                            ("SELECT album.title FROM album WHERE year = '2012'");
                    while(lc_2012F.next()) System.out.println
                            ("- " + lc_2012F.getString(1));

                } catch (Exception e1) {
                    throw new RuntimeException(e1);
                }
                break;
            case 2:
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection
                            ("jdbc:mysql://localhost:3306/4.1_music-collection", "root", "");

                    Statement stmt_2021 = con.createStatement();

                    ResultSet lc_2021F = stmt_2021.executeQuery
                            ("SELECT album.title FROM album WHERE year = '2021'");
                    while(lc_2021F.next()) System.out.println
                            ("- " + lc_2021F.getString(1));

                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
                break;
            case 3:
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection
                            ("jdbc:mysql://localhost:3306/4.1_music-collection", "root", "");

                    Statement stmt_2023 = con.createStatement();

                    ResultSet lc_2023F = stmt_2023.executeQuery
                            ("SELECT album.title FROM album WHERE year = '2023'");
                    while(lc_2023F.next()) System.out.println
                            ("- " + lc_2023F.getString(1));

                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
                break;
        }
    }
    public static void showAlbums() // c4
    {
        System.out.println("Wszystkie albumy [z każdego roku]:");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/4.1_music-collection", "root", "");

            Statement stmt_wa = con.createStatement();

            ResultSet lc_waF = stmt_wa.executeQuery
                    ("SELECT title FROM album");
            while(lc_waF.next()) System.out.println
                    ("- " + lc_waF.getString(1));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void showCreators() // c3
    {
        System.out.println("Lista wszystkich wykonawców:");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/4.1_music-collection", "root", "");

            Statement stmt_W = con.createStatement();

            ResultSet lc_Wf = stmt_W.executeQuery
                    ("SELECT name from band");
            while(lc_Wf.next()) System.out.println
                    ("- " + lc_Wf.getString(1));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void addAlbum() // c2
    {
        System.out.println("Dodaj nowy album do bazy danych:");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/4.1_music-collection", "root", "");

            // dodanie nowego, dowolnego rekordu do tabeli 'adv_books'
            PreparedStatement stmt_album = con.prepareStatement
                    ("INSERT INTO album (title, tracks, year) VALUES (?, ?, ?)");

            System.out.println("Podaj nazwę albumu:");
            String ParameterA1;
            ParameterA1 = sc.next();

            System.out.println("Podaj ilość utworów:");
            String ParameterA2;
            ParameterA2 = sc.next();

            System.out.println("Podaj rok albumu:");
            String ParameterA3;
            ParameterA3 = sc.next();

            ((PreparedStatement) stmt_album).setString(1, ParameterA1);
            stmt_album.setString(2, ParameterA2);
            stmt_album.setString(3, ParameterA3);
            stmt_album.executeUpdate(); // dodanie rekordu

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void addCreator() // c1
    {
        System.out.println("Ddaj nowego wykonawcę do bazy danych:");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/4.1_music-collection", "root", "");

            // dodanie nowego, dowolnego rekordu do tabeli 'adv_books'
            PreparedStatement stmt_band = con.prepareStatement
                    ("INSERT INTO band (name, genre, albums) VALUES (?, ?, ?)");

            System.out.println("Podaj nazwę wykonawcy:");
            String ParameterB1;
            ParameterB1 = sc.next();

            System.out.println("Podaj rodzaj muzyki:");
            String ParameterB2;
            ParameterB2 = sc.next();

            System.out.println("Podaj nazwę albumu:");
            String ParameterB3;
            ParameterB3 = sc.next();

            ((PreparedStatement) stmt_band).setString(1, ParameterB1);
            stmt_band.setString(2, ParameterB2);
            stmt_band.setString(3, ParameterB3);
            stmt_band.executeUpdate(); // dodanie rekordu

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
