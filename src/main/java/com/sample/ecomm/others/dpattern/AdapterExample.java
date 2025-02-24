package com.sample.ecomm.others.dpattern;

// Existing interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee (incompatible class)
class VLCPlayer {
    void playVLC(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    private final VLCPlayer vlcPlayer = new VLCPlayer();

    public void play(String audioType, String fileName) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            vlcPlayer.playVLC(fileName);
        }
    }
}

// Client code
public class AdapterExample {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();
        player.play("vlc", "song.vlc");
    }
}
