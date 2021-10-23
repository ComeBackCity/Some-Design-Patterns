public class FlvPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String filename, time t) {
        //nothing
    }

    @Override
    public void playFlv(String filename, time t) {
        System.out.println("Playing " + filename + ".flv");
        System.out.println("Duration ->" + t);
    }

    @Override
    public void playMp4(String filename, time t) {
        //nothing
    }
}
