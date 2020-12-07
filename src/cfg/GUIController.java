/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg;

import database.autor;
import database.czytelnik;
import database.ksiazka;
import database.wypozyczenia;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author suchy
 */
public class GUIController implements Initializable {

    public Statement statement;
    @FXML
    private TableView<autor> tab1;
    @FXML
    private TableColumn<autor, String> aImie;
    @FXML
    private TableColumn<autor, String> aNazwisko;
    @FXML
    private TextField getAImie;
    @FXML
    private TextField getANazwisko;
    @FXML
    private Button addA;
    @FXML
    private TableView<ksiazka> tab2;
    @FXML
    private TableColumn<ksiazka, String> kNazwa;
    @FXML
    private TableColumn<ksiazka, String> kRok;
    @FXML
    private TableColumn<ksiazka, autor> aImie1;
    @FXML
    private TableColumn<ksiazka, autor> aNazwisko1;
    @FXML
    private Button addK;
    private ComboBox<String> selectA1;
    @FXML
    private TextField getKNazwa;
    @FXML
    private TextField getKRok;
    @FXML
    private TableView<czytelnik> tab3;
    @FXML
    private TableColumn<czytelnik, String> cImie;
    @FXML
    private TableColumn<czytelnik, String> cNazwisko;
    @FXML
    private TableColumn<czytelnik, String> cMiasto;
    @FXML
    private TableColumn<czytelnik, String> cPesel;
    @FXML
    private TextField getCImie;
    @FXML
    private TextField getCNazwisko;
    @FXML
    private TextField getCMiasto;
    @FXML
    private TextField getCPesel;
    @FXML
    private Button addC;

    @FXML
    private TableColumn<autor, String> aId;
    @FXML
    private TableColumn<ksiazka, String> kId;
    @FXML
    private TableColumn<czytelnik, String> cId;
    private TextField getAId;
    private TextField getKId;
    @FXML
    private Button delA;
    private TextField delAId;
    @FXML
    private Button delK;
    private TextField delKId;
    @FXML
    private Button delC;
    private TextField delCId;
    @FXML
    private TableColumn<wypozyczenia, String> wId;
    @FXML
    private TableColumn<wypozyczenia, String> wIdC;
    @FXML
    private TableColumn<wypozyczenia, String> wIdK;
    @FXML
    private Button addW;
    @FXML
    private Button delW;
    private TextField delWId;

    private Connection con;
    private ObservableList<autor> aList;
    private ObservableList<ksiazka> kList;
    private ObservableList<czytelnik> cList;
    private ObservableList<wypozyczenia> wList;
    private DbConnect dbConnect;
    @FXML
    private TableView<wypozyczenia> tab4;
    private TextField getCId;
    @FXML
    private ComboBox<String> choiceDelA;
    @FXML
    private ComboBox<String> choiceDelK;
    @FXML
    private ComboBox<String> choiceDelC;
    @FXML
    private ComboBox<String> choiceGetK;
    @FXML
    private ComboBox<String> choiceGetC;
    @FXML
    private ComboBox<String> choiceDelW;
    @FXML
    private ComboBox<String> choiceGetA;


    ArrayList<autor> arrayList = new ArrayList<>();
    ArrayList<czytelnik> arrayList1 = new ArrayList<>();
    ArrayList<ksiazka> arrayList2 = new ArrayList<>();
    ArrayList<wypozyczenia> arrayList3 = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbConnect = new DbConnect();

