import java.io.File;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.System.exit;

public class FileSystem {

    static Scanner sc = new Scanner(System.in);
    static Vector<drive> curDrives = new Vector<>();
    static drive atNow;
    static folder atF;

    public static void main(String[] args) {

        utilFunc.dsp();
        String s = sc.nextLine();
        String[] driveTokens = s.split(" ");
        checkDrive(driveTokens);
        //return;

    }

    static void checkDrive(String[] driveTokens){
        if(driveTokens[0].equalsIgnoreCase("C")){
            curDrives.add(new drive(driveTokens[1]));
            curDrives.get(curDrives.size()-1).setDirectory();
        }

        else if(driveTokens[0].equalsIgnoreCase("D")){
            int flag = 0;
            for (int i=0; i<curDrives.size(); i++){
                if(curDrives.get(i).getName().equals(driveTokens[1]))
                {
                    curDrives.remove(i);
                    flag = 1;
                    break;
                }
                else {

                }
            }

            if (flag == 0)
                System.out.println("Cannot be found");

        }

        else if (driveTokens[0].equalsIgnoreCase("E")){
            int flag = 0;
            for (int i=0; i<curDrives.size(); i++){
                if(curDrives.get(i).getName().equals(driveTokens[1]))
                {
                    atNow = new drive();
                    atNow = curDrives.get(i);
                    //System.out.println(atNow.getName());
                    utilFunc.dsp2();
                    String s = sc.nextLine();
                    String[] inDriveTokens = s.split(" ");
                    //checkDrive(inDriveTokens);
                    inDrive(inDriveTokens);
                }
                else {

                }
            }

            if (flag == 0)
                System.out.println("Cannot be found");
        }

        else if(driveTokens[0].equalsIgnoreCase("Exit"))
            exit(0);

        else{
            System.out.println("Error! Try again");

        }


        String s = sc.nextLine();
        String[] dT = s.split(" ");
        checkDrive(dT);

    }

    static void inDrive(String[] inDriveTokens){


        if(inDriveTokens[0].equalsIgnoreCase("C")) {
            if (inDriveTokens[1].equalsIgnoreCase("File")) {
                atNow.getFiles().add(new file(inDriveTokens[2]));
                //atNow.getFiles().get(atNow.getFiles().size()-1).setTab_count(atNow.getTab_count()+1);

            } else {
                atNow.getFolders().add(new folder(inDriveTokens[2]));
                atNow.getFolders().get(atNow.getFolders().size()-1).setDirectory(atNow.getDirectory());
                atNow.getFolders().get(atNow.getFolders().size()-1).setParentDrive(atNow);
                //atNow.getFolders().get(atNow.getFolders().size()-1).setTab_count(atNow.getTab_count()+1);
            }
        }

        else if(inDriveTokens[0].equalsIgnoreCase("D")) {
            int flag = 0;
            if (inDriveTokens[1].equalsIgnoreCase("Files")) {

                Vector<file> files = atNow.getFiles();
                for (int i = 0; i < files.size(); i++) {
                    if (files.get(i).getName().equals(inDriveTokens[2])) {
                        files.remove(i);
                        flag = 1;
                        break;
                    } else {

                    }
                }

                if (flag == 0)
                    System.out.println("Cannot be found");

            }
            else {

                Vector<folder> folders = atNow.getFolders();
                for (int i = 0; i < folders.size(); i++) {
                    if (folders.get(i).getName().equals(inDriveTokens[2])) {
                        folders.remove(i);
                        flag = 1;
                        break;
                    } else {

                    }
                }

                if (flag == 0)
                    System.out.println("Cannot be found");
            }
        }

        else if (inDriveTokens[0].equalsIgnoreCase("E")){
            int flag = 0;
            Vector<folder> folders = atNow.getFolders();
            for (int i=0; i<folders.size(); i++){
                if(folders.get(i).getName().equals(inDriveTokens[2]))
                {
                    atF = new folder();
                    atF = folders.get(i);
                    utilFunc.dsp2();
                    String s = sc.nextLine();
                    inDriveTokens = s.split(" ");
                    //checkDrive(inDriveTokens);
                    inFolder(inDriveTokens);
                    //inDrive(inDriveTokens);
                }
                else {

                }
            }

            if (flag == 0)
                System.out.println("Cannot be found");
        }
        else if(inDriveTokens[0].equalsIgnoreCase("B"))
        {
            utilFunc.dsp();
            String s = sc.nextLine();
            String[] driveTokens = s.split(" ");
            checkDrive(driveTokens);
        }

        else if(inDriveTokens[0].equalsIgnoreCase("T"))
        {
            atNow.list();
        }

        else if (inDriveTokens[0].equalsIgnoreCase("P"))
        {
            atNow.details();
        }
        else{
            System.out.println("Error! Try again");

        }


        String s = sc.nextLine();
        String[] dT = s.split(" ");
        inDrive(dT);//Drive(dT);

    }

