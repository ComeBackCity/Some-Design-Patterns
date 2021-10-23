import java.util.Scanner;

public class serverSeice {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        String s;
        //Test case-1 (Premium User)
        System.out.println("Test Case-1: Premium User\n");
        ABCCompany abcCompany = new ABCCompany();
        premiumClients client1 = new premiumClients(abcCompany);

        //Operational to partially down
        abcCompany.setCurrentState(new serverState(1));
        s = sc.nextLine();
        client1.setResponse(s);
        System.out.print("\n");

        //Partially down to fully down
        abcCompany.setCurrentState(new serverState(2));
        System.out.print("\n");

        //Fully down to Partially Down
        abcCompany.setCurrentState(new serverState(1));
        System.out.print("\n");

        //Partially down to operational
        abcCompany.setCurrentState(new serverState(0));
        System.out.print("\n");

        //Operational to Fully Down
        abcCompany.setCurrentState(new serverState(2));
        System.out.print("\n");

        //Fully down to operational
        abcCompany.setCurrentState(new serverState(0));
        System.out.print("\n");


        //Test case-2 (Regular User)
        System.out.println("Test Case-2: Regular User\n");
        abcCompany = new ABCCompany();
        regularClients client2 = new regularClients(abcCompany);

        //Operational to partially down
        abcCompany.setCurrentState(new serverState(1));
        s = sc.nextLine();
        client2.setResponse(s);
        if(s.equalsIgnoreCase("Yes"))
            client2.setHour(5);
        else
            client2.setHour(0);
        System.out.print("\n");

        //Partially down to fully down
        abcCompany.setCurrentState(new serverState(2));
        System.out.print("\n");

        //Fully down to Partially Down
        abcCompany.setCurrentState(new serverState(1));
        System.out.print("\n");

        //Partially down to operational
        abcCompany.setCurrentState(new serverState(0));
        System.out.print("\n");

        //Operational to Fully Down
        abcCompany.setCurrentState(new serverState(2));
        s = sc.nextLine();
        client2.setResponse(s);
        if(s.equalsIgnoreCase("Yes"))
            client2.setHour(7);
        else
            client2.setHour(0);
        System.out.print("\n");

        //Fully down to operational
        abcCompany.setCurrentState(new serverState(0));
        System.out.print("\n");


    }
}
