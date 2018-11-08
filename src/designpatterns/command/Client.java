package designpatterns.command;

public class Client {


    public static void main(String[] args) {

        // 有一个接收者
        Reciever reciever = new Reciever();

        // 接收者能执行各种命令
        Command command1 = new ConcreteCommandOne(reciever);
        Command command2 = new ConcreteCommandTwo(reciever);

        // 有一个调用者，能执行给定的命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command1).action();
        invoker.setCommand(command2).action();
    }

}
