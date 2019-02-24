import java.util.Scanner;
public class Demo1{
    public static void main(String[] args){
        int movements = 0;
        
        AnimationApp mainApp = new AnimationApp();
        
        //Initialize the game (obtacle, collectible, and avatar positions)
        mainApp.initialize();
        
        //The first argument sets the amount of lives
        Avatar inputAvatar = new Avatar();
        inputAvatar.setName("Minidisc");
        int livesCount = Integer.parseInt(args[0]);
        inputAvatar.setLives(livesCount);
        mainApp.setAvatar(inputAvatar);
        
        //The second argument sets the amount of health
        int healthCount = Integer.parseInt(args[1]);
        inputAvatar.setHealth(healthCount);
        mainApp.setAvatar(inputAvatar);
        
        
        //While the number of allowed movements is less than the required ammount (10), play a turn of the game
            //Might add condition of 'winning' where they collect all 5 collectibles
        while (movements < 30){
            
             //Print the current state
            mainApp.printCurrentState();
            
            //Prompt the user for a movement
            System.out.print("Move UP, DOWN, LEFT, RIGHT: ");
            Scanner movementInput = new Scanner(System.in);
            
            //Check if the input is valid
            boolean check = false;
            String input = "";
            
            while (!check){
                input = movementInput.nextLine();
                
                if(input.toLowerCase().equals("up") || input.toLowerCase().equals("down") || input.toLowerCase().equals("left") || input.toLowerCase().equals("right")){
                    check = true;
                    break;
                }else{
                    System.out.print("Invalid input, please type either UP, DOWN, LEFT, or RIGHT: ");
                }
            }
            
            movements += 1;
            
            //Process if the avatar can move 
            mainApp.processAvatarMove(input);
            
            //Move obstacles accordingly (make sure to not overlap with avatar)
            mainApp.processObstacleMove();
            
            //Check if the player has run out of health
            if(mainApp.getAvatar().getHealth() <= 0){
                System.out.println("O-Oh, I have ran out of health!");
                System.out.println("Lost 1 Life");
                
                Avatar checkLivesAvatar = new Avatar(mainApp.getAvatar());
                int newLife = mainApp.getAvatar().getLives() - 1;
                checkLivesAvatar.setLives(newLife);
                mainApp.setAvatar(checkLivesAvatar);
                
                if (mainApp.getAvatar().getLives() <= 0){
                    System.out.println("Womp-womp, game over :(");
                    break;
                }
                
            }
            
            //Check if end condition is met (number of turns lets say)
            //Or if they collected all of the collectibles
            if (mainApp.getCollectiblesArray().size() == 0){
                System.out.println("You collected all of the Collectibles!");
                
                break;
            }
            
        }
        
        if (movements == 30){
            System.out.println("Ran out of moves!");
        }
        
        System.out.println("End of Demo1");
    }
}