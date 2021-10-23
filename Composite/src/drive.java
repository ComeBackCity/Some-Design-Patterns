import java.util.Vector;

public class drive {
    String name;
    String directory;
    int component_count ;
    String type;
    Vector<folder> folders = new Vector<>();
    Vector<file> files = new Vector<>();
    //int tab_count = 0;

    public drive() {
        this.type = "Drive" ;
    }

    public drive(String name, String directory, int component_count, String type, Vector<folder> folders) {
        this.name = name;
        this.directory = directory;
        this.component_count = component_count;
        this.type = "Drive";
        this.folders = folders;
    }

    public drive(String name) {
        this.name = name;
        this.type = "Drive" ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory() {
        this.directory = name+":\\\\";
    }

    public Vector<folder> getFolders() {
        return folders;
    }

    public void setFolders(Vector<folder> folders) {
        this.folders = folders;
    }

    public Vector<file> getFiles() {
        return files;
    }

    public void setFiles(Vector<file> files) {
        this.files = files;
    }

    public int getComponent_count() {
        return component_count;
    }

    /*public int getTab_count() {
        return tab_count;
    }*/

    public void setComponent_count() {
        int i=0;
        //System.out.println("2");
        for(int j=0; j<folders.size(); j++)
        {
            //System.out.println("2");
            i += folders.get(j).getComponent_count();
            //System.out.println("3");
        }
        //System.out.println("4");
        i += files.size();
        component_count = i;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        this.type = "Drive";
    }

    void list()
    {
        System.out.println(directory + "\n\t" );
        listing();

    }

    void listing()
    {
        for(int i=0; i<folders.size(); i++)
        {
            folders.get(i).l2();
        }
        for (int i=0; i<files.size(); i++)
        {
            files.get(i).listing();
        }
    }

    void details()
    {
        System.out.println("Details of " + name + "\n\n");
        System.out.println("Type:" + type);
        System.out.println("Directory: \""+directory + "\"" );
        //System.out.println("1");
        setComponent_count();
        //System.out.println("1");
        System.out.println("Component count:"+ component_count);
    }

    @Override
    public String toString() {
        return directory ;
    }
}
