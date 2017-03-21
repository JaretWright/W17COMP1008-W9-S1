
package w17march14calculator;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class CalculatorViewController implements Initializable {
    
    @FXML private Button oneButton;
    @FXML private Button twoButton;
    @FXML private Button threeButton;
    @FXML private Button fourButton;
    @FXML private Button fiveButton;
    @FXML private Button sixButton;
    @FXML private Button sevenButton;
    @FXML private Button eightButton;
    @FXML private Button nineButton;
    @FXML private Button zeroButton;
    @FXML private Button decimalButton;
    @FXML private Button plusButton;
    @FXML private Button minusButton;
    @FXML private Button multiplyButton;
    @FXML private Button divideButton;
    @FXML private Button equalsButton;
    @FXML private TextField display;
    
    private double firstNumber;
    
    /**
     * This method will update the display with the number
     * button pushed
     */
    public void numberButtonPushed(ActionEvent event)
    {
        String buttonValue = ((Button)event.getSource()).getText();
        String originalDisplay = display.getText();
        
        if (originalDisplay.equals("0"))
            display.setText(buttonValue);
        else
            display.setText(originalDisplay + buttonValue);
    }

    public void operationButtonPushed(ActionEvent event)
    {
        String operator = ((Button)event.getSource()).getText();
        
        if (firstNumber == 0)
        {
            firstNumber = Double.parseDouble(display.getText());
            display.setText("0");    
        }
        else
        {
            double secondNumber = Double.parseDouble(display.getText());
//          double result = calculate(first, second, operator);  
            
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        display.setText("0");
    }    
    
}
