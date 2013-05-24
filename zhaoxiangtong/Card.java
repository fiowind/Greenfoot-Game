import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    /**
     * Act - do whatever the Card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int index;
    private GreenfootImage frontImage;
    private GreenfootImage backImage;
    private boolean flipped;
    public Card(int n,String name){
        index=n;
        flipped = false;
        this.frontImage = new GreenfootImage(name+".jpg");
        this.backImage = new GreenfootImage("redflip.jpg");
        setImage(backImage);
    }
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            flipCard();
        }
    }   
    public void flipCard(){
        if(!flipped){
                setImage(frontImage);
                flipped = true;
                Greenfoot.playSound("pop.wav");
                Deck deck = (Deck)getWorld();
               deck.matchCard(this);
            }else{
                flipped=false;
                setImage(backImage);
            }
    }
    public int getIndex(){
        return index;
    }
}
