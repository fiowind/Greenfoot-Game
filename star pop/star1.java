import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class star1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class star1 extends Star
{
    /**
     * Act - do whatever the star1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            System.out.println("x is:"+this.getX());
            board desk=(board)getWorld();
            //desk.removeObject(this);
            desk.removeStars(this);
            desk.refresh();
        }
        // Add your action code here.
    }    
}
