public class RectangularPrism implements Shape3D {  
    private double length;
    private double width;
    private double height;

    public RectangularPrism() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }   
    public RectangularPrism(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }   
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }   
    public double getHeight() {
        return height;
    }
    public double getArea() {
        return 2 * (width * length + height * length + height * width);
    }
    public double getVolume() {
        return length * width * height;
    }
    public String toString() {
        return "For this rectangular prism the base has the length = " + length + " and the width = " + width+ "\nThe height of the prism = " + height;
    }
    public boolean equals(Object obj){
        RectangularPrism pObj;
        if (obj instanceof SquarePyramid)
            pObj = (RectangularPrism)obj;
        else
            return false;   
        if (this.length == pObj.length && this.width == pObj.width && this.height == pObj.height)
            return true;
        else
            return false;
    }
}