package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.fournisseur;

import static Model.fournisseur.fournis;

public class Fournisseur {


    public static fournisseur four=new fournisseur();


    public boolean AjoutFournisseur(fournisseur fr) {
        try {
            //Création d'une requête SQL
            String req = "insert into fournisseur ( NumFr, nom, adresse, RC ) values ('" +fr.getNFournisseur() +"','"+ fr.getNom() + "', '" + fr.getAdresse() + "','" + fr.getRC()+"')";
            //Étape 3 : Création d'un Stalement
            Statement st = Connexion.getCn().createStatement();
            //Étape 4 : Exécution de la requête
            if (st.executeUpdate(req) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return false;
    }


    public boolean ModifierFournisseur(fournisseur fr) {
        System.out.println(fr.toString());
        try {
            //String req = "update fournisseur set nom ='"+fr.getNom()+"', adresse ='"+fr.getAdresse()+"' ,RC ='"+fr.getRC()+"' where id = "+fr.getNFournisseur();
            String req = "update fournisseur set nom ='"+fr.getNom()+"', adresse ='"+fr.getAdresse()+"' ,RC ='"+fr.getRC()+"' where numfr = '"+fr.getNFournisseur()+"';";
            Statement st = Connexion.getCn().createStatement();
            if(st.executeUpdate(req) == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return false;
    }

    public void Consult1Fournisseur(String nom) {
        try {
            //String req = "select * fournisseur where nom=" + nom;
            String req = "select * from fournisseur where nom = '" +nom+"';";
            Statement st = Connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
               // fournisseur four = new fournisseur(rs.getString("NFournisseur"), rs.getString("nom"), rs.getString("adresse") , rs.getString("RC"));
                four = new fournisseur(rs.getString("NumFr"), rs.getString("nom"), rs.getString("adresse") , rs.getString("RC"));

            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        System.out.println(four.toString());
    }


    public boolean SupprimFournisseur(String name) {
        try {
            String req = "delete from `fournisseur` where nom='" +name+"';";
            Statement st = Connexion.getCn().createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return false;
    }


    public void ConsultListFournisseurs() {

        fournis.clear();
        try {
            String req = "select * from `fournisseur`";
            Statement st = Connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                fournis.add(new fournisseur(rs.getString("NumFr"), rs.getString("nom"), rs.getString("adresse"), rs.getString("RC")));

            }

        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
    }


    public ArrayList<fournisseur> getArrayList(){
        return fournis;
    }




    }




