package Problem2;

public class circle implements shape {
    double radius;
    double pi = 3.1416;
    boolean b = false;


    public circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void display(resolution r) {
        if (radius * 2 > r.getLength() || radius * 2 > r.getBreadth())
            System.out.println("Cannot display");
        else {
            System.out.println("This is the circle of resolution " + radius * 2 + "X" + radius * 2);
            b = true;
        }
    }

    @Override
    public void perimeter() {
        double perimeter = 2 * pi * radius;
        if (b)
            System.out.println("The perimeter is " + perimeter);
    }

    @Override
    public void surfaceArea() {
        double area = pi * radius * radius;
        if (b)
            System.out.println("The surface area is " + area);
    }
}
