package Problem1;

import java.util.LinkedList;
import java.util.Scanner;

public class ShakeShack{

    public static LinkedList<shake> orderList = new LinkedList<shake>();
    public static LinkedList<Integer> priceList = new LinkedList<>();
    String name, top;
    Director dir = new Director();
    Boolean b ;
    Scanner sc = new Scanner(System.in);
    int tp;
    int finalTotal=0;


    public static void main(String[] args) {


        ShakeShack obj = new ShakeShack();

        obj.open();
        reqFunctions.showShake();
        obj.takeShakeInput();


    }

    public void open(){
        System.out.println("Press O to open an order and E to close it. Make sure to order at least one item.");


        String s = sc.nextLine();
        while (!s.equals("O"))
        {
            System.out.println("ERROR! Try again");
            s = sc.nextLine();
        }
    }

    public void takeShakeInput()
    {
        String s =sc.nextLine();
        if (s.equals("E")){
            if(orderList.size()==0)
            {
                System.out.println("Please add 1 item");
                takeShakeInput();
            }
            else {
            for (int i=0; i<orderList.size(); i++) {
                orderList.get(i).show();
                finalTotal+=priceList.get(i);
            }

                System.out.println("Total\t\t\t"+finalTotal);
            return;
            }

        }
        else if (s.equals("1")){
            name = "Chocolate";
            reqFunctions.lactoseFree();
            lactose();

        }
        else if (s.equals("2")){
            name = "Coffee";
            reqFunctions.lactoseFree();
            lactose();

        }
        else if (s.equals("3")){
            name = "Strawberry";
            reqFunctions.lactoseFree();
            lactose();

        }
        else if (s.equals("4")){
            name = "Vanilla";
            reqFunctions.lactoseFree();
            lactose();

        }
        else if (s.equals("5")){
            name = "Zero";
            reqFunctions.lactoseFree();
            lactose();

        }
        else if(s.equals("O")){
            System.out.println("Please add to current order");
            takeShakeInput();

        }
        else {
            System.out.println("Enter valid option");
            takeShakeInput();
        }


    }

    public void lactose(){

        String s = sc.nextLine();
        if (s.equals("E")){
            compare(name,"none",0,false);

            for (int i=0; i<orderList.size(); i++) {
                orderList.get(i).show();
                finalTotal+=priceList.get(i);
            }

            System.out.println("Total\t\t\t"+finalTotal);

            return;

        }
        else if (s.equals("1")){
            b = true;
            reqFunctions.toppings();
            addToppings();
        }
        else if(s.equals("2")){
            b = false;
            reqFunctions.toppings();
            addToppings();
        }
        else if(s.equals("O")){
            System.out.println("Do you want to add to current order?(Y/N)");
            s = sc.nextLine();
            if(s.equalsIgnoreCase("Y"))
                lactose();
            else {
                compare(name,"none",0,false);
                reqFunctions.showShake();
                takeShakeInput();
            }
        }
        else {
            System.out.println("Enter valid option");
            lactose();
        }

    }


    public void addToppings(){
        String s = sc.nextLine();
        if (s.equals("E")){
            compare(name, "none", 0, b);
            for (int i=0; i<orderList.size(); i++) {
                orderList.get(i).show();
                finalTotal+=priceList.get(i);
            }

            System.out.println("Total\t\t\t"+finalTotal);

            return;

        }

        else if(s.equals("1")){
            top = "none";
            tp = 0;
            compare(name,top,tp,b);
        }

        else if(s.equals("2")){
            top = "Candy";
            tp = 50;
            compare(name,top,tp,b);
        }

        else if(s.equals("3")){
            top = "Cookies";
            tp = 40;
            compare(name,top,tp,b);
        }

        else if(s.equals("O")){
            System.out.println("Do you want to add to current order?(Y/N)");
            s = sc.nextLine();
            if(s.equalsIgnoreCase("Y"))
                addToppings();
            else {
                compare(name, "none", 0, b);
                reqFunctions.showShake();
                takeShakeInput();
            }

        }
        else {
            System.out.println("Enter valid option");
            addToppings();
        }

        System.out.println("Use E to exit or C to continue");
        s = sc.nextLine();
        if (s.equals("E"))
        {
            for (int i=0; i<orderList.size(); i++) {
                orderList.get(i).show();
                finalTotal+=priceList.get(i);
            }

            System.out.println("Total\t\t\t"+finalTotal);
            return;
        }
        else if(s.equals("C"))
        {
            reqFunctions.showShake();
            takeShakeInput();
        }

    }

    public void compare(String s, String top, int price,boolean b){
        if(name.equals("Chocolate")){
            shakeBuilder sb = new chocolateShake(b,top,price);
            dir.construct(sb);
            shake Shake = sb.getShake();
            orderList.addLast(Shake);
            priceList.addLast(Shake.getPrice());
        }
        else if(name.equals("Coffee")){
            shakeBuilder sb = new coffeeShake(b,top,price);
            dir.construct(sb);
            shake Shake = sb.getShake();
            orderList.addLast(Shake);
            priceList.addLast(Shake.getPrice());
        }
        else if(name.equals("Strawberry")){
            shakeBuilder sb = new strawberryShake(b,top,price);
            dir.construct(sb);
            shake Shake = sb.getShake();
            orderList.addLast(Shake);
            priceList.addLast(Shake.getPrice());
        }
        else if(name.equals("Vanilla")){
            shakeBuilder sb = new VanillaShake(b,top,price);
            dir.construct(sb);
            shake Shake = sb.getShake();
            orderList.addLast(Shake);
            priceList.addLast(Shake.getPrice());
        }
        else if(name.equals("Zero")){
            shakeBuilder sb = new zeroShake(b,top,price);
            dir.construct(sb);
            shake Shake = sb.getShake();
            orderList.addLast(Shake);
            priceList.addLast(Shake.getPrice());
        }
    }




}
