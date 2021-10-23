public class mediaFile {
    String name;
    time t;
    String fileFormat;
    double size;

    public mediaFile() {
    }

    public mediaFile(String name, time t, String fileFormat, double size) {
        this.name = name;
        this.t = t;
        this.fileFormat = fileFormat;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public time getT() {
        return t;
    }

    public void setT(time t) {
        this.t = t;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "mediaFile{" +
                "name='" + name + '\'' +
                ", t=" + t +
                ", fileFormat='" + fileFormat + '\'' +
                '}';
    }
}
