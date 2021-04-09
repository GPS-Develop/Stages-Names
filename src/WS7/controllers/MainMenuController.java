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

public class MainMenuController {

    @FXML
    private Button searchByNamesButton;

    @FXML
    private Button searchByFileButton;

    @FXML
    private Button exitButton;

    @FXML
    void searchByFileClicked(ActionEvent event) {
        Stage primaryStage = (Stage) searchByFileButton.getScene().getWindow();
        primaryStage.close(); // Closes the old stage
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WS7/resources/sameNames.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void searchByNamesClicked(ActionEvent event) {
        Stage primaryStage = (Stage) searchByNamesButton.getScene().getWindow();
        primaryStage.close(); // Closes the old stage
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WS7/resources/ranking.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void exitButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close(); // Closes the stage
    }
}
