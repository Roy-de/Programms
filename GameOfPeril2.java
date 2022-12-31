import java.util.Random;
public class  GameOfPeril2{
public static void main(String [] args) {
Random rand= new Random();
System.out.println("Welcome to peril: let's play");
System.out.println("------------------------------");
System.out.println("set: 1");
System.out.println("------------------------------");
String p1= "player1";
String p2= "player2";
int set=1;
int round=1;
int player1dice1 = rand.nextInt(6)+1;
int player1dice2 = rand.nextInt(6)+1;
int player2dice1 = rand.nextInt(6)+1;
int player2dice2 = rand.nextInt(6)+1;
int player1Token= 5;
int player2Token= 5;
int difference;
int player1wins=0;
int player2wins=0;
//int difference2;
int additionplayer1;
int additionplayer2;
//boolean winner = true;{
   while(player1wins!=3 || player2wins!=3 ) {
			
			System.out.println("Set " + set + ":");
			
			while(player1Token > 0 && player2Token > 0) {
			 
    System.out.println("set " + set);
System.out.println("Round " + round);
System.out.println("Big roll");
if (player1dice1>player1dice2 && player2dice1>player2dice2) {
    System.out.println(p1 + ":    " + player1dice1 + " " + p2 + ":  " + player2dice1);}
    else if (player1dice2>player1dice1 && player2dice2>player2dice1) {
        System.out.print(p1 + ":    " + player1dice2 + " " + p2 + ":  " + player2dice2);
    }
    else if (player1dice2>player1dice1 && player2dice1>player2dice2) {
        System.out.print(p1 + ":    " + player1dice2 + " " + p2 + ":  " + player2dice1);}
        else if (player1dice1>player1dice2 && player2dice1>player2dice2) {
             System.out.println(p1 + ":    " + player1dice1 + " " + p2 + ":  " + player2dice1);}
        if (player1dice1>player2dice1)  {
        System.out.println("Winner : " + p1); }
       else if (player1dice2>player2dice2) {
        System.out.println("Winner : " + p1);
        }
        else if (player2dice1>player1dice1) {
            System.out.println("Winner : " + p2);
        }
        else if (player2dice2 > player1dice2) {
            System.out.println("Winner : " + p2);
        }
        else if (player1dice1==player2dice1) {  
            System.out.println("Its a tie"); }
           else if (player1dice1==player2dice2) {
            System.out.println("Its a tie");
        }
        else if (player1dice2==player2dice2)  {
            System.out.println("Its a tie");
        }
        else if (player1dice2==player2dice1) {
            System.out.println("Its a tie");
        }
    
      
     System.out.println("Smallroll");
 if (player1dice1<player1dice2 && player2dice1<player2dice2) {
    System.out.println(p1 + ":    " + player1dice1 + " " + p2 + ":  " + player2dice1);}
    else if (player1dice2<player1dice1 && player2dice2<player2dice1) {
        System.out.print(p1 + ":    " + player1dice2 + " " + p2 + ":  " + player2dice2);
    }
    else if (player1dice2<player1dice1 && player2dice1<player2dice2) {
        System.out.print(p1 + ":    " + player1dice2 + " " + p2 + ":  " + player2dice1);}
        else if (player1dice1<player1dice2 && player2dice1<player2dice2) {
             System.out.println(p1 + ":    " + player1dice1 + " " + p2 + ":  " + player2dice1);}
    if (player1dice1>player2dice1)  {
        System.out.println("Winner : " + p1); }
       else if (player1dice2>player2dice2) {
        System.out.println("Winner : " + p1);
        }
        else if (player2dice1>player1dice1) {
            System.out.println("Winner : " + p2);
        }
        else if (player2dice2 > player1dice2) {
            System.out.println("Winner : " + p2);
        }
            else  if  (player1dice1==(player2dice1)) {  
            System.out.println("Its a tie"); }
            else if (player1dice1==(player2dice2)) {
            System.out.println("Its a tie");
        }
            else if (player1dice2==(player2dice2))  {
            System.out.println("Its a tie");
        }
            else if (player1dice2==(player2dice1)) {
            System.out.println("Its a tie");
        }
 System.out.println("Summary: Tokens remaining");
additionplayer1 = player1dice1+player1dice2;
additionplayer2 = player2dice1+player2dice2; 
 if (additionplayer1>additionplayer2) {
    difference= additionplayer1-additionplayer2;
    System.out.println("player1" + ": " + player1Token);
        System.out.println("player2" + ": " + (player2Token-difference));
    
}

     else  if (additionplayer2<additionplayer1) {
         difference = additionplayer2-additionplayer1;
         System.out.println("player2" + ": " + player2Token);
         System.out.println("player2" + ": " + (player2Token-difference));
}
}

if(player1Token > player2Token) {
				System.out.println("Player 1 wins the set!");
				player1wins++;
			}
			else {
				System.out.println("Player 2 wins the set!");
				player2wins++;
}
				set++;
				
}
}
//int finalToken1=player1Token-difference1;
//int finalToken2=player2Token-difference2;
//System.out.println("player1" + ": " + finalToken1);
//System.out.println("player2" + ": " +  finalToken2);

    
}