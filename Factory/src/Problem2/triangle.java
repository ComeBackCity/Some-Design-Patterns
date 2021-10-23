package Problem2;

public class triangle implements shape {
    double a;
    double b;
    double c;
    double _2s;
    boolean bool = false;

    public triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        _2s = a + b + c;
    }

    @Override
    public void display(resolution r) {
        double ar = area();
        double h1 = 2 * ar / a ;
        double h2 = 2 * ar / b ;
        double h3 = 2 * ar / c ;

        if (a > r.getLength() || h1 > r.getBreadth()) {
            if (b > r.getLength() || h2 > r.getBreadth()) {
                if (c > r.getLength() || h3 > r.getBreadth())
                    System.out.println("Cannot display");
                else {
                    System.out.println("Displaying a triangle of resolution " + c + "X" + Math.round(h3));
                    bool = true;
                }
            } else {
                System.out.println("Displaying a triangle of resolution " + b + "X" + Math.round(h2));
                bool = true;
            }
        }
        else{
            System.out.println("Displaying a triangle of resolution " + a + "X" + Math.round(h1));
            bool = true;
        }
    }

    @Override
    public void perimeter() {
        System.out.println("The perimeter is " + _2s);
    }

    @Override
    public void surfaceArea() {
        double s = _2s / 2;
        double area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
        System.out.println("The surface area is " + area);
    }

    double area(){
        double s = _2s / 2;
        double area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
        return area;
    }
}
