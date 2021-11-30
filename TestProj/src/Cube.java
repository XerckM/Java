public class Cube extends RectangularPrism {
    public Cube() {
       super();
    }
    public Cube(double side) {
       super(side, side,side);
    }
    public String toString() {
       String text = "For this cube all sides = ";
       text += super.getWidth();
       return text;
    }
}