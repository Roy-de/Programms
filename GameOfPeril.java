
/**
 * ACS-1903 Assignment 2 Q1
 * (Sample Solution to A1Q2)
 * @author (your student number here)
 * 
 *  Calculates the total number of calories that your body expends in 24 hours.
 *  The Total Daily Energy Expenditure (TDEE) is calculated with an individual’s 
 *  Basal Metabolic Rate (BMR) and activity level
 */
public class GameOfPeril {

    public static void main(String[] args){
        //Welcome to Game of Peril This is the comment section let's go!!!!!!
    System.out.println("Welcome to Peril: Let's Play");
    System.out.printf("------------------------------ \n");
    //Here we initialize our variables 
    /*We will have the big rolls that is roll1 and roll2
     * 2:We will have small rolls that is roll3 and roll4
     * Initialise score to be used to tally the winner after each set that is the one with the least tokens
     * initialise tokens for player 1 and player 2
     */
    int TokenUser1 = 5,TokenUser2 = 5;
    int roll1,roll2,roll3,roll4 ,set;
    int score1 = 0, score2 = 0;
    int round = 1;
    //we create our game of peril with constructor newGame
    GameOfPeril newGame =  new GameOfPeril();
    //Loop through 5 sets
    for(set = 1;set<=5;set++){
        newGame.set(set);
        int max = (int)(Math.random()*3)+2;
        //Loop through 3 rounds
       for(round = 1;round <=max;round ++){
            
            roll1 = newGame.diceroll();
            roll2 = newGame.diceroll();
            roll3 = newGame.diceroll();
            roll4 = newGame.diceroll();
            //Initialise variable to store winner value
           String winner = newGame.CompareRolls(roll1, roll2);
            //assign value to winner
           newGame.DisplayBigRoll(round,roll1,roll2, newGame.CompareRolls(roll1,roll2));
            if(winner == "Player1"){
               TokenUser2 = TokenUser2 - 1;
            }
            else if(winner == "Player2"){
            TokenUser1 = TokenUser1 - 1;
           }
           roll1 = roll3;
           roll2 = roll4;
            winner = newGame.CompareRolls(roll1,roll2);
           newGame.DisplaySmallRoll(roll3,roll4, newGame.CompareRolls(roll1,roll2));
           //Here we compare the player with least tokens
           if(winner == "Player1"){
               TokenUser2 = TokenUser2 - 1;
            }
            else if(winner == "Player2"){
            TokenUser1 = TokenUser1 - 1;
           }
           System.out.println("Player 1: "+TokenUser1);
           System.out.println("Player 2: "+TokenUser2);  
           System.out.println("");
           }
           //This is used to tally the scores after each set
       if(TokenUser1 > TokenUser2){
         score1 = score1 + 1;
       }
       else if(TokenUser2 > TokenUser1){
        score2 = score2 + 1;
       }
       //This calls the method for displaying scores
       newGame.Scoreboard(score1,score2,set);
      }   
    //Display winner
    newGame.Winner(score1, score2);
    System.out.println("\n End of Program");
    }

    public String CompareRolls(int roll1,int roll2){
        //In this method we compare the rolls to see who won each roll either bigroll or small roll
        String winner;

        if(roll1 > roll2){
           winner = "Player1";
        }
        else if(roll2 > roll1){
            winner = "Player2";
        }
        else {
            winner = "Tie";
        }
        return winner;

    }

    public void set(int set){
        //This just prints the number of sets 
        System.out.printf("\nSet:%d \n",set);
        System.out.printf("-------------------------- \n");
    }
    public int diceroll(){
        //the math.random function is used so that our dice rolls are random and are not less than 1 or greater than 6
     int random = (int)(Math.random()*6) + 1;
     return random;
    }
   
    public void DisplayBigRoll(int round,int player1,int player2,String winner){
        //This displays the big rooll round
        System.out.printf("Round %d \n",round);
        System.out.println("Big roll");
        System.out.println("Player 1: "+player1+"     Player 2: "+player2+"     Winner "+winner);
     }
     
    public void DisplaySmallRoll(int player1,int player2,String winner){
        //This displays the small roll round
        System.out.println("Small Roll");
        System.out.println("Player 1: "+player1+"      Player 2: "+player2+"      Winner "+winner);
        System.out.println("Summary: Token remaining");

    }
    public void Scoreboard(int score1,int score2,int set){
        //This displays the scoreboard after calculation
        if(score1 > score2){
            System.out.println("\n -----------------------");
            System.out.println("Player 1 wins set "+set);
        }
        else if(score2 > score1){
            System.out.println("\n -----------------------");
            System.out.println("Player 2 wins set "+set);
        }
        else{
            System.out.println("\n -----------------------");
            System.out.println("It is a tie in set "+set);
        }
        System.out.println("-----------------------------");
        System.out.println("Score Board");
        System.out.printf("Player 1  Player 2");
        System.out.printf("\n %5d %5d \n",score1,score2);
        System.out.println("-----------------------------------");
    }
    
    public void Winner(int score1,int score2){
        if(score1 > score2){
            System.out.println("Player 1 is the winner of Game of Peril");
        }
        else if(score2 > score1){
            System.out.println("Player 2 is the winner of Game Of Peril");
        }
        else{
            System.out.println("It is a tie");
        }
    }

  } 

