import java.util.Scanner;

public class EnergyExpenditure2 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        double weight, height, age, bmr,activityFactor = 0;
        String gender, selection;
        String answer = new String();
        String required =  new String("yes");
        System.out.println("Enter your weight (in kg), height (in cm), age (in years), and gender (m/f):");
        //Do not use a comma after every value or else the program will throw an error
        do{

        weight = kb.nextDouble();
        height = kb.nextDouble();
        age = kb.nextDouble();
        gender = kb.next();
        
        //Calculate BMR
        // calculate Basal Metabolic Rate
        if (gender.equalsIgnoreCase("m")){
                bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);}
        else{
                bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);}
        
        //Display activity levels        
        System.out.println("select your activity level:");
        System.out.println("[A] Sedentary");
        System.out.println("[B] Lightly active");
        System.out.println("[C] Moderate exercise");
        System.out.println("[D] Very active");
        System.out.println("[E] Extra active");
 
        //Get activity levels
        selection = kb.next();
        String keyval = selection.toUpperCase();
        // SELECTING ACTIVITY LEVELS
        System.out.printf("Select your activity level: \n");
        switch (keyval) {
            case "A":
                System.out.println("[A] Sedentary");
                activityFactor = 1.2;
                break;

            case "B":
                System.out.println("[B] Lightly active");
                activityFactor =  1.375;
                break;

            case "C":
                System.out.println("[C] Moderate exercise");
                activityFactor = 1.55;
                break;

            case "D":
                System.out.println("[D] Very active");
                activityFactor = 1.725;
                break;

            case "E":
                System.out.println("[E] Extra active");
                 activityFactor = 1.9;
                break;
            default:
                break;
 
        }
        //TDEE calculation
        double TDEE = bmr * activityFactor; 
        System.out.println("TDEE: " + TDEE);
        System.out.println("BMR: " + bmr); 
        System.out.println("Do you want to calculate another TDEE value?(y/n)");   
        answer  = kb.nextLine();  
    }while(required.equals(answer));
    System.out.println("Goodbye!");
   // kb.close();
}
}