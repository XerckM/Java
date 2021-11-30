public class Cylinder extends CircularShapeWithHeight {
    public Cylinder() {
        super();
    }
    public Cylinder(double radius, double height){
        super(radius, height);
    }
    public double getArea() {  
        return getCrossSectionPerimeter() * getHeight() + 2 * getCrossSectionArea();
    }
    public double getVolume() {
        return getCrossSectionArea() * getHeight();
    }
    public String toString() {
        return "For this cylinder the radius = " + getRadius() + " and the height = " + getHeight();
    }
    public boolean equals(Object obj){
        Cylinder pObj;
        if (obj instanceof SquarePyramid)
            pObj = (Cylinder)obj;
        else
            return false;
        if (this.getRadius() == pObj.getRadius() &&
            this.getHeight() == pObj.getHeight() )
            return true;
        else
            return false;
    }
}