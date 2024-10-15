import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;
/**
 * A class that holds the methods resposible for creating the lottery and running the lottery
 *
 * Eliza
 * 10/02/2024
 */
public class Lottery
{
    // Set up the lottery and player sets
    /**
     * Setting up the lottery and player number sets
     */
    private Set<Integer> lottery_num = new HashSet<Integer>();
    private Set<Integer> player_num = new HashSet<Integer>();
    //fields
    /**
     * The variables for the max number, the matching numbers, the winnings, the weeks,
     * the tickets and total winnings
     */
    private int max;
    private int matching_num;
    private int winnings;
    private int weeks;
    private int tickets;
    private int total_win;
    
    /**
     * a method that takes in the user's inputted range and stores it in the variable max
     * @return the maximum value
     */
    //a method for player's inputed range
    public int lotteryRange()
    {
        //display message
        System.out.println("Please enter the maximum number for the lottery");
        //Scanner to take in user input and assign to variable max
        Scanner s = new Scanner(System.in);
        max = s.nextInt();
        //loops if the max isn't long enough and takes in user input until it is long enough
        while (max<=6)
            {
                //display error message
                System.out.println("Please enter a number greater than 6");
                //take in another number
                max = s.nextInt();
            }
        return max;
    }
    
    /**
     * a method that randomly generates 6 numbers within the range and adds them to the lottery number set
     * @param the maximum number
     */
    //a method to generate the lottery numbers randomly 
    public void lotteryNumbers(int max)
    {
        //use random class
        Random randGenerator = new Random();
        //clear the set before adding numbers again
        lottery_num.clear();
        //used for the loops
        int i;
        //a for loop that will run 6 times to generate 6 numbers
        for (i=0; i<6; i++)
        {
            //assign the random numbers to the variable lotterynumbers and use the max variable as an upper limit
            int lotterynumbers = randGenerator.nextInt(max);
            //a while loop to check that the number doesn't already exist
            while (lotterynumbers<0 || lotterynumbers>max || lottery_num.contains(lotterynumbers))
            {
                //regenerate the number
                lotterynumbers = randGenerator.nextInt(max);
            }
            //add the new lottery number to the lottery_num set
            lottery_num.add(lotterynumbers);
        }
    }
    
    /**
     * a method that takes in the user's input 6 times and adds it to the player number set
     */
    //a method to generate the player numbers
    public void playerNumbers()
    {
        //display message 
        System.out.println("Please input your numbers");
        //used for the loops
        int i;
        //a for loop that will run 6 times to generate 6 numbers
        for (i=0; i<6; i++)
        {
            //take in user input for their players numbers
            Scanner s = new Scanner(System.in);
            int num = s.nextInt();
            while (num<0 || num>max || player_num.contains(num))
            {
                //display error message
                System.out.println("Please enter a valid number within the range of 0-" + max);
                //take in another number
                num = s.nextInt();
            }
            //add the new number to the player_num set
            player_num.add(num);
        }
    }   
    
    /**
     * a method that cross references a copy of the player number set and lottery number set
     * it removes all the non-matching numbers from the copy player set
     * then it stores the amount of numbers remaining in the matching_num variable
     */
    //a method to check if the sets match
    public void checkSets()
    {
        //a copy set of the player_num
        Set<Integer> matching = new HashSet<Integer>(player_num);
        //co-reference the copy of player_num and lottery_num to only contain the matching numbers
        matching.retainAll(lottery_num);
        //create a variable to hold the size of the matching set
        matching_num = matching.size();
    }
    
    /**
     * a method that uses the matching_num variable to tell how much winnings the player should get
     * uses if and else if statements to achieve this
     */
    //a method to decide the winnings
    public void winnings()
    {
        if (matching_num == 0)
        {
            System.out.println("Player set" + player_num);
            System.out.println("Lottery set" + lottery_num);
            System.out.println("There are 0 matching numbers");
        }
        else if (matching_num == 1 )
        {
            System.out.println("Player set" + player_num);
            System.out.println("Lottery set" + lottery_num);
            System.out.println("There is 1 matching number");
        }
        else if (matching_num == 2 )
        {
            System.out.println("Player set" + player_num);
            System.out.println("Lottery set" + lottery_num);
             System.out.println("There are 2 matching numbers");
        }
        else if (matching_num == 3 )
        {
            System.out.println("Player set" + player_num);
            System.out.println("Lottery set" + lottery_num);
            System.out.println("There is 3 matching numbers");
            winnings += 25;
        }
        else if (matching_num == 4)
        {
            System.out.println("Player set" + player_num);
            System.out.println("Lottery set" + lottery_num);
            System.out.println("There are 4 matching numbers");
            winnings += 100;
        }
        else if (matching_num == 5)
        {
            System.out.println("Player set" + player_num);
            System.out.println("Lottery set" + lottery_num);
            System.out.println("There are 5 matching numbers");
            winnings += 1000;
        }
        else if (matching_num == 6)
        {
            System.out.println("Player set" + player_num);
            System.out.println("Lottery set" + lottery_num);
            System.out.println("JACKPOT!");
            System.out.println("There are 6 matching numbers");
            winnings += 1000000;
        }
    }
    
    /**
     * a method that allows the player to enter the number of weeks they want to use the same player number
     */
    //a method that allows the player to use their numbers mutiple times
    public void weeks()
    {
        System.out.println("How many weeks do you want to run the lottery?");
        Scanner s = new Scanner(System.in);
        weeks = s.nextInt();
    }
    
    /**
     * a method that combines all the previous methods to actually run the lottery
     * includes a ticket variable which allows for the price of the tickets to be subtracted from the total
     */
    //a method to run the lottery
    public void lottery()
    {
        weeks();
        //tickets cost 2 so the price of tickets in the number of weeks times 2
        tickets = 2*weeks;
        if (weeks == 1)
        {
            lotteryRange();
            playerNumbers();
            lotteryNumbers(max);
            checkSets();
            winnings();
            total_win = winnings - tickets;
            System.out.println("Your total winnings is £" + total_win);
        }
        
        else if (weeks > 1)
        {
            lotteryRange(); 
            playerNumbers();
            int i;
            for (i=0 ; i<weeks ; i++)
            {
             lotteryNumbers(max);
             checkSets();
             winnings();
            }
            int total_win = winnings - tickets;
            System.out.println("Your total winnings is £" + total_win);
        }
        else if (weeks < 1)
        {
            System.out.println("Please enter a valid number of weeks");
            lottery();
        }
        //asking the user if they want to return to menu or quit program
        returnToMenu();
    }
    
    /**
     * a method that displays a starting menu to the player
     */
    //a method to create a menu
    public void menu()
    {
        System.out.println("Lottery");
        System.out.println("Please enter 1 to start the lottery");
        System.out.println("Or 2 to leave the lottery");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        if (input == 1)
        {
            lottery();
        }
        else if (input == 2)
        {
            System.out.println("Goodbye!");
        }
        else if ( input < 1 || input > 2)
        {
            System.out.println("Please enter a valid menu number");
            menu();
        }
    }
    
    /**
     * a method that displays a menu that will return to the menu or quit the program
     */
    //a method for a return to menu option
    public void returnToMenu()
    {
        System.out.println("Would you like to return to the menu?");
         System.out.println("1- Yes");
         System.out.println("2- No");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        if (input == 1)
        {
            menu();
        }
        else if (input == 2)
        {
            System.out.println("Goodbye!");
        }
        else if (input < 1 || input > 2)
        {
            System.out.println("Please enter a valid menu number");
            returnToMenu();
        }
    }
}
