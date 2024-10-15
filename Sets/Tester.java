
/**
 * A class that runs tests on individual aspects of the lottery class, it also holds the main method
 *
 * Eliza
 * 10/02/2024
 */
public class Tester
{
    Lottery l = new Lottery();
    /**
     * a variable that holds the max number
     */
    int max;
    
    /**
     * the main method
     * holds commented code that can be used to test individual methods from the lottery class
     * currently runs the menu method that runs the whole lottery
     */
    public static void main (String args[])
    {
        Tester t = new Tester();
        /* To test each method individually
         System.out.println("Testing Range");
        t.testRange();
        System.out.println("Testing Lottery Num");
        t.testLotteryNum();
        System.out.println("Testing Player Num");
        t.testPlayerNum();
        System.out.println("Testing Matching numbers");
        t.testChecks();
        System.out.println("Testing Winnings");
        t.testWinnings(); 
        System.out.println("Testing Weeks");
        t.testWeeks(); 
        t.testLottery();*/
        t.testMenu();
    }
    
    /**
     * a method that tests the lottery range
     */
    public void testRange()
    {
        max = l.lotteryRange();
        //A test for entering the max value
        System.out.println("You entered " + max);
    }
    
    /**
     * a method that tests that the max number actually works in the lottery number method
     * and that the lottery numbers are being added to the set correctly
     */
    public void testLotteryNum()
    {
        l.lotteryNumbers(max);
        //a test for adding the numbers to the set
        //System.out.println(lottery_num);
    }
    
    /**
     * a method that tests that the player numbers are being added to the set correctly
     */
    public void testPlayerNum()
    {
        l.playerNumbers();
        //a test for adding the numbers to the set
        //System.out.println(player_num);
    }
    
    /**
     * a method that checks that the sets are being added and copied correctly
     * and that the size of the matching set is being calculated correctly
     */
    public void testChecks()
    {
        l.checkSets();
        //check the matching has copied correctly
        //System.out.println("Matching set" + matching);
        //test check all the sets have been done correctly
        //System.out.println("Player set" + player_num);
        //System.out.println("Lottery set" + lottery_num);
        //System.out.println("Matching set" + matching);
        //System.out.println("There are " + matching.size() + " matching numbers");
    }
    
    /**
     * a method to check the winnings works
     */
    public void testWinnings()
    {
        l.winnings();
    }
    
    /**
     * a method to check the user input of weeks works
     */
    public void testWeeks()
    {
        l.weeks();
        //System.out.println(weeks);
    }
    
    /**
     *  a method that checks that the lottery works as a whole
     */
    public void testLottery()
    {
        l.lottery();
    }
    
    /**
     * a method that tests the menus
     */
    public void testMenu()
    {
        l.menu();
    }
   }
