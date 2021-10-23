public class file  {
    String name;
    String directory;
    String type;
    //int tab_count;

    public file() {
        this.type = "File" ;
    }

    public file(String name) {
        this.name = name;
        this.type = "File" ;
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
        this.directory = directory ;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        this.type = "File";
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

    void listing()
    {
        /*for (int i=0; i<tab_count; i++)
            System.out.println("\t");*/
        System.out.println("----" + name);
    }

    void details()
    {
        System.out.println("Details of " + name + "\n\n");
        System.out.println("Type:" + type);
        System.out.println("Directory:"+directory + "\\" + name);
    }

    @Override
    public String toString() {
        return directory ;
    }
}
