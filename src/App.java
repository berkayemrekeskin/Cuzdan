import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


public class App extends Application {

    private Person user;
    private Calculations calculations;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            user = new Person("Berkay", 21, 100.2);
            calculations = new Calculations();
            
            setTitles(loader); // Sets titles on app
            setPersonInfo(loader, user); // Sets person info on app
            setTables(loader, calculations); // Sets incomes table on app

            primaryStage.setTitle("Cuzdan App");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    };

    public void setTables(FXMLLoader loader, Calculations calculations)
    {
        @SuppressWarnings("unchecked")
        ListView<String> listView = (ListView<String>) loader.getNamespace().get("MonthlyIncomeTable");
        listView.getItems().clear();
        for(int i = 0; i < calculations.getMonthlyIncomeTable().size(); i++)
        {
            listView.getItems().add(calculations.getMonthlyIncomeTable().get(i));
        }

        @SuppressWarnings("unchecked")
        ListView<String> listView2 = (ListView<String>) loader.getNamespace().get("MonthlyExpenseTable");
        listView2.getItems().clear();
        for(int i = 0; i < calculations.getMonthlyExpenseTable().size(); i++)
        {
            listView2.getItems().add(calculations.getMonthlyExpenseTable().get(i));
        }

    }
    public void setPersonInfo(FXMLLoader loader, Person user)
    {
        TextFlow text = (TextFlow) loader.getNamespace().get("PersonIdentification");
        text.getChildren().clear();
        text.getChildren().add(new Text(user.toString()));
    }
    public void setTitles(FXMLLoader loader)
    {
        TextFlow text = (TextFlow) loader.getNamespace().get("MonthlyIncomes");
        text.getChildren().clear();
        text.getChildren().add(new Text("Monthly Incomes"));

        TextFlow text2 = (TextFlow) loader.getNamespace().get("MonthlyExpenses");
        text2.getChildren().clear();
        text2.getChildren().add(new Text("Monthly Expenses"));
    }
}
    
