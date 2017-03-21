
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
    private boolean overwriteDisplay, resultShowing;
    
    /**
     * This method will update the display with the number
     * button pushed
     */
    public void numberButtonPushed(ActionEvent event)
    {
        String buttonValue = ((Button)event.getSource()).getText();
        String originalDisplay = display.getText();
        resultShowing = false;
        
        if (originalDisplay.contains(".") && buttonValue.equals("."))
        {}  //do nothing
        else
        {
            if (overwriteDisplay && !buttonValue.equals("."))
            {
                display.setText(buttonValue);
                overwriteDisplay = false;
            }
            else
                display.setText(originalDisplay + buttonValue);
        }
        
        
    }

    public void operationButtonPushed(ActionEvent event)
    {
        String operator = ((Button)event.getSource()).getText();
         
        //if it is an operator in the final position, change the operator in the stack
        //and update the history label
        if (checkIfLastElementAnOperator() && resultShowing)
        {
            numberStack.remove(numberStack.size()-1);
            numberStack.add(operator);
        }
        else
        {
            numberStack.add(display.getText());
            numberStack.add(operator);
        }
            
        historyLabel.setText(formatNumberStack());
        overwriteDisplay = true;
        resultShowing = true;
        
        display.setText(Double.toString(calculateStack()));
    }
    
    public boolean checkIfLastElementAnOperator()
    {
        if (!numberStack.isEmpty())
        {
            String lastElement = numberStack.get(numberStack.size()-1);
        
            //change the last element in the arraylist
            return (!lastElement.matches("[0-9]"));
        }
        return false;
    }
    
    /**
     * This method will parse the ArrayList called numberStack and call
     * the calculate method for each operator and number
     */
    public double calculateStack()
    {
        double result =0;
        double num1 = 0;
        
        //make sure there are numbers and operators in the stack
        if (!numberStack.isEmpty())
        {
            num1 = Double.parseDouble(numberStack.get(0));
            double num2;
            String operator = "=";
            
            for (int i=1; i<numberStack.size() ; i++)
            {
                String element = numberStack.get(i);
                
                //check if the element is a number or an operator
                if (element.matches("[0-9.]"))
                {
                    num2 = Double.parseDouble(element);
                    result = calculate(num1, operator, num2);
                    num1 = result;
                }
                else
                {
                    operator = element;
                }
            }
        }
        
        return result;
    }
    
    
    /**
     * This method accepts 2 numbers and performs the math between them based
     * on the operator
     */
    public double calculate(double num1, String operator, double num2)
    {
        if (operator.equals("+"))
            return num1+num2;
        if (operator.equals("*"))
            return num1*num2;
        if (operator.equals("/"))
            return num1/num2;
        if (operator.equals("-"))
            return num1-num2;
        return 0;
    }
    
    
    
    /**
     * This method will return the contents of the numberStack
     * as a String
     */
    public String formatNumberStack()
    {
        String formattedOutput = "";
        
        for (String element:numberStack)
        {
            formattedOutput += element;
        }
        return formattedOutput;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        display.setText("0");
        historyLabel.setText("");
        numberStack = new ArrayList();
        overwriteDisplay = true;
        resultShowing=true;
    }    
    
}
