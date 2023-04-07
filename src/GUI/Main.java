package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("layout/MainMenu.fxml")));
            primaryStage.setTitle("Rental System");
            primaryStage.setScene(new Scene(root, 300, 500));
            primaryStage.show();
        }catch(Exception e) {
            e.printStackTrace();
        }
//        stage.setTitle("Renal System");
//        VBox vbox = new VBox();
//        Text text = new Text("Main Menu:");
//        Button button1 = new Button("1. Add a property");
//        Button button2 = new Button("2. Add a tenant");
//        Button button3 = new Button("3. Rent a unit");
//        Button button4 = new Button("4. Display properties");
//        Button button5 = new Button("5. Display tenants");
//        Button button6 = new Button("6. Display rented units");
//        Button button7 = new Button("7. Display vacant units");
//        Button button8 = new Button("8. Display all leases");
//        Button button9 = new Button("9. Add a potential tenant to property");
//        Button button10 = new Button("10. Enable property to be available");
//        Button button11 = new Button("11. Account system");
//        vbox.getChildren().add(text);
//        vbox.getChildren().add(button1);
//        vbox.getChildren().add(button2);
//        vbox.getChildren().add(button3);
//        vbox.getChildren().add(button4);
//        vbox.getChildren().add(button5);
//        vbox.getChildren().add(button6);
//        vbox.getChildren().add(button7);
//        vbox.getChildren().add(button8);
//        vbox.getChildren().add(button9);
//        vbox.getChildren().add(button10);
//        vbox.getChildren().add(button11);
//
//        Scene scene = new Scene(vbox,400,400);
//        stage.setScene(scene);
//        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
