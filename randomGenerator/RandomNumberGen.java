//import java.util.Random;
import java.util.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.io.*;

public class RandomNumberGen {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many radnom numbers do you need? ");
        int n = sc.nextInt();
        System.out.print("The lowest possible number should be: ");
        int min = sc.nextInt();
        System.out.print("The highest possible number should be: ");
        int max = sc.nextInt() + 1;

        Random random = new Random();
        
        System.out.print(n + " ");
        String problem = "";
        problem += n + " ";
        
        for (int i = 1; i <= n; i++) {
            int x = random.nextInt(max - min) + min;
            System.out.print(x + " ");
            problem += x + " ";
        }
        
        String myString = "This text will be copied into clipboard";
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        
        System.out.print("\n");
    }
}