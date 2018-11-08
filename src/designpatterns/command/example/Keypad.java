package designpatterns.command.example;

public class Keypad {

    Command command;

    public Keypad() {
    }

    public Keypad(Command command) {
        this.command = command;
    }

    public Keypad setCommand(Command command) {
        this.command = command;
        return this;
    }

    public void action() {
        command.execute();
    }
}
