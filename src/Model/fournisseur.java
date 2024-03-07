package Model;

import java.util.ArrayList;

public class fournisseur{
        private String NFournisseur;
        private String nom;
        private String adresse;
        private String RC;

        public static ArrayList<fournisseur> fournis = new ArrayList<fournisseur>();
        public fournisseur(){

        }

        public fournisseur(String NFournisseur, String nom, String adresse, String RC){
            this.NFournisseur= NFournisseur;
            this.nom=nom;
            this.adresse=adresse;
            this.RC=RC;
        }

        public String getNFournisseur() {
            return NFournisseur;
        }

        public void setNFournisseur(String NFournisseur) {
            this.NFournisseur = NFournisseur;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public String getRC() {
            return RC;
        }

        public void setRC(String RC) {
            this.RC = RC;
        }

    @Override
    public String toString() {
        return "fournisseur{" +
                "NFournisseur='" + NFournisseur + '\'' +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", RC='" + RC + '\'' +
                '}';
    }
}
