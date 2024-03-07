package Database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {



    private static String Username = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost/Fournisseurs";
    private static Connection con;
    static {
        try {
        //Étape 1 : Charger le driver de la base de données

            Class.forName("com.mysql.jdbc.Driver");

            //Étape 2 : Authentification auprès de la base de données

            con = DriverManager.getConnection(url,Username,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        } catch (SQLException ex) {
            System.out.println("Erreur de Connexion");
        }
    }

    public static Connection getCn() {
        return con;




    }




}
