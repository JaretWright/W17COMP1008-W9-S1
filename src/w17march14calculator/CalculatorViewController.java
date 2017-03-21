
package w17march14calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML private Label historyLabel;
    
    private ArrayList<String> numberStack;
    
    /**
     * This method will update the display with the number
     * button pushed
     */
    public void numberButtonPushed(ActionEvent event)
    {
        String buttonValue = ((Button)event.getSource()).getText();
        String originalDisplay = display.getText();
        
        if (originalDisplay.contains(".") && buttonValue.equals("."))
        {}  //do nothing
        else
        {
            if (originalDisplay.equals("0") && !buttonValue.equals("."))
                display.setText(buttonValue);
            else
                display.setText(originalDisplay + buttonValue);
        }
        
        
    }

    public void operationButtonPushed(ActionEvent event)
    {
        String operator = ((Button)event.getSource()).getText();
        
        numberStack.add(display.getText());
        numberStack.add(operator);
        
        historyLabel.setText(formatNumberStack());
    }
    
    /**
     * This method will return the contents of the numberStack
     * as a String
     */
    public String formatNumberStack()
    {
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        display.setText("0");
        historyLabel.setText("");
        numberStack = new ArrayList();
    }    
    
}
