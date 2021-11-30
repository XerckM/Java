public class Employee extends Person {
    private double payRate;
    private double hoursWorked;
    private String department;  
    public final int HOURS = 40;
    public final double OVERTIME = 1.5; 
    // default constructor
    public Employee() {
        super();
        payRate = 0;
        hoursWorked = 0;
        department = "";
    }   
    // add an alternate constructor with parameters
    public Employee(String firstName, String lastName, double payRate, double hoursWorked, String department) {
        super(firstName, lastName);
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.department = department;
    }   
    public String toString() {
        // should return a String like this:
        // The wages for xxxx from the xxxx department are: $xxxxx.xx"
        return "The wages for " + super.toString() + " from the " + department + " department are: " + calculatePay();
    }   
    public void print() {
        // Should print output like this (same line):
        // The employee xxxx from the xxxx department worked xx hours
        // with a pay rate of $xxx.xx. The wages for this employee are $xxxxx.xx
        System.out.println("The employee " + super.toString() + " from the " + department + " department worked "
                + hoursWorked + " hours with a pay rate of $" + String.format("%.2f", payRate)
                + ". The wages for this employee are $" + String.format("%.2f", calculatePay()));
    }   
    public double calculatePay() {
        // Method to calculate and return the wages
        // handle both regular and overtime pay
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        } else {
            return (40 * payRate) + ((hoursWorked - 40) * OVERTIME * payRate);
        }
    }   
    public void setAll(String first, String last, double rate, double hours, String dep) {
        setName(first, last);
        this.payRate = rate;
        this.hoursWorked = hours;
        this.department = dep;
    }   
    public double getPayRate() {
        return payRate;
    }   
    public double getHoursWorked() {
        return hoursWorked;
    }   
    public String getDepartment() {
        return department;
    }   
    public boolean equals(Object o) {
        Employee e = (Employee) o;
        return super.equals(e) && hoursWorked == e.hoursWorked && payRate == e.payRate
            && department.equalsIgnoreCase(e.department);
    }   
    public Employee getCopy() {
        Employee e = new Employee();
        copy(e);
        return e;
    }   
    public void copy(Employee e) {
        e.setAll(getFirstName(), getLastName(), getPayRate(), getHoursWorked(), getDepartment());
    }

}