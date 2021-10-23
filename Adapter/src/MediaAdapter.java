public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer amp ;

    public MediaAdapter(String type) {

        if(type.equalsIgnoreCase("vlc")){
            amp = new VlcPlayer();
        }

        else if(type.equalsIgnoreCase("flv")){
            amp = new FlvPlayer();
        }

        else if(type.equalsIgnoreCase("mp4")){
            amp = new Mp4Player();
        }
    }

    @Override
    public void play(String name, time Time, String fileFormat) {
        if(fileFormat.equalsIgnoreCase("vlc")){
            amp.playVlc(name,Time);
        }

        else if(fileFormat.equalsIgnoreCase("flv")){
            amp.playFlv(name,Time);
        }

        else if(fileFormat.equalsIgnoreCase("mp4")){
            amp.playMp4(name,Time);
        }
    }
}
