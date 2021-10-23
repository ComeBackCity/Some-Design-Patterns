import java.util.Vector;

public class folder {
    String name;
    String directory;
    int component_count = 0;
    String type;
    Vector<folder> folders = new Vector<>();
    Vector<file> files = new Vector<>();
    folder parentFolder;
    drive parentDrive;
    //int tab_count;

    public folder() {
        this.type = "Folder" ;
    }

    public folder(String name, String directory, int component_count,  Vector<folder> folders) {
        this.name = name;
        this.directory = directory;
        this.component_count = component_count;
        this.type = "Folder";
        this.folders = folders;
    }

    public folder(String name) {
        this.name = name;
        this.type = "Folder" ;
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

    public void setDirectory(String directory) {
        this.directory = directory + name + "\\";
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

    public folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(folder parentFolder) {
        this.parentFolder = parentFolder;
        this.parentDrive = null;
    }

    public drive getParentDrive() {
        return parentDrive;
    }

    public void setParentDrive(drive parentDrive) {
        this.parentDrive = parentDrive;
        this.parentFolder = null;
    }

    public int getComponent_count() {
        return component_count;
    }

    public void setComponent_count() {
        int i=0;
        if(folders.size() == 0){
            i += 0;
            //System.out.println("Y");
        }
        else {
            for (int j = 0; j < folders.size(); j++) {
                i += folders.get(j).getComponent_count();
                //System.out.println("N");
            }
        }
        i += files.size();
        component_count = i;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = "Folder";
    }

    /*public int getTab_count() {
        return tab_count;
    }

    public void setTab_count(int tab_count) {
        this.tab_count = tab_count;
    }*/

    void list()
    {
        System.out.println(directory + "\n\t" );
        listing();

    }

    void l2()
    {
        /*for (int i=0; i<tab_count; i++)
        {
            System.out.println("\t");
        }*/
        System.out.println("----" + name);
        for(int i=0; i<folders.size(); i++)
        {
            folders.get(i).l2();
        }
        for (int i=0; i<files.size(); i++)
        {
            files.get(i).listing();
        }
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
        this.setComponent_count();
        System.out.println("Component count;"+ component_count);
    }

    @Override
    public String toString() {
        return directory + "\\" + name;
    }


}
