/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17march14calculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author JWright
 */
public class W17March14Calculator extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        //This will create an object that can load our FXML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CalculatorView.fxml"));
        
        AnchorPane calculatorPane = loader.load();
        
        Scene scene = new Scene(calculatorPane);
        
        primaryStage.setTitle("My awesome calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
