import java.util.Scanner;

public class ClientEmployee {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        String prompt="Enter employee pay rate: ";
        String prompt2="Enter employee hours worked: ";
        String last, first, dept;
        double payRate, hours;
        Employee prof = new Employee("John", "Doe", 25.50, 50, "COSC");
        Employee newEmp = new Employee();
        System.out.println("Enter employee last name: ");
        last = in.next();
        System.out.println("Enter employee first name: ");
        first = in.next();
        System.out.println("Enter department: ");
        dept = in.next();
        payRate = getDouble(in, prompt);
        hours = getDouble(in, prompt2);
        newEmp.setAll(first,last,payRate,hours,dept);
        System.out.println("--- Record for both employees with overridden .toString from subclass ---");
        System.out.println(prof+"\n" + newEmp);
        System.out.println("--- Output with calls to overridden method print from subclass ---");
        prof.print();
        System.out.println();
        newEmp.print();
        System.out.println();
        System.out.println("--- Call to overridden equals/subclass for 2 Employee objects---");
        System.out.println(prof.equals(newEmp)?"These two employees have the same record.":"Couldn't find an employee with same record.");
        newEmp.copy(prof);
        System.out.println("After call to copy:");
        System.out.println(prof.equals(newEmp)?"These two employees have the same record.":"Couldn't find an employee with same record.");
    }
    public static double getDouble(Scanner in, String prompt){
        System.out.println(prompt);
        while(!in.hasNextDouble()){
          in.next();
          System.out.println("Not a double, try again:");
        }
        return in.nextDouble();
    }
}