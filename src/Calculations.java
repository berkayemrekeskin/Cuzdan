import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

enum Month {
    Jan,
    Feb,
    Mar,
    Apr,
    May,
    Jun,
    Jul,
    Aug,
    Sep,
    Oct,
    Nov,
    Dec
}

public class Calculations {
    
    
    private List<Double[]> dailyIncomes;
    private List<Double[]> dailyExpenses;

    private List<Double> monthlyIncomes;
    private List<Double> monthlyExpenses;

    private List<String> TableForMonthlyIncomes;
    private List<String> TableForMonthlyExpenses;

    public Calculations()
    {

        String incomePath = "C:\\Users\\Berkay\\eclipse-workspace\\Cüzdan\\cuzdan\\Incomes & Expenses\\Incomes.txt";
        String expensePath = "C:\\Users\\Berkay\\eclipse-workspace\\Cüzdan\\cuzdan\\Incomes & Expenses\\Expenses.txt";
        this.dailyIncomes = new ArrayList<>();
        this.dailyExpenses = new ArrayList<>();
        this.monthlyIncomes = new Vector<>();   
        this.monthlyExpenses = new Vector<>();
        this.TableForMonthlyIncomes = new Vector<>();
        this.TableForMonthlyExpenses = new Vector<>();

        // Read incomes & add to dailyIncomes
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(incomePath))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int monthIndex = 0;
                double monthlyTotalIncome = 0.0;
                String[] elements = line.split(",");
                Double[] doubleElements = new Double[elements.length - 1];
                for(int i = 1; i < elements.length; i++)
                {
                    try
                    {
                        double gridElement = Double.parseDouble(elements[i]);
                        doubleElements[i-1] = gridElement;
                        monthlyTotalIncome += gridElement;
                    }
                    catch(NumberFormatException e)
                    {
                        e.getMessage();
                    }
                }
                this.monthlyIncomes.add(monthlyTotalIncome);
                this.dailyIncomes.add(doubleElements);
                this.TableForMonthlyIncomes.add(elements[monthIndex++] + " = " + monthlyTotalIncome + " TL\n");
            }
            bufferedReader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        // Read expenses & add to dailyExpenses
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(expensePath))) {
                
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int monthIndex = 0;
                double monthlyTotalIncome = 0.0;
                String[] elements = line.split(",");
                Double[] doubleElements = new Double[elements.length - 1];

                for(int i = 1; i < elements.length; i++)
                {
                    try
                    {
                        double gridElement = Double.parseDouble(elements[i]);
                        doubleElements[i-1] = gridElement;
                        monthlyTotalIncome += gridElement;
                    }
                    catch(NumberFormatException e)
                    {
                        e.getMessage();
                    }
                }
                this.monthlyExpenses.add(monthlyTotalIncome);
                this.dailyExpenses.add(doubleElements);
                this.TableForMonthlyExpenses.add(elements[monthIndex++] + " = " + monthlyTotalIncome + " TL\n");
            }
            bufferedReader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Double> getMonthlyIncomes()
    {
        return this.monthlyIncomes;
    }
    public List<Double> getMonthlyExpenses()
    {
        return this.monthlyExpenses;
    }
    public List<String> getMonthlyIncomeTable()
    {
        return this.TableForMonthlyIncomes;
    }
    public List<String> getMonthlyExpenseTable()
    {
        return this.TableForMonthlyExpenses;
    }
}