        wywolaj();
    }

    private void autorTableView() {
        try {
            aList = FXCollections.observableArrayList();
            String query = "SELECT * FROM autor";
            con = dbConnect.getConnection();
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                autor a = new autor();
                a.setIdAutora(set.getInt("idAutora"));
                a.setImie(set.getString("imie"));
                a.setNazwisko(set.getString("nazwisko"));
                aList.add(a);
                arrayList.add(a);
            }
            //arrayList.addAll(aList);
            aId.setCellValueFactory(new PropertyValueFactory<>("idAutora"));
            aImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
            aNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            tab1.setItems(aList);
            choiceDelA.getItems().clear();
            
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ksiazkaTableView() {
        try {
            kList = FXCollections.observableArrayList();
            aList = FXCollections.observableArrayList();
            String query = "SELECT * FROM ksiazka INNER JOIN autor ON ksiazka.idAutora=autor.idAutora";
            con = dbConnect.getConnection();
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                ksiazka k = new ksiazka();
                k.setIdKsiazki(set.getInt("idKsiazki"));
                k.setNazwa(set.getString("nazwa"));
                k.setRokWydania(set.getInt("rokWydania"));
                k.setIdAutora(set.getInt("idAutora"));
                k.setImie(set.getString("imie"));
                k.setNazwisko(set.getString("nazwisko"));
                kList.add(k);
                arrayList2.add(k);
            }
            arrayList2.addAll(kList);
            kId.setCellValueFactory(new PropertyValueFactory<>("idKsiazki"));
            kNazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            kRok.setCellValueFactory(new PropertyValueFactory<>("rokWydania"));
            aImie1.setCellValueFactory(new PropertyValueFactory<>("imie"));
            aNazwisko1.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            choiceDelK.getItems().clear();
            
            tab2.setItems(kList);
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void czytelnikTableView() {
        try {
            cList = FXCollections.observableArrayList();
            String query = "SELECT * FROM czytelnik";
            con = dbConnect.getConnection();
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                czytelnik c = new czytelnik();
                c.setIdCzytelnika(set.getInt("idCzytelnika"));
                c.setImie(set.getString("imie"));
                c.setNazwisko(set.getString("nazwisko"));
                c.setMiasto(set.getString("miasto"));
                c.setPesel(set.getInt("pesel"));
                cList.add(c);
                arrayList1.add(c);
            }

            //arrayList1.addAll(cList);
            cId.setCellValueFactory(new PropertyValueFactory<>("idCzytelnika"));
            cImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
            cNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            cMiasto.setCellValueFactory(new PropertyValueFactory<>("miasto"));
            cPesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
            choiceDelC.getItems().clear();
            
            tab3.setItems(cList);
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void wypozyczeniaTableView() {
        try {
            wList = FXCollections.observableArrayList();
            String query = "SELECT *, CONCAT(czytelnik.imie,' ',czytelnik.nazwisko) AS imna FROM wypozyczenia INNER JOIN czytelnik on wypozyczenia.idCzytelnika=czytelnik.idCzytelnika INNER JOIN ksiazka ON wypozyczenia.idKsiazki=ksiazka.idKsiazki ORDER BY idWypozyczenia";
            con = dbConnect.getConnection();
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                wypozyczenia w = new wypozyczenia();
                w.setIdWypozyczenia(set.getInt("idWypozyczenia"));
                w.setImNa(set.getString("imna"));
                w.setNazwa(set.getString("nazwa"));
                wList.add(w);
                arrayList3.add(w);
            }
            //arrayList3.addAll(wList);
            wId.setCellValueFactory(new PropertyValueFactory<>("idWypozyczenia"));
            wIdK.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            wIdC.setCellValueFactory(new PropertyValueFactory<>("ImNa"));
            choiceDelW.getItems().clear();
            choiceGetC.getItems().clear();
            choiceGetK.getItems().clear();
            
            tab4.setItems(wList);
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addA(ActionEvent event) throws ClassNotFoundException, SQLException {
        String imie, nazwisko;
        imie = getAImie.getText();
        nazwisko = getANazwisko.getText();
        String reset = "ALTER TABLE autor AUTO_INCREMENT = 1;";
        String add = "INSERT INTO `autor` (`idAutora`, `imie`, `nazwisko`) VALUES (NULL, '" + imie + "','" + nazwisko + "');";
        statement = con.createStatement();
        statement.executeUpdate(reset);
        statement.executeUpdate(add);
        wywolaj();
        //selectDelAutor();
        getAImie.clear();
        getANazwisko.clear();
        
    }

    @FXML
    private void addK(ActionEvent event) throws ClassNotFoundException, SQLException {
        String nazwa, rokWydania;
        nazwa = getKNazwa.getText();
        rokWydania = getKRok.getText();
        int idAutora= choiceGetA.getSelectionModel().getSelectedIndex();
        String reset = "ALTER TABLE ksiazka AUTO_INCREMENT = 1;";
        String add = "INSERT INTO `ksiazka` (`idKsiazki`, `nazwa`, `rokWydania`, `idAutora`) VALUES (NULL, '" + nazwa + "','" + rokWydania + "','" + idAutora + "');";
        statement = con.createStatement();
        statement.executeUpdate(reset);
        statement.executeUpdate(add);

        wywolaj();
        getKNazwa.clear();
        getKRok.clear();
        choiceGetA.setValue(null);
    }

    @FXML
    private void addC(ActionEvent event) throws ClassNotFoundException, SQLException {
        String imie, nazwisko, miasto, pesel;
        imie = getCImie.getText();
        nazwisko = getCNazwisko.getText();
        miasto = getCMiasto.getText();
        pesel = getCPesel.getText();
        String reset = "ALTER TABLE czytelnik AUTO_INCREMENT = 1;";
        String add = "INSERT INTO `czytelnik`(`idCzytelnika`, `imie`, `nazwisko`, `miasto`, `pesel`) VALUES (NULL,'" + imie + "','" + nazwisko + "','" + miasto + "','" + pesel + "');";
        statement = con.createStatement();
        statement.executeUpdate(reset);
        statement.executeUpdate(add);
        wywolaj();
        getCImie.clear();
        getCNazwisko.clear();
        getCMiasto.clear();
        getCPesel.clear();
    }

    @FXML
    private void addW(ActionEvent event) {
        addW();
    }

    @FXML
    private void delA(ActionEvent event) {
        delA();
    }

    @FXML
    private void delK(ActionEvent event) throws ClassNotFoundException, SQLException {
        delK();
    }

    @FXML
    private void delC(ActionEvent event) throws ClassNotFoundException, SQLException {
        delC();
    }

    @FXML
    private void delW(ActionEvent event) throws ClassNotFoundException, SQLException {
        delW();
    }

    private void selectDelAutor() {
        try {
            choiceDelA.getItems().clear();
            String query = "SELECT *, CONCAT(autor.imie,' ',autor.nazwisko) AS imna FROM autor";
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                choiceDelA.getItems().add(set.getString("imna"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectDelKsiazka() {
        try {
            choiceDelK.getItems().clear();
            String query = "SELECT * FROM ksiazka";
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                choiceDelK.getItems().add(set.getString("nazwa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectDelCzytelnik() {
        try {
            choiceDelC.getItems().clear();
            String query = "SELECT *, CONCAT(czytelnik.imie,' ',czytelnik.nazwisko) AS imna FROM czytelnik";
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                choiceDelC.getItems().add(set.getString("imna"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectAddWypozyczenia() {
        try {
            choiceGetC.getItems().clear();
            choiceGetK.getItems().clear();
            String query1 = "SELECT *, CONCAT(czytelnik.imie,' ',czytelnik.nazwisko) AS imna FROM czytelnik";
            String query2 = "SELECT * FROM ksiazka";
            ResultSet set1 = con.createStatement().executeQuery(query1);
            ResultSet set2 = con.createStatement().executeQuery(query2);
            while (set1.next()) {
                choiceGetC.getItems().add(set1.getString("imna"));
            }
            while (set2.next()) {
                choiceGetK.getItems().add(set2.getString("nazwa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void selectAddKlient() {
        try {
            choiceGetA.getItems().clear();
            String query = "SELECT *, CONCAT(autor.imie,' ',autor.nazwisko) AS imna FROM autor";
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                choiceGetA.getItems().add(set.getString("imna"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectDelWypozyczenia() {
        try {
            choiceDelW.getItems().clear();
            String query = "SELECT *, CONCAT(czytelnik.imie,' ',czytelnik.nazwisko,', nazwa ksiazki: ',ksiazka.nazwa) AS imna FROM wypozyczenia INNER JOIN czytelnik on wypozyczenia.idCzytelnika=czytelnik.idCzytelnika INNER JOIN ksiazka ON wypozyczenia.idKsiazki=ksiazka.idKsiazki ORDER BY idWypozyczenia";
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                choiceDelW.getItems().add(set.getString("imna"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void delA() {
        try {
            
            int id;
            //id = choiceDelA.getSelectionModel().getSelectedIndex() + 1;
            id=arrayList.get(choiceDelA.getSelectionModel().getSelectedIndex()).getIdAutora();
            System.out.println(id);
            String del = "DELETE FROM autor where idAutora=" + id;
            String reset = "ALTER TABLE autor AUTO_INCREMENT ="+id;
            statement = con.createStatement();
            statement.executeUpdate(del);
            statement.executeUpdate(reset);
            choiceDelA.setValue(null);
            wywolaj();
        } catch (SQLException ex) {
            choiceDelA.setValue(null);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Błąd usunięcia");
            alert.setHeaderText(null);
            alert.setContentText("Nie można usunąć autora który jest przypisany do ksiązki, najpierw usuń książkę z nim powiązaną!");
            alert.showAndWait();
        }
    }

    private void delK() {
        try {
            String test;
            int id;
            //id = choiceDelK.getSelectionModel().getSelectedIndex() + 1;

            id=arrayList2.get(choiceDelK.getSelectionModel().getSelectedIndex()).getIdKsiazki();
            String del = "DELETE FROM ksiazka where idKsiazki=" + (id);
            statement = con.createStatement();
            statement.executeUpdate(del);
            choiceDelK.setValue(null);
            wywolaj();
        } catch (SQLException ex) {
            choiceDelK.setValue(null);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Błąd usunięcia");
            alert.setHeaderText(null);
            alert.setContentText("Nie można usunąć książki która jest przypisana do czytelnika, najpierw usuń czytelnika z nią powiązaną!");
            alert.showAndWait();
        }
    }

    private void delC() {
        try {
            int id;
            //id = choiceDelC.getSelectionModel().getSelectedIndex() + 1;

            id=arrayList1.get(choiceDelC.getSelectionModel().getSelectedIndex()).getIdCzytelnika();
            System.out.println(id);
            String del = "DELETE FROM czytelnik where idCzytelnika=" + (id);
            statement = con.createStatement();
            statement.executeUpdate(del);
            choiceDelA.setValue(null);
            wywolaj();
        } catch (SQLException ex) {
            choiceDelA.setValue(null);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Błąd usunięcia");
            alert.setHeaderText(null);
            alert.setContentText("Nie można usunąć czytelnika!");
            alert.showAndWait();
        }
    }

    private void delW() {
        try {
            int id;
            //id = choiceDelW.getSelectionModel().getSelectedIndex() + 1;
            id=arrayList3.get(choiceDelW.getSelectionModel().getSelectedIndex()).getIdWypozyczenia();
            System.out.println(id);
            String del = "DELETE FROM wypozyczenia where idWypozyczenia=" + (id);
            String reset = "ALTER TABLE wypozyczenia AUTO_INCREMENT = "+1;
            statement = con.createStatement();
            statement.executeUpdate(del);
            statement.executeUpdate(reset);
            choiceDelW.setValue(null);
            wywolaj();
        } catch (SQLException ex) {
            choiceDelA.setValue(null);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Błąd usunięcia");
            alert.setHeaderText(null);
            alert.setContentText("Nie można usunąć wypozyczenia!");
            alert.showAndWait();
        }
    }

    private void addW() {
        try {
            int id1,id2;
            id1 = choiceGetC.getSelectionModel().getSelectedIndex() + 1;
            id2 = choiceGetK.getSelectionModel().getSelectedIndex() + 1;
            System.out.println(id1);
            String add = "INSERT INTO `wypozyczenia`(`idWypozyczenia`, `idCzytelnika`, `idKsiazki`) VALUES (NULL,'" + id1 + "','" + id2 + "');";
            
            statement = con.createStatement();
            statement.executeUpdate(add);
            wywolaj();
            choiceGetC.setValue(null);
            choiceGetK.setValue(null);
        } catch (SQLException ex) {
            choiceDelW.setValue(null);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Błąd usunięcia");
            alert.setHeaderText(null);
            alert.setContentText("Nie można usunąć wypozyczenia!");
            alert.showAndWait();
        }
    }
    public void wywolaj(){
        czytelnikTableView();
        ksiazkaTableView();
        autorTableView();
        wypozyczeniaTableView();
        selectAddWypozyczenia();
        selectDelWypozyczenia();
        selectDelCzytelnik();
        selectAddKlient();
        selectDelKsiazka();
        selectDelAutor();
    }
}