    static void inFolder(String[] inDriveTokens){
        //atF.setDirectory(st);
        if(inDriveTokens[0].equalsIgnoreCase("C")){
            if(inDriveTokens[1].equalsIgnoreCase("File"))
                atF.getFiles().add(new file(inDriveTokens[2]));
            else{
                atF.getFolders().add(new folder(inDriveTokens[2]));
                atF.getFolders().get(atF.getFolders().size()-1).setDirectory(atF.getDirectory());
                atF.getFolders().get(atF.getFolders().size()-1).setParentFolder(atF);
            }
        }

        else if(inDriveTokens[0].equalsIgnoreCase("D")) {
            int flag = 0;
            if (inDriveTokens[1].equalsIgnoreCase("Files")) {

                Vector<file> files = atNow.getFiles();
                for (int i = 0; i < files.size(); i++) {
                    if (files.get(i).getName().equals(inDriveTokens[2])) {
                        files.remove(i);
                        flag = 1;
                        break;
                    } else {

                    }
                }

                if (flag == 0)
                    System.out.println("Cannot be found");

            }
            else {

                Vector<folder> folders = atF.getFolders();
                for (int i = 0; i < folders.size(); i++) {
                    if (folders.get(i).getName().equals(inDriveTokens[2])) {
                        folders.remove(i);
                        flag = 1;
                        break;
                    } else {

                    }
                }

                if (flag == 0)
                    System.out.println("Cannot be found");
            }
        }

        else if (inDriveTokens[0].equalsIgnoreCase("E")){
            int flag = 0;
            Vector<folder> folders = atF.getFolders();
            for (int i=0; i<folders.size(); i++){
                if(folders.get(i).getName().equals(inDriveTokens[2]))
                {
                    atF = new folder();
                    atF = folders.get(i);
                    utilFunc.dsp2();
                    String s = sc.nextLine();
                    inDriveTokens = s.split(" ");
                    //checkDrive(inDriveTokens);
                    inFolder(inDriveTokens);
                    //inDrive(inDriveTokens);
                }
                else {

                }
            }

            if (flag == 0)
                System.out.println("Cannot be found");
        }

        else if(inDriveTokens[0].equalsIgnoreCase("B"))
        {
            System.out.println("Yes");
            if(atF.getParentDrive() == null)
            {
                atF = atF.getParentFolder();
                System.out.println(atF);
                utilFunc.dsp2();
                String s = sc.nextLine();
                inDriveTokens = s.split(" ");
                inFolder(inDriveTokens);
                System.out.println("Yes2");

            }
            else {

                atNow = atF.getParentDrive();
                System.out.println(atNow);
                utilFunc.dsp2();
                String s = sc.nextLine();
                inDriveTokens = s.split(" ");
                //System.out.println("Yes3");
                inDrive(inDriveTokens);
                //System.out.println("Yes3");
            }
        }

        else if(inDriveTokens[0].equalsIgnoreCase("T"))
        {
            atF.list();
        }

        else if (inDriveTokens[0].equalsIgnoreCase("P"))
        {
            atF.details();
        }

        else{
            System.out.println("Error! Try again");

        }


        String s = sc.nextLine();
        String[] dT = s.split(" ");
        inFolder(dT);//Drive(dT);

    }
}
