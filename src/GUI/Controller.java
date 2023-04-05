package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class Controller {

    public void goBacktoMainMenu(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/MainMenu.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************1. Add a property******************************************************************/
    public void addProperty(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addProperty/AddProperty.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addApartment(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addProperty/AddApartment.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addCondo(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addProperty/AddCondo.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addHouse(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addProperty/AddHouse.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addPropertyConfirm(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addProperty/Confirm.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void goBacktoAddPropertyMenu(ActionEvent event) throws IOException{
//        Parent root = FXMLLoader.load(getClass().getResource("layout/addProperty/AddProperty.fxml"));
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
    /*******************************2. Add a tenant******************************************************************/
    public void addTenant(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addTenant/AddTenant.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addTenantConfirm(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addTenant/Confirm.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************3. Rent a unit******************************************************************/
    public void rentUnit(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/RentUnit.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void rentApartment(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/RentApartment.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void rentCondo(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/RentCondo.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void rentHouse(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/RentHouse.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void rentUnitConfirm(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/Confirm.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void goBacktoRentUnitMenu(ActionEvent event) throws IOException{
//        Parent root = FXMLLoader.load(getClass().getResource("layout/rentUnit/RentUnit.fxml"));
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
    /*******************************4.Display all properties******************************************************************/
    public void displayProperty(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/displayProperty/DisplayProperty.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************5.Display all tenant******************************************************************/
    public void displayTenant(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/diaplayTenant/DisplayTenant.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************6.Display all rented units******************************************************************/
    public void displayRentedUnit(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/displayRentedUnit/DisplayRentedUnit.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************7.Display all vacant units******************************************************************/
    public void displayVacantUnit(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/diaplayVacantUnit/DisplayVacantUnit.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************8.Display all leases******************************************************************/
    public void displayAllLease(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/diaplayLease/DisplayAllLease.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************9.Add a potential tenant to property******************************************************************/
    public void addPotentialTenant(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addPotentialTenant/AddPotentialTenant.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addPotentialTenantConfirm(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/addPotentialTenant/Confirm.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************10.Enable property to be available******************************************************************/
    public void enalbePropertyAvaliable(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/enablePropertyAvailable/EnalbePropertyAvailable.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void enalbePropertyAvaliableConfirm(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/enablePropertyAvailable/Confirm.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*******************************11. Account systme******************************************************************/
    public void accountSystem(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/accountSystem/AccountSystem.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void changePaymentPaid(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/accountSystem/ChangePaymentPaid.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void changePaymentUnpaid(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/accountSystem/ChangePaymentUnpaid.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void displayPaidList(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/accountSystem/DisplayPaidList.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void displayUnpaidList(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/accountSystem/DisplayUnpaidList.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void paidChangeConfirm(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("layout/accountSystem/PaidChangeConfirm.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void goBacktoAccountSystemMenu(ActionEvent event) throws  IOException{
//        Parent root = FXMLLoader.load(getClass().getResource("layout/accountSystem/AccountSystem.fxml"));
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

}
