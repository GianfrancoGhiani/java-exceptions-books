import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "./shelf.txt";
    public static void main(String[] args) {

        //import
        Scanner userInput = new Scanner(System.in);
        Scanner reader = new Scanner(FILE_PATH);
        File shelfFile = new File(FILE_PATH);
        if (!(shelfFile.exists())){
            try{
                shelfFile.createNewFile();
            }catch (IOException e){
                System.out.println("Creation file error");
            }
        }

        //creation of the array
        System.out.println("How many books do you want to insert to your shelf?");
        String n = userInput.nextLine();
        int bookNum = 0;
        if (isInt(n)){
            bookNum = Integer.parseInt(n);
            Book[] shelf = new Book[bookNum];
            boolean correctInput = false;
            for (int i = 0; i < bookNum; i++) {
                do {
                    System.out.println("Insert author");
                    String author = userInput.nextLine();
                    System.out.println("Insert editor");
                    String editor = userInput.nextLine();
                    System.out.println("Insert title");
                    String title = userInput.nextLine();
                    System.out.println("Insert page num");
                    String pageNum = userInput.nextLine();
                    int pgNum = 0;
                    if (isInt(pageNum)) {
                        pgNum = Integer.parseInt(pageNum);
                    }
                    try {
                        Book newBook = new Book(author, editor, title, pgNum);
                        shelf[i] = newBook;
                        correctInput = true;
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + ", retry filling them all");
                    }
                }while (!correctInput);
            }

        }

    }
    private static boolean isInt(String num){
        try{
            Integer.parseInt(num);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
