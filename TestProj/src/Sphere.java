public class Sphere implements Shape3D {
    private double radius;  
    public Sphere() {
        this.radius = 0;
    }
    public Sphere(double r) {
        this.radius = r;
    }
    public double getArea() {
        return 4.0 * Math.PI * radius * radius;
    }   
    public double getVolume() {
        return 4.0 * Math.PI * Math.pow(radius, 3) / 3.0;   
    }   
    public double getRadius() {
        return radius;
    }
    public String toString() {
        return "The radius of this sphere = " + radius;
    }
    public boolean equals(Object obj) {
       Sphere pObj;
        if (obj instanceof Sphere)
            pObj = (Sphere)obj;
        else
            return false;
        if (this.radius == pObj.radius)
            return true;
        else
            return false;
    }
}