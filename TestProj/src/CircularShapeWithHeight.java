public abstract class CircularShapeWithHeight extends CircularShape {
    private double height;
    public CircularShapeWithHeight() {
        super();
        this.height = 0;
    }
    public CircularShapeWithHeight(double radius, double height){
        super(radius);
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
}