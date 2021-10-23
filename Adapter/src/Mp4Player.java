public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String filename, time t) {
        //nothing
    }

    @Override
    public void playFlv(String filename, time t) {
        //nothing
    }

    @Override
    public void playMp4(String filename, time t) {
        System.out.println("Playing " + filename + ".mp4");
        System.out.println("Duration ->" + t);
    }
}
