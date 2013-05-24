import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class star3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class star3 extends Star
{
    /**
     * Act - do whatever the star3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
                //System.out.println("runing");
        if(Greenfoot.mouseClicked(this)){
            System.out.println("x is:"+this.getX());
            board desk=(board)getWorld();
            //desk.removeObject(this);
            desk.removeStars(this);
            desk.show();
            desk.refresh();
            desk.show();
        }
        // Add your action code here.
    }    
}
