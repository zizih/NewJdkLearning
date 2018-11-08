package designpatterns.command;

public class Invoker {

    private Command command;

    public Invoker() {
    }

    public Invoker setCommand(Command command) {
        this.command = command;
        return this;
    }

    public void action() {
        command.execute();
    }
}
