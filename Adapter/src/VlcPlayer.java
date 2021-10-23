public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String filename, time t) {
        System.out.println("Playing " + filename + ".vlc");
        System.out.println("Duration ->" + t);
    }

    @Override
    public void playFlv(String filename, time t) {
        //nothing
    }

    @Override
    public void playMp4(String filename, time t) {
        //nothing
    }
}
