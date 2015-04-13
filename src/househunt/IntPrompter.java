package househunt;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.InputStream;

public class IntPrompter {
    private final Scanner scanner;
    private final PrintStream out;

    public IntPrompter(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public int ask(String message) {
        out.println(message);
        return scanner.nextInt();
    }
    
    public void message(String m) {
        out.println(m);
    }
}
