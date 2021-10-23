public class AudioPlayer implements MediaPlayer {

    MediaAdapter mp;


    @Override
    public void play(String name, time Time, String fileFormat) {
        if(fileFormat.equalsIgnoreCase("mp3"))
            System.out.println("Playing " + name + "." +fileFormat);

        else if(fileFormat.equalsIgnoreCase("vlc") || fileFormat.equalsIgnoreCase("flv") || fileFormat.equalsIgnoreCase("mp4")){
            mp = new MediaAdapter(fileFormat);
            mp.play(name, Time, fileFormat);
        }

        else{
            System.out.println("Invalid file format.");
        }

    }
}
