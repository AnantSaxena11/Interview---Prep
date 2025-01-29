import java.util.*;
class MessagePrinter{
    String name;
    MessagePrinter(String name)
    {
        this.name = name;
    }
    void printMessage()
    {
        System.out.println("Hello, "+name);
    }
}
public class Index{
    public static void main(String[] args) {
        MessagePrinter message = new MessagePrinter("Anant");
        message.printMessage();

        
    }
}