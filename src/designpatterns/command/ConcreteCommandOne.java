package designpatterns.command;

public class ConcreteCommandOne implements Command {

    public Reciever reciever;

    public ConcreteCommandOne(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        System.out.println("command one ...");
    }
}
