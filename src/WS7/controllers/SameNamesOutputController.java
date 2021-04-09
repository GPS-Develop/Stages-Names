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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SameNamesOutputController {

    @FXML
    private ListView resultsListView;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button searchAgainButton;

    // Displays the results
    public void initializeResults(ArrayList<String> sameNames, int size){
        resultsListView.getItems().add(size + " names matched your query");
        resultsListView.getItems().add("---------------------------------");
        sameNames.forEach((name) -> {
           resultsListView.getItems().add(name);
        });
    }

    public void searchAgainClicked(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) searchAgainButton.getScene().getWindow();
        primaryStage.close(); // closes the results stage
        try { // loads the ranking stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WS7/resources/sameNames.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void mainMenuClicked(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) mainMenuButton.getScene().getWindow();
        primaryStage.close(); // closes the results stage
        try { // loads the ranking stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WS7/resources/MainMenu.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
