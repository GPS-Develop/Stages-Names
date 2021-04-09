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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RankingController {

    final int MIN_BABY_YEARS = 2010;
    final int MAX_BABY_YEARS = 2018;

    @FXML
    private TextField yearTextField;

    @FXML
    private TextField genderTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button MainMenuButton;

    @FXML
    private Button submitQueryButton;

    @FXML
    void submitQueryClicked(ActionEvent event){ // Shows a new stage with the results and option to try again or exit
        // CORE LOGIC------------------------------------------------
        String tempText;
        String filePath = System.getProperty("user.dir") + File.separator + "src/WS7/babynames/" +"babynamesranking"
                + yearTextField.getText() + ".txt";
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No record for " + yearTextField.getText());
            System.exit(1);
        }

        int rank = 0;
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {

                String s = read.nextLine();
                String[] temp = s.trim().split("\\s+"); // Ignores White Spaces
//                System.out.println(temp[0] + " - " + temp[1]);
                if (genderTextField.getText().equalsIgnoreCase("M") &&
                        temp[1].toLowerCase().equals(nameTextField.getText().toLowerCase())) {
                    rank = Integer.valueOf(temp[0]);
                    break;
//                    System.out.println("MALE");
                }else if (genderTextField.getText().equalsIgnoreCase("F") &&
                        temp[3].toLowerCase().equals(nameTextField.getText().toLowerCase())) {
                    rank = Integer.valueOf(temp[0]);
                    break;
                }else if (!(genderTextField.getText().equalsIgnoreCase("M")) &&
                        !(genderTextField.getText().equalsIgnoreCase("F"))){
                    rank = -1;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (rank == 0) {
        tempText = "The name "+nameTextField.getText()+" is not ranked in year " + yearTextField.getText();
        }else if(rank == -1){
            tempText = "Invalid Fields Please try again";
        }else {
            tempText = nameTextField.getText()+" is ranked #"+rank+" in year "+ yearTextField.getText();
        }

        //END OF CORE LOGIC------------------------------------------------

        Stage primaryStage = (Stage) submitQueryButton.getScene().getWindow();
        primaryStage.close(); // Closes the old stage

         //Loading new Stage
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WS7/resources/results.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            ResultsController resultsController = (ResultsController) loader.getController();
            resultsController.resultLabel(tempText); // Sets the tempText to the new stage
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void MainMenuClicked(ActionEvent event) {
        Stage primaryStage = (Stage) MainMenuButton.getScene().getWindow();
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


}
