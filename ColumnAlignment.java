/*  We will require java.utils to use scanner,
    java.io.file is used to handle our external file As2Q3.txt
    java.io.FileNotFoundException is used to handle errors arising from being unable to open As2Q3.txt
    This importations are important for this assignment 
*/
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class ColumnAlignment{
    public static boolean isNumeric(String str){
        //Here we make sure to check if our string is empty or null. If true then it will return false
        if(str == null || str.isEmpty()){
            return false;
        }
        //For every character at position X we check to see if it is a digit or not
        for (int x = 0; x < str.length();x++){
            if(!Character.isDigit(str.charAt(x))){
                return false;
            }
        }
        return true;
    }
    public static boolean isPeriod(String str){
        char period = '.';
        for(int x = 0;x < str.length(); x++){
          if(str.charAt(x) == period){
            return true;
          }
        }
        return false;
    }

    public static void main(String args[]){
        //Read lines from file As2Q3
        //Display line text as follows.
        /*
            Right align numeric values (they can have one decimal or start with $)
            Centre align on numeric values or text that does not fall under numeric description.
            Left align text that is longer than column width.
        */ 

        //Ask user for column width.
        //Display each line aligned as described above. 
        //Include dot to visualize spaces.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter column width.");
        int columnWidth = sc.nextInt();
        try{
            File file = new File("/home/roy/PRogramming/As2Q3.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                int length = line.length();
                String dollar = "$";
                //Right indentation
                if ((isNumeric(line)==true)  && isPeriod(dollar) == false|| (line.charAt(0) == dollar.charAt(0)))
                {
                    for (int i=0; i<(columnWidth-length); i++)
                        System.out.print(".");
                    System.out.print(line); 
                    System.out.println();
                }
                //Center words
                else if (length < columnWidth){
                    int temp = (columnWidth-length)/2;
                    for (int i=0; i<temp; i++)
                        System.out.print(".");
                    System.out.print(line);
                    for (int i=0; i<temp; i++)
                        System.out.print(".");
                    System.out.println();
                }
                else{
                    //Left indentation
                    System.out.println(line);                   
                }      
            }
            reader.close();
        }catch (FileNotFoundException  e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        sc.close();
    }
}