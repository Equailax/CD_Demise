import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Point;
import java.lang.Math;

public class Projectile extends Obstacle{
    
    //Instance variables
    private boolean isDeadlyToAvatar = false;
    private boolean isDeadlyToEnemy = false;
    
    //Constructors
    public Projectile(){}
    
    public Projectile(String name, boolean deadlyToAvatar, boolean deadlyToEnemy){
        super.setName(name);
        this.isDeadlyToAvatar = deadlyToAvatar;
        this.isDeadlyToEnemy = deadlyToEnemy;
    }
    
    public Projectile(Projectile projectileToCopy){
        super.setName(projectileToCopy.getName());
        this.isDeadlyToAvatar = projectileToCopy.getDeadlyToAvatar();
        this.isDeadlyToEnemy = projectileToCopy.getDeadlyToEnenmy();
        super.setLocation(projectileToCopy.getLocation());
    }
    
    //Getter methods
    /**
    This method gets the isDeadlyToAvatar instance variable
    @return isDeadlyToAvatar
    */
    public boolean getDeadlyToAvatar(){
        return this.isDeadlyToAvatar;
    }
    
    /**
    This method gets the isDeadlyToEnemy instance variable
    */
    public boolean getDeadlyToEnenmy(){
        return this.isDeadlyToEnemy;
    }
    
    
    //Setter methods
    /**
    This sets wether or not the projectile is deadly to the avatar
    @param deadlyToAvatar : it is either deadly to the avatar (true) or not deadly (false)
    */
    public void setIsDeadlyToAvatar(boolean deadlyToAvatar){
        this.isDeadlyToAvatar = deadlyToAvatar;
    }
    
    /**
    This sets wether or not the porjectile is deadly to the enemy
    @param deadlyToEnemy : it is either deadly to the enemy (true) or not deadly (false)
    */
    public void setIsDeadlyToEnemy(boolean deadlyToEnemy){
        this.isDeadlyToEnemy = deadlyToEnemy;
    }
    
    
}