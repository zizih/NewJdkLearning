package designpatterns.command.example;


/**
 * 执行者, 拥有各种执行能力
 */
public class AudioPlayer {

    public void play() {
        System.out.println("play music ..");
    }

    public void rewind() {
        System.out.println("rewind music ..");
    }

    public void stop() {
        System.out.println("stop music ..");
    }
}
