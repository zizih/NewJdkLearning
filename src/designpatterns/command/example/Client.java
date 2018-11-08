package designpatterns.command.example;

public class Client {

    public static void main(String[] args) {

        // 拥有一个收音机
        AudioPlayer audioPlayer = new AudioPlayer();

        // 收音机拥有各种功能
        PlayCommand playCommand = new PlayCommand(audioPlayer);
        RewindCommand rewindCommand = new RewindCommand(audioPlayer);
        StopCommand stopCommand = new StopCommand(audioPlayer);

        // 有一个键盘
        Keypad keypad = new Keypad();

        // 执行给定的命令
        keypad.setCommand(playCommand).action();
        keypad.setCommand(rewindCommand).action();
        keypad.setCommand(stopCommand).action();
    }

}
