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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultsController {

    @FXML
    private Label resultLabel;
    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    void noClicked(ActionEvent event) { // Closes the stage
        Stage stage = (Stage) noButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void yesClicked(ActionEvent event) {
        Stage primaryStage = (Stage) yesButton.getScene().getWindow();
        primaryStage.close(); // closes the results stage
        try { // loads the ranking stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WS7/resources/ranking.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void resultLabel(String tempText) { // sets the result label text
        resultLabel.setText(tempText);

    }
}
