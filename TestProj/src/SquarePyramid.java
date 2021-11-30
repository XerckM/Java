public class SquarePyramid implements Shape3D {
    private double length;
    private double height;  

    public SquarePyramid(){
        this.length = 0;
        this.height = 0;
    }   
    public SquarePyramid(double length, double height)
    {
        this.length = length;
        this.height = height;
    }
    public double getLength(){
        return this.length;
    }
    public double getHeight(){
        return this.height;
    }
    public double getArea() {
        return length * (length + Math.sqrt(length * length + 4 * height * height));
    }
    public double getVolume() {
        return length * length * height / 3.0;
    }
    public String toString(){
        return "For this square pyramid the base has the length = " + length + " and the height = " + height;
    }
    public boolean equals(Object obj){
        SquarePyramid pObj;
        if (obj instanceof SquarePyramid)
            pObj = (SquarePyramid)obj;
        else
            return false;
        if (this.length == pObj.length && this.height == pObj.height)
            return true;
        else
            return false;
    }   
}