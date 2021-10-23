package Problem2;

public class square implements shape {
    double length;
    boolean b =false;

    public square(double length) {
        this.length = length;
    }

    @Override
    public void display(resolution r) {
        if (length > r.getLength() || length > r.getBreadth())
            System.out.println("Cannot display");
        else {
            System.out.println("Displaying a square of resolution " + length + "X" + length);
            b = true;
        }
    }

    @Override
    public void perimeter() {
        double perimeter = 4 *length ;
        if (b)
            System.out.println("The perimeter is " + perimeter);
    }

    @Override
    public void surfaceArea() {
        double area = length * length;
        if(b)
            System.out.println("The surface area is " + area);
    }
}
