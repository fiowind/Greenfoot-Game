import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinCard extends Actor
{
    /**
     * Act - do whatever the WinCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Deck deck = (Deck) getWorld();
            deck.next(this);
        }
        // Add your action code here.
    }    
}
