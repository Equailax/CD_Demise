import java.util.ArrayList;

public class AnimationApp{
    //This is the animation app, where we will run our game.
    
    /*
    Interact with the human player to ask it for a move.
    Move the avatar as specified
    Check if any obstacles are hit.  If so react appropriately.
    Check if any collectibles have been reached.  If so, react appropriately.
    Move any collectibles that are movable.
    */
    /*Ostacle Class
    Variables
        -name: String
        -isDeadly: boolean
        -location: Rectangle
        -health: int

    Methods
        +coordinates(): Rectangle - Return the location
        +obstacleName(): String - Return the obstacle name
        +getHit(projectile:String) - Determine if enemy gets hurt or not
        +checkIfDeadly(): Boolean - Return if the obstacle/deadly or not
        +move(direction:String) - Move in the direction
    */
    /*
    Variables:
        -String Name; - Name of the Avatar.
        -Image Skin; - What the Avatar will look like.
        -Int Health; - How many health points the Avatar can lose at a maximum in a life.
        -Int Lives; - How many times the Avatar can respawn without the game ending. 
        -Int x-position; - Within the Rectangle class, x-coordinate.
        -Int y-position; - Within the Rectangle class, y-coordinate. 
        -Int Damage; - How much damage the Avatar can output.

    Methods:
        -Move(String value): will take a String value as a parameter and will move in the direction given. Can either be Up, Down, Left or Right and will only work if that specific move if possible. (Can’t move past boundaries.)
        -updateHealth(Int value): will take an Int value as a parameter and will change the health of the Avatar to the value given. 
        -getLocation(Rectangle value): will take a Rectangle object from the Rectangle class as a parameter. This is a getter method so it will return the location of the avatar in the given Rectangle object. 
        -shoot(String value): The string value in the parameter will be the direction for where the shot will go. 
        -respawn(): This will allow the Avatar to respawn where they died, as long as they have one life left. 

    */
    
    //Instance variables
    private Avatar minidisc;
    private ArrayList<Collectibles>;
    private ArrayList<Obstacle>;
    
    
    //Methods
    

}