package GUI.layout.rentUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class rentUnitController {
    /************************************ add a apartment **********************************************/
    public void rentApartment(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/RentApartment.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /************************************ add a condo **********************************************/
    public void rentCondo(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/RentCondo.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /************************************ add a house **********************************************/
    public void rentHouse(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/RentHouse.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /************************************ cancel *******************************************************/
    public void cancel(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/MainMenu.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
