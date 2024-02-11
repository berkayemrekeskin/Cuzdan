import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private Button AddExpenseButton;

    @FXML
    private Button AddIncomeButton;

    @FXML
    private ListView<String> MonthlyExpenseTable;

    @FXML
    private TextFlow MonthlyExpenses;

    @FXML
    private ListView<String> MonthlyIncomeTable;

    @FXML
    private TextFlow MonthlyIncomes;

    @FXML
    private TextFlow PersonIdentification;

    @FXML
    void ExpenseButtonClick(ActionEvent event) {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddExpenseScene.fxml"));
            Parent root1 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cuzdan App");
            stage.setScene(new Scene(root1));
            stage.show();    
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
    @FXML
    void IncomeButtonClick(ActionEvent event) {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddIncomeScene.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cuzdan App");
            stage.setScene(new Scene(root2));
            stage.show();  
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }

}
