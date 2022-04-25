//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//https://kodejava.org/how-do-i-read-file-using-scanner-class/
//https://github.com/BellaReal/markdown-parser/blob/main/MarkdownParse.java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.*; 
import java.util.Scanner;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        Scanner sc = new Scanner(markdown);
        while (sc.hasNextLine()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            // noticed file was being looped over again, this statement
            // fixes that error
            if(openBracket < 0 || closeBracket < 0 || openParen < 0 || closeParen < 0) {
                break;
            }
            //check to make sure link is not an image
            Boolean isImage = false;
            if(openBracket != 0){
                String type = markdown.substring(openBracket - 1, openBracket);
                isImage = type.equals("!"); 
            }
             //check that link follows format []()
             int format = openParen - closeBracket;
             Boolean linkFollowsFormat = true;
             if(format != 1) {
                 linkFollowsFormat = false;
             }
             //check that link is a valid link
             String link = markdown.substring(openParen + 1, closeParen);
             Boolean linkIsValid = link.contains(" ");
            if(isImage == false && linkIsValid == false && linkFollowsFormat == true && !(link.isEmpty())) {
                toReturn.add(link);
            }
            currentIndex = closeParen + 1;  
            sc.hasNextLine();
        }
        //closing the scanner
        sc.close();
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
    }
    
}
