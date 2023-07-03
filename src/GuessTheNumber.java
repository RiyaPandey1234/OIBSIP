//****************************************NUMBER GUESSING GAME**************************************//
import java.util.Scanner;
import java.util.Random;
//////////////////////////Class Game/////////////////
class Game{
    int systemsInput;
    int usersInput;
    int noOfGuesses=0;
    ////////////////////////generating random number in default constructor/////////////////
    Game(){
        Random random=new Random();
        this.systemsInput=random.nextInt(100)+1;
    }
/////////////////to take users guess/////////////////////////
public boolean takeUsersInput(){
        if(noOfGuesses<10){
           System.out.println("Please Guess the Number:"); 
           this.usersInput=GuessTheNumber.takeIntegerInput(100);
           noOfGuesses++;
           return false;
        }
        else{
            System.out.println("Number of all attempts finished  :(  Better luck for next time\n");
            return true;
        }
}    
    ///////////////////////method to check user guess status//////////////////////////
    public boolean isCorrectGuess() {
        if (systemsInput == usersInput) {
            System.out.println("Congrats!!!!!!  :) you guess the number " + systemsInput + "in" + noOfGuesses + "guesses");
            switch (noOfGuesses) {
                case 1:
                    System.out.println("Now Your Score is 100");
                    break;
                case 2:
                    System.out.println("Now Your Score is 90");
                    break;
                case 3:
                    System.out.println("Now Your Score is 80");
                    break;
                case 4:
                    System.out.println("Now Your Score is 70");
                    break;
                case 5:
                    System.out.println("Now Your Score is 60");
                    break;
                case 6:
                    System.out.println("Now Your Score is 50");
                    break;
                case 7:
                    System.out.println("Now Your Score is 40");

                    break;
                case 8:
                    System.out.println("Now Your Score is 30");
                    break;
                case 9:
                    System.out.println("Now Your Score is 20");
                    break;
                case 10:
                    System.out.println("Now Your Score is 10");
                    break;
            }
            System.out.println();
            return true;
        }
    else if(noOfGuesses<10 && usersInput>systemsInput){
        if(usersInput-systemsInput>10){
            System.out.println("Too high");  
        }
        else{
            System.out.println("Little high");
        }
        }
    else if(noOfGuesses<10 && usersInput<systemsInput){
        if(systemsInput-usersInput>10){
            System.out.println("Too low");
        }
        else{
            System.out.println("Little low");
        }
        }
    return false;
    }
}


/////////////////main Class /////////////////////
public class GuessTheNumber {

   // private static Object args;

    public static int takeIntegerInput(int limit){
        int input=0;
        boolean flag=false;
        while(!flag){
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("Chose the number between 1 to" + limit);
                    flag = false;
                }
            }
                catch(Exception e){
                    System.out.println("Enter only Integer value");
                    flag = false;
                }
            };
            return input;
        }
    
    public static void main(String args[]) {
        /////input for start the game/////////////////
        System.out.println("1.start the game \n2.exit");
        System.out.println("Enter your Choice: ");
        int choice = takeIntegerInput(2);
        int nextRound = 1;
        int noOfRound = 0;


        if (choice == 1) {
            ////////////////checking next round is there or not///////////////////////
            while (nextRound == 1) {

                ///////////////create object of game class //////////
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimiteCross = false;
                System.out.println("\n Round" + ++noOfRound + "starts.....");

                //////////To Currect correct guess and limit cross ////////////
                while (!isMatched && !isLimiteCross) {
                    isLimiteCross = game.takeUsersInput();
                    isMatched = game.isCorrectGuess();

                }
                /////////////////input for next round///////////////////
                System.out.println("1.Next Round \n2.Exit");
                System.out.println("Enter your choice: ");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}




