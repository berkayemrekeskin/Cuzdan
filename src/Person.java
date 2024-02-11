public class Person {

    private String name;
    private int age;
    private double monthlySalary;

    public Person(String name, int age, double monthlySalary) {
        this.name = name;
        this.age = age;
        this.monthlySalary = monthlySalary;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setMonthlySalary(double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }
    public double getMonthlySalary()
    {
        return this.monthlySalary;
    }
    @Override 
    public String toString()
    {
        String str = "PERSONAL INFO\n";
        str += "Name: " + name + "\n" + "Age: " + age + "\n" + "Monthly Salary: " + this.monthlySalary;
        return str;
    }
}