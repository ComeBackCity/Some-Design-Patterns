package Problem2;

public class ShapeNComputer {
    public static void main(String[] args) {

        //Tets Case1
        System.out.println("------1------");
        circle circ = new circle(20);
        pcFactory p = new pcFactory();

        computerFactory com = p.getPC("A");
        circ.display(com.returnResolution());
        circ.perimeter();
        circ.surfaceArea();

        //Test Case2
        System.out.println("\n------2------");
        circle circ2 = new circle(250);

        computerFactory com2 = p.getPC("C");
        circ2.display(com2.returnResolution());
        circ2.perimeter();
        circ2.surfaceArea();

        //Test Case3
        System.out.println("\n------3------");
        square sq = new square(200);

        computerFactory com3 = p.getPC("A");
        sq.display(com3.returnResolution());
        sq.perimeter();
        sq.surfaceArea();

        //Test Case4
        System.out.println("\n------4------");
        rectangle rec = new rectangle(200,175);

        computerFactory com4 = p.getPC("B");
        rec.display(com4.returnResolution());
        rec.perimeter();
        rec.surfaceArea();

        //Test Case 5
        System.out.println("\n------5------");
        triangle t = new triangle(300,200, 400);

        computerFactory com5 = p.getPC("B");
        t.display(com5.returnResolution());
        t.perimeter();
        t.surfaceArea();

    }
}
