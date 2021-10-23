package Problem2;

public class rectangle implements shape {

    double length;
    double breadth;
    boolean b = false;

    public rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public void display(resolution r) {
        if (length > r.getLength() || breadth > r.getBreadth())
            System.out.println("Cannot display");
        else {
            System.out.println("Displaying a rectangle of size " + length + "X" + breadth);
            b = true;
        }
    }

    @Override
    public void perimeter() {
        double perimeter = 2 * (length+breadth);
        if(b)
            System.out.println("The perimeter is " + perimeter);
    }

    @Override
    public void surfaceArea() {
        double area = length * breadth ;
        if(b)
            System.out.println("The surface area is " + area);

    }
}
