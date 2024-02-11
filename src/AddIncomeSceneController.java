import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddIncomeSceneController {

    @FXML
    private TextField EnterAmountTextField;

    @FXML
    private TextField EnterMonthTextField;

    @FXML
    private Button SubmitButton;

    String month;
    double amount;

    @FXML
    void SubmitButtonClick(ActionEvent event) throws Exception {
        try
        {
            month = EnterMonthTextField.getText();
            if(month == null)
            {
                throw new Exception("Month is not entered!");
            }
            amount = Double.parseDouble(EnterAmountTextField.getText());
            
            String incomePath = "C:\\Users\\Berkay\\eclipse-workspace\\Cüzdan\\cuzdan\\Incomes & Expenses\\Incomes.txt";
            String newIncome = month + "," + amount;
            List<String> monthlyIncomes = new ArrayList<>();

            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(incomePath)))
            {
                String line;
                int i = 0;
                int monthIndex = -1;
                while((line = bufferedReader.readLine()) != null)
                {
                    String[] elements = line.split(",");
                    if(this.month == elements[0])
                    {
                        monthIndex = i;
                    }
                    monthlyIncomes.add(line);
                    i++;
                }
                if(monthIndex != -1)
                {
                    monthlyIncomes.set(monthIndex,newIncome);
                }
                else
                {
                    throw new Exception("Invalid Month Name!");
                }
                bufferedReader.close();
            } catch(Exception e)
            {
                e.getMessage();
            }
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(incomePath)))
            {
                for(String line : monthlyIncomes)
                {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch(Exception e)
            {
                e.getMessage();
            }
        }
        catch(Exception e)
        {
            // Pop-up Message box yapılabilir
            e.getMessage();
        }
    }

}
