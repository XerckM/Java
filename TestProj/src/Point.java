public class Point{
    private int x;
    private int y;
    public Point (){
        x = 0;
        y = 0;
    }
    public Point(int x1, int y1){
        x = x1;
        y = y1;
    }
    public void set(int x1, int y1){
        x = ((x1 < 0) ? 0: x1);
        y = ((y1 < 0) ? 0: y1);
    }
    public void print(){
        System.out.print("(" + x + ", " + y + ")");
    }
    public String toString(){
        return ("(" + x + ", " + y + ")");
    }
    public boolean equals(Point otherPoint){
        return ((otherPoint.x == x) && (otherPoint.y == y));
    }
    public void copy(Point otherPoint){
        x = otherPoint.x;
        y = otherPoint.y;
    }
    public Point getCopy(){
        return new Point(x, y);
    }
    public double distanceFromOrigin(){
        return Math.sqrt(x * x + y * y);
    }
    public double distance(Point otherPoint){
        return Math.sqrt((x - otherPoint.x) * (x - otherPoint.x) + 
        (y - otherPoint.y) * (y - otherPoint.y));
    }
    public void translate(int xShift, int yShift){
        x += xShift;
        y += yShift;
    }
    public boolean isHorizontal(Point otherPoint){
        return y == otherPoint.y;
    }
    public boolean isVertical(Point otherPoint){
        return x == otherPoint.x;
    }
    public double slope(Point otherPoint){
        double xChange = (x - otherPoint.x);
        double yChange = (y - otherPoint.y);
        return yChange / xChange;
    }
}