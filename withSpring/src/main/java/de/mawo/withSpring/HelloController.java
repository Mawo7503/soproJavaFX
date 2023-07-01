package de.mawo.withSpring;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * Example Class to show basic functions of JavaFX.
 * No Error Detection. Wrong inputs may leads to crash!
 * */
public class HelloController implements Initializable {

    ArrayList<Modul> list = new ArrayList<>();

    //IMPORTANT: name of each object must be equal to its name in .fxml
    @FXML
    TextField modulname = new TextField();
    @FXML
    TextField lp = new TextField();
    @FXML
    TextField note = new TextField();

    //Define table:
    @FXML
    public TableView<Modul> modulTableView = new TableView<>();
    public TableColumn<Modul, String> nameColumn = new TableColumn<>("Modulname");
    public TableColumn<Modul, Integer> lpColumn = new TableColumn<>("LP");
    public TableColumn<Modul, Double> noteColumn = new TableColumn<>("Note");


    /**
     * You need this method to initialize a Table (and other stuff not shown here)
     * Controller has to implements 'Initializable' for this method (@Override)
     * */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("modulname"));
        nameColumn.setPrefWidth(100);
        lpColumn.setCellValueFactory(new PropertyValueFactory<>("lp"));
        lpColumn.setPrefWidth(50);
        lpColumn.setPrefWidth(50);
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        modulTableView.getColumns().addAll(nameColumn, lpColumn, noteColumn);
     }

     /**
      * Tableview needs an ObservableList
      * With .setItems you copy Items into the table
      * */
    private void loadItems() {
        ObservableList<Modul> tableList = FXCollections.observableArrayList();
        tableList.addAll(list);
        modulTableView.setItems(tableList);
    }

    /**
     * adds a Modul into a list after Button pressed.
     * Get the inputs with name_of_Testfield.getText().
     * */
    @FXML
    protected void add() {
        list.add(new Modul(modulname.getText(), Integer.parseInt(lp.getText()), Double.parseDouble(note.getText())));
        loadItems();
    }

}