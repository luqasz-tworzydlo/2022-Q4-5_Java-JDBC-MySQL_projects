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

        var option_number = 0;
        while (option_number != 6) {
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
    }
    public static  void showSelectedAlbums()
    {
        System.out.println("Podaj rok, z którego mają być wypisane albumy:");
        var selectYear = 0;
        selectYear = sc.nextInt();
        // ???
    }
    public static void showAlbums()
    {
        System.out.println("Wszystkie albumy [z kządego roku]:");
        // ???
    }

    public static void showCreators()
    {
        System.out.println("Lista wszystkich wykonawców:");
        // ???
    }
    public static void addAlbum()
    {
        System.out.println("Dodaj nowy album do bazy danych:");
        // ???
    }
    public static void addCreator()
    {
        System.out.println("Ddaj nowego wykonawcę do bazy danych:");
        // ???
    }
}