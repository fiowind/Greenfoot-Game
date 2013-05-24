import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * Write a description of class Words here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Words extends Actor
{
    /**
     * Act - do whatever the Words wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private String text;
    private int stringLength;
    public Words(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 5) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font
        
        updateImage();
    }
    public void act() 
    {
        // Add your action code here.
    }    
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text , 1, 18);
    }
}
