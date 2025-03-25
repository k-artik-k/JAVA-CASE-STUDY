import java.util.Scanner;

// Abstraction using an interface
interface Conversational {
    String respond(String message);
}

// Base class (Encapsulation)
abstract class ChatBot implements Conversational {
    protected String botName;

    public ChatBot(String name) {
        this.botName = name;
    }

    public abstract String respond(String message);
}

// Inherited class for Formal Chatbot
class FormalBot extends ChatBot {
    public FormalBot(String name) {
        super(name);
    }

    @Override
    public String respond(String message) {
        return "Hello. I appreciate your message: '" + message + "'. How may I assist you today?";
    }
}

// Inherited class for Casual Chatbot
class CasualBot extends ChatBot {
    public CasualBot(String name) {
        super(name);
    }

    @Override
    public String respond(String message) {
        return "Hey! You said: '" + message + "'. What's up?";
    }
}

// Inherited class for Sarcastic Chatbot
class SarcasticBot extends ChatBot {
    public SarcasticBot(String name) {
        super(name);
    }

    @Override
    public String respond(String message) {
        return "Oh wow, '" + message + "'... such an original thought!";
    }
}

// Main Class
public class ChatBotSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Choosing bot personality
        System.out.println("Choose your chatbot: 1. Formal  2. Casual  3. Sarcastic");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ChatBot bot;
        if (choice == 1) {
            bot = new FormalBot("JAI");
        } else if (choice == 2) {
            bot = new CasualBot("VIKRAM");
        } else {
            bot = new SarcasticBot("BUJJI");
        }

        System.out.println("Start chatting! Type 'exit' to stop.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println(bot.botName + ": Goodbye!");
                break;
            }

            System.out.println(bot.botName + ": " + bot.respond(userInput));
        }

        scanner.close();
    }
}
