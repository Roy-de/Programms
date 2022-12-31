
/**
 * ACS-1903 Assignment 2 Q1
 * (Sample Solution to A1Q2)
 * @author (your student number here)
 * 
 *  Calculates the total number of calories that your body expends in 24 hours.
 *  The Total Daily Energy Expenditure (TDEE) is calculated with an individual’s 
 *  Basal Metabolic Rate (BMR) and activity level
 */
import java.util.Scanner;

public class EnergyExpenditure {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        double weight, height, age, bmr,activityFactor;
        String gender, selection;
        System.out.println("Enter your weight (in kg), height (in cm), age (in years), and gender (m/f):");
        //Do not use a comma after every value or else the program will throw an error
        
        weight = kb.nextDouble();
        height = kb.nextDouble();
        age = kb.nextDouble();
        gender = kb.next();

        EnergyExpenditure methodsExp = new EnergyExpenditure();
       
        //Calculating BMR
        bmr = methodsExp.CalculateBMR(weight,height,age,gender);
        //Display activity levels:
        methodsExp.displayActivityLevels();
        //Get activity factor:
        selection = kb.next();
        activityFactor = methodsExp.getActivityFactor(selection);
        //Calculate TDEE (Total Daily Energy Expenditure)
        double TDEE = methodsExp.CalculateTDEE(bmr,activityFactor);
        //Display Result
        methodsExp.DisplayResults(TDEE,bmr);
        System.out.println("Do you want to calculate another TDEE value?(y/n)");
        char answer  = kb.next().charAt(0);
        char Required = 'y';
        if(answer == Required){
          main(null);
        }
        else{
        System.out.println("Goodbye!");
         kb.close();
        }
       
    }
    double CalculateBMR(double weight,double height,double age,String gender) {
        double bmr;
        // calculate Basal Metabolic Rate
        if (gender.equalsIgnoreCase("m"))
            bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        else
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);

   
    return bmr;        

    }
//Display Activity levels
    void displayActivityLevels() {
        System.out.println("select your activity level:");
        System.out.println("[A] Sedentary");
        System.out.println("[B] Lightly active");
        System.out.println("[C] Moderate exercise");
        System.out.println("[D] Very active");
        System.out.println("[E] Extra active");

    }
//method used to get activity factor
    double getActivityFactor(String keys) {
        String keyval = keys.toUpperCase();
        double activityFactor = 0;
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
        return activityFactor;       

    }
//Method used to calculate Total daily energy expenditure
    double CalculateTDEE(double bmr,double activityFactor) {;
        double TDEE = bmr * activityFactor;
  
        return TDEE;
    }

    void DisplayResults(double TDEE,double bmr) {
      System.out.println("TDEE: " + TDEE);
      System.out.println("BMR: " + bmr); 
    }

}
