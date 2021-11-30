public abstract class CircularShape implements Shape3D {
    private double radius;
    public CircularShape() {
        this.radius = 0;
    }
    public CircularShape(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public double getDiameter(){
        return 2 * this.radius;
    }
    public double getCrossSectionArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double getCrossSectionPerimeter(){
        return 2 * Math.PI * radius;
    }
}