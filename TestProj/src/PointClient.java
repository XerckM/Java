import java.util.*;

public class PointClient{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        Point p1 = new Point();
        Point p2 = new Point(7, 13);
        Point p3 = new Point(7, 15);
        String promptX = "Enter the x-coordinate for first point: ";
        String promptY = "Enter the y-coordinate for first point: ";

        System.out.println("First point is " + p1.toString());
        System.out.println("Second point is " + p2.toString());
        System.out.println("Third point is " + p3.toString());

        System.out.println("Second point " + p2.toString() + " lines up vertically with third point " + p3.toString());
        System.out.println("Second point " + p2.toString() + " doesn't line up horizontally with third point " + p3.toString());
        
        int point1 = getInt(in, promptX);
        while(point1 < 0){
            System.out.print("ERROR! Should be positive. ");
            point1 = getInt(in, promptX);
        }
        int point2 = getInt(in, promptY);
        while(point2 < 0){
            System.out.print("ERROR! Should be positive. ");
            point2 = getInt(in, promptY);
        }


        p1.set(point1, point2);
        System.out.println("First point (after call to set) is " + p1.toString());
        System.out.printf("Distance from origin for first point = %.02f\n", p1.distanceFromOrigin());
        System.out.printf("Distance from origin for second point = %.02f\n", p2.distanceFromOrigin());
        System.out.printf("Distance from first point and second point = %.02f\n", p1.distance(p2));

        p1.translate(5, 10);
        System.out.println("First point (after call to translate (5, 10)) is " + p1.toString());

        p2.translate(15, 5);
        System.out.println("Second point (after call to translate (15, 5)) is " + p2.toString());

        if(p1.equals(p2) == false){
            System.out.println("---Call to equals: The 2 points are NOT equal.");
        }
        else{
            System.out.println("---Call to equals: The 2 points are equal.");
        }

        System.out.println("---Calls to copy and print--- ");
        p2.copy(p1);
        System.out.print("First Point (after call to copy) is " );
        p1.print();
        System.out.println();
        System.out.print("Second Point (after call to copy) is ");
        p2.print();
        System.out.println();

        if(p1.equals(p2) == false){
            System.out.println("---Call to equals after call to copy: The 2 points are NOT equal.");
        }
        else{
            System.out.println("---Call to equals after call to copy: The 2 points are equal.");
        }
    }
    public static int getInt(Scanner input, String prompt){
        System.out.print(prompt);        
        while(!input.hasNextInt())
        {
          input.next();
          System.out.print("Not an integer! Try again! " + prompt);
        }
        return input.nextInt();
    }
}