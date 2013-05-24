import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck extends World
{

    /**
     * Constructor for objects of class Deck.
     * 
     */
    private int total;
    private Counter counter = new Counter("Score:");
    private int guanshu=1;
    private Bee bee = new Bee();
    private Counter No = new Counter("No.");
    Words words = new Words( "点击笑脸进入下一关！");
    public Deck()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 530, 1); 
        total= 24;
        setupStage();
        populate();
        //addObject(words,270,50);
    }
    public void act(){
        if(bee.getX()>520){
            GameOver();
        }
        //Greenfoot.playSound("music.wav");
    }
    public void populate(){
        addObject(counter,540,30);
        addObject(new Ender(),540,500);
        addObject(bee,40,500);
        No.add(1);
        addObject(No,60,30);
    }
    public void chushi(){
        No.add(1);
        bee.setLocation(40,500);
        total = 24;
        setupStage();
        bee.addSpeed(1);
        bee.go();
    }
    public void setupStage(){
        int rows = 4;
        int cols = 6;
        int n = rows*cols;
        int width = 50;
        int height = 100;
        
        String[] questions = {"A","B","C","D","E","F","G","H","I","J","K","L"};
        String[] answers={"AA","BB","CC","DD","EE","FF","GG","HH","II","JJ","KK","LL"};
        
        int countQ=0;
        int countA=11;
        
        for(int i=0;i<n;i++){
            int half = Greenfoot.getRandomNumber(2);
            if(i%cols==0&&i!=0){
                width=50;
                height+=100;
            }
            if(half==0){
                if(countQ<12){
                    Card card = new Card(countQ,questions[countQ]);
                    addObject(card,width,height);
                    countQ++;
                }else{
                    Card card = new Card(countA,answers[countA]);
                    addObject(card,width,height);
                    countA--;
                }
            }else{
                if(countA>=0){
                    Card card = new Card(countA,answers[countA]);
                    addObject(card,width,height);
                    countA--;
                }else{
                    Card card = new Card(countQ,questions[countQ]);
                    addObject(card,width,height);
                    countQ++;
                }
            }
            width+=100;
            
        }
    }
    private Card selected;
    public void matchCard(Card card){
        if(selected==null){
            selected = card;
        }else{
            checkWin();
            Greenfoot.delay(15);
            if(selected.getIndex()==card.getIndex()){
                removeObject(card);
                removeObject(selected);
                total -= 2;
                counter.add(guanshu*10);
                Greenfoot.playSound("explosion.wav");
                checkWin();
            }else{
                card.flipCard();
                selected.flipCard();
                selected=null;
            }
            selected = null;
        }
    }
    
    public void checkWin(){
        if(total==0){
            WinCard card = new WinCard();
            
            addObject(card,300,220);
            addObject(words,270,50);
            bee.stop();
            
            //Greenfoot.stop();
        }
    }
    public void GameOver(){
         Greenfoot.playSound("buzz.wav");
        addObject(new ScoreBoard(counter.getScore()), getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
    
    public void next(WinCard card){
        guanshu++;
        removeObject(card);
        removeObject(words);
        chushi();
    }
}
