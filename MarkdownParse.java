//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//https://kodejava.org/how-do-i-read-file-using-scanner-class/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.*; 
import java.util.Scanner;

public class MarkdownParse {
    /*
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            //every URL starts with http so I figured instead of trying to fine
            //a "(" why not?
            int openParen = markdown.indexOf("h", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }
 */ 

    public static void main(String[] args) {
    // Create an instance of File for data.txt file.
    Scanner sc = new Scanner(System.in);
    System.out.println("Hello I am the Lorax, I speak for the trees, may you please tell me which file you'd like me to read?");
    File file = new File(sc.nextLine());
    try {
        // Create a new Scanner object which will read the data
        // from the file passed in. To check if there are more 
        // line to read from it, we call the scanner.hasNextLine() 
        // method. We then read line one by one till all lines 
        // is read.
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
}
