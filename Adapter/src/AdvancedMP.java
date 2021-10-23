import javafx.scene.transform.Scale;

import java.util.Scanner;
import java.util.Vector;

public class AdvancedMP {

    static AudioPlayer a = new AudioPlayer();
    static Vector<mediaFile> mediaFilevector = new Vector<>();
    static boolean playing = false;
    static Scanner sc = new Scanner(System.in);
    static String s, name, fileFormat;
    static int min,sec, i=0;
    static double size;
    static int elapsed = 0, total = 0;

    static void playlist(){
        System.out.println("Add a new playlist");
        System.out.println("Press D to start adding");
        s = sc.nextLine();
        i = 0;
        elapsed = 0;
        total = 0;
        mediaFilevector.clear();
        //playing = true;
        while (!s.equalsIgnoreCase("s"))
        {
            System.out.println("Enter File name");
            name = sc.nextLine();
            System.out.println("Enter File format");
            fileFormat = sc.nextLine();
            System.out.println("Enter Duration ");
            min =  sc.nextInt();
            sec = sc.nextInt();
            System.out.println("Enter Size");
            size = sc.nextDouble();
            mediaFilevector.add(new mediaFile(name, new time(min,sec), fileFormat, size));
            System.out.println("Press S to stop adding or ENTER to continue");
            s = sc.nextLine();
            s = sc.nextLine();
            //System.out.println("why");
        }

        for (int j=0; j<mediaFilevector.size(); j++)
        {
           total += mediaFilevector.get(j).getT().getSec();
        }
    }


    static void playing(){
        System.out.println("Press P to play or E to exit ");
        s = sc.nextLine();
        if(s.equalsIgnoreCase("P"))
        {
            if (mediaFilevector.size()==0)
            {
                playing = false;
                System.out.println("Exiting");
                return;

            }
            else {
                playing = true;
                while (!s.equalsIgnoreCase("E"))
                {
                    if(i==mediaFilevector.size())
                    {
                        playing = false;
                        mediaFilevector.clear();
                        System.out.println("Exiting");
                        return;
                    }
                    else {
                        System.out.println("Currently playing");
                        a.play(mediaFilevector.get(i).name, mediaFilevector.get(i).t, mediaFilevector.get(i).fileFormat);
                        elapsed += mediaFilevector.get(i).getT().getSec();
                        i++;
                        System.out.println("Want tot add a song? Y/N");
                        s = sc.nextLine();
                        if(s.equalsIgnoreCase("Y"))
                            addSong();
                        System.out.println("Press C to continue or E to exit ");
                        s = sc.nextLine();
                        s = sc.nextLine();
                    }
                }
                //playing = false;
            }
        }
        else{
            playing = false;
        }

    }

    static void forced()
    {
        if(elapsed > total)
            mediaFilevector.clear();
        //System.out.println("Hi");
        playlist();
    }

    static void addSong()
    {
        System.out.println("Enter File name");
        name = sc.nextLine();
        System.out.println("Enter File format");
        fileFormat = sc.nextLine();
        System.out.println("Enter Duration ");
        min =  sc.nextInt();
        sec = sc.nextInt();
        System.out.println("Enter Size");
        size = sc.nextDouble();
        mediaFilevector.add(new mediaFile(name, new time(min,sec), fileFormat, size));

        total+=mediaFilevector.get(mediaFilevector.size()-1).getT().getSec();
    }

    public static void main(String[] args) {



        while (true) {
            if (!playing) {
                playlist();
                playing();
                System.out.println("Finish session ? Y/N");
                s = sc.nextLine();
                if(s.equalsIgnoreCase("Y"))
                    return;
                else
                    continue;


            } else {
                forced();
                playing();
                System.out.println("Finish session? Y/N");
                s = sc.nextLine();
                if(s.equalsIgnoreCase("Y"))
                    return;
                else
                    continue;
            }

        }
    }
}
