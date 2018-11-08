package designpatterns.command;

public class ConcreteCommandTwo implements Command {

    public Reciever reciever;

    public ConcreteCommandTwo(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        System.out.println("command two ...");
    }
}
