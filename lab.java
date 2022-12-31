import java.util.Scanner;
/*TO DO
 * 1: Create a two dimension array
 * 2: Initialise our variables to use in te array
 * 3: Print average and min votes and max votes and their corresponding topics
 * 
 */
public class lab{
    //method for polling
   int[][] getArray(){
        //Scanner initialisation
        Scanner sc = new Scanner(System.in);  
        //Variable and array initialisation
        int i,j;  
        int [][] array = new int[10][5];
        //Scanner is used to read input
        System.out.println("Enter your votes");
        //We use for loop to enter our votes into the two dimension array
        for(i=0;i< 10;i++){
            for(j = 0;j < 5;j++){
                array[i][j] = sc.nextInt();
            }
            System.out.println("");
        }
        return array;
    }
  void display(int [][] array){
        int k;
        String topics[] = {"Gambling","High cost of living", "High fuel prices","Flat tax", "Immigration"};
        for(k = 0;k<=4;k++){
         System.out.printf("%19s | \t",topics[k]);
        }
        System.out.println("");
        int i,j;
        int avg;
        for(i=0;i<10;i++){ 
            int sum = 0;
            for(j=0;j<5 ;j++){
                System.out.printf("%20d| \t",array[i][j]);
                        for (int row = 0; row < array.length; row++) {
                             int column = 0;
                             sum += array[row][column];
                             column ++;
                }
            sum = sum/array.length;
        } 
    avg = sum;
    System.out.printf("Average: %d",avg);
    System.out.println("");
    }
    }
  /*void max(int [][] array){
    System.out.println("Max average:");
  }*/
    public static void main(String[] args){ 
    lab m =  new lab();
    int [][] mm = m.getArray();
    m.display(mm);
  }

}