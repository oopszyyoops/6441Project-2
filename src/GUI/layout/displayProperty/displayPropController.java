package GUI.layout.displayProperty;
import service.impl.PropertyServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import service.PropertyService;

public class displayPropController implements Initializable {
    @FXML
    private TextArea textArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setWrapText(true);
        String allProperty = "";
        allProperty = allProperty + ("************************************************* Apartment ***********************************************\n");
        allProperty = allProperty + ("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Available\n");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        PropertyService propertyService = new PropertyServiceImpl();
       // propertyService.displayAllApartment();
        System.out.print("***********************************************************************************************************\n\n");

        System.out.print("************************************************* Condo ***************************************************\n");
        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Available");
      //  propertyService.displayAllCondo();
        System.out.print("***********************************************************************************************************\n\n");

        System.out.print("************************************************* House ***************************************************\n");
        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Available");
       // propertyService.displayAllHouse();
        System.out.print("***********************************************************************************************************\n\n");
       // textArea.setText();
    }
}
