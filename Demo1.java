import java.util.Scanner;
public class Demo1{
    public static void main(String[] args){
        int movements = 0;
        
        AnimationApp mainApp = new AnimationApp();
        
        //Initialize the game (obtacle, collectible, and avatar positions)
        mainApp.initialize();
        
        //While the number of allowed movements is less than the required ammount (10), play a turn of the game
            //Might add condition of 'winning' where they collect all 5 collectibles
        while (movements < 10){
        
        //Prompt the user for a movement
        System.out.print("Move UP, DOWN, LEFT, RIGHT:");
		Scanner movementInput = new Scanner(System.in);
        
        String input = movementInput.nextLine();
        movements += 1;
        
        //Process if the avatar can move 
        mainApp.processAvatarMove(input);
        
        //Move obstacles accordingly (make sure to not overlap with avatar)
            //Update positions of all obstacles in arraylist

        //Print the current state
        mainApp.printCurrentState();

        //Draw the current state

        //Check if end condition is met (number of turns lets say)
        }
    }
}