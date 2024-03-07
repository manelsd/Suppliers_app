package sample;

import Database.Fournisseur;
import Model.fournisseur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import static Database.Fournisseur.four;


public class Controller implements Initializable {
    Fournisseur fr = new Fournisseur();



    @FXML
    TextField num,nom,adresse,rc,search;
    @FXML
    private TableColumn<fournisseur, String> numc;
    @FXML
    public TableColumn<fournisseur, String> nomc;
    @FXML
    private TableColumn<fournisseur, String> adressec;
    @FXML
    private TableColumn<fournisseur, String> rcc;
    @FXML
    private TableView<fournisseur> table;

    @FXML
    private ImageView Exit;
    public ObservableList<fournisseur> data= FXCollections.observableArrayList();

    public Controller() {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        showFournisseurs();

    }





    //afficher les fournisseurs dans le tableau
    public void showFournisseurs(){
        // actualise le tableau si on fait la modification
        table.getItems().clear();

        fr.ConsultListFournisseurs();

        ObservableList<fournisseur> observableArrayList =
                FXCollections.observableArrayList(fr.getArrayList());
        data=observableArrayList;


        //chaque colonne represent
        numc.setCellValueFactory(new PropertyValueFactory<fournisseur, String>("NFournisseur"));
        nomc.setCellValueFactory(new PropertyValueFactory<fournisseur, String>("nom"));
        adressec.setCellValueFactory(new PropertyValueFactory<fournisseur ,String>("adresse"));
        rcc.setCellValueFactory(new PropertyValueFactory<fournisseur, String>("RC"));
        table.setItems(data);

    }

    @FXML
    public void Add(){
        if(!num.getText().isEmpty()&&!nom.getText().isEmpty()&&!adresse.getText().isEmpty()&&!rc.getText().isEmpty()){
            String id = num.getText();
            String name = nom.getText();
            String adrs = adresse.getText();
            String RC = rc.getText();


            fr.AjoutFournisseur(new fournisseur(id,name,adrs,RC));

            showFournisseurs();

            num.setText("");
            nom.setText("");
            adresse.setText("");
            rc.setText("");
        }

        else{
            System.out.println("add all element");
        }
    }

@FXML
    public void modifier() {
    if (!num.getText().isEmpty() && !nom.getText().isEmpty() && !adresse.getText().isEmpty() && !rc.getText().isEmpty()) {
        String id = num.getText();
        String name = nom.getText();
        String adrs = adresse.getText();
        String RC = rc.getText();


        fr.ModifierFournisseur(new fournisseur(id, name, adrs, RC));

        showFournisseurs();

        num.setText("");
        nom.setText("");
        adresse.setText("");
        rc.setText("");
    }
}

    @FXML
    public void consulte (){



        four= new fournisseur(four.getNFournisseur(),four.getNom(),four.getAdresse(),four.getRC());
        fr.Consult1Fournisseur(search.getText());

        showFournisseurs();


        nom.setText(four.getNom());
        num.setText(four.getNFournisseur());
        adresse.setText(four.getAdresse());
        rc.setText(four.getRC());



        }
@FXML

public void supprimer(){
        fr.SupprimFournisseur(search.getText());
    num.setText("");
    nom.setText("");
    adresse.setText("");
    rc.setText("");
    showFournisseurs();

}}


