/**********************************************
 Workshop # 7
 Course: JAC444- Semester 4
 Last Name:SINGH
 First Name:GURPREET
 ID: 074913146
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature: GURPREET SINGH
 Date:March 28/ 2021
 **********************************************/
package WS7.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SameNamesController {

    @FXML
    private TextField sameNameTextField;

    @FXML
    private Button searchButton;

    @FXML
    private Button mainMenuButton;

    ArrayList<String> boyNames = new ArrayList<String>(); // Creating 2 arrayList
    ArrayList<String> girlNames = new ArrayList<String>();

    @FXML
    void mainMenuClicked(ActionEvent event) {
        Stage primaryStage = (Stage) mainMenuButton.getScene().getWindow();
        primaryStage.close(); // Closes the old stage

        //Loading new Stage
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WS7/resources/MainMenu.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void searchButtonClicked(ActionEvent event) { // gets file from the textField
        String filePath = System.getProperty("user.dir") + File.separator + "src/WS7/babynames/" +"babynamesranking"
                + sameNameTextField.getText() + ".txt";
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File babynamesranking" + sameNameTextField.getText() + ".txt does not exist");
            System.exit(1); // closes program if file does not match
        }

        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {

                String s = read.nextLine(); // reads the file
                String[] temp = s.trim().split("\\s+"); // Ignores White Spaces
                boyNames.add(temp[1]); // adds boy names to boyNames Array list
                girlNames.add(temp[3]); // adds girl names to girlNames Array list
            }

            boyNames.retainAll(girlNames); // Filters for same names
            Set<String> set = new LinkedHashSet<>(); // Using set to remove any duplicates from the arrayList
            set.addAll(boyNames); // removes duplicates
            boyNames.clear(); // clears the arraylist
            boyNames.addAll(set); // adds the duplicate free set back to array
            Collections.sort(boyNames); // Sorts the filtered names in ascending order

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //END OF CORE LOGIC------------------------------------------------

        Stage primaryStage = (Stage) searchButton.getScene().getWindow();
        primaryStage.close(); // Closes the old stage

        //Loading new Stage
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WS7/resources/sameNamesOutput.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            SameNamesOutputController sameNamesOutputController = (SameNamesOutputController) loader.getController();
            sameNamesOutputController.initializeResults(boyNames,boyNames.size()); // Setting the listview
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
