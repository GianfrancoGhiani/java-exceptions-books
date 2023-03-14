import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "./shelf.txt";
    public static void main(String[] args) {

        // import
        Scanner userInput = new Scanner(System.in);
        Scanner reader = null;
        File shelfFile = new File(FILE_PATH);
        FileWriter writer = null;

        // file creation
        if (!(shelfFile.exists())){
            try{

                shelfFile.createNewFile();
            }catch (IOException e){
                System.out.println("Creation file error");
            }
        } else{
            try{
                writer = new FileWriter(FILE_PATH);
                writer.write("");
            }catch (IOException e){
                System.out.println("Cleaning file error");

            }finally {
            if (writer != null){
                try{
                    writer.close();
               }catch (IOException e){
                   System.out.println(e.getMessage());
               }
           }
       }
        }

        // creation of the array
        System.out.println("How many books do you want to insert to your shelf?");
        String n = userInput.nextLine();
        int bookNum = 0;
        if (isInt(n)){
            bookNum = Integer.parseInt(n);
            Book[] shelf = new Book[bookNum];
            boolean correctInput = false;
            // shelf Array filler
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
            userInput.close();

            // file writer
            for (int i = 0; i < shelf.length; i++) {
                try {
                    writer = new FileWriter(FILE_PATH, true);
                    writer.write(shelf[i].toString() + "\n");
                }catch (IOException e){
                    System.out.println(e.getMessage());
                } finally {
                    if (writer != null){
                        try{
                            writer.close();
                        }catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            // file reader
            if ((shelfFile.exists())){

                try{
                    reader = new Scanner(new File(FILE_PATH));
                    while(reader.hasNext()){
                        System.out.println(reader.nextLine());;
                    }
                }catch (FileNotFoundException e){
                    throw new RuntimeException(e);
                }finally {
                    if (reader != null){
                        try{
                            reader.close();
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
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
