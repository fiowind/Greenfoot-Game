import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private long startTime;
    private long currentTime;
    private int speed=1;
    private boolean stop=false;
    public void act() 
    {
        // Add your action code here.
        if(stop){}else{
            if(startTime==0){
                startTime=System.currentTimeMillis();
            }
            currentTime = System.currentTimeMillis();
            int dif = (int)(startTime - currentTime);
            if(dif%10==0){
                setLocation(getX()+speed,getY());
            }
        }
    }    
    public void addSpeed(int s){
        speed += s;
    }
    public void stop(){
        stop=true;
    }
    public void go(){
        startTime = 0;
        stop = false;
    }
}
