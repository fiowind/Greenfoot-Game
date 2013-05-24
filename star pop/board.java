import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class board extends World
{
    private int total;
    public int [][]startable=new int[10][7];
    public Star [][]start=new Star[10][7];
    /**
     * Constructor for objects of class board.
     * 
     */
    public board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(7, 10, 60); 
        total = getWidth()*getHeight();
        populate();
    }
    
    public void populate(){
        for(int i=0;i<getHeight();i++){
            for(int j=0;j<getWidth();j++){
                int k = Greenfoot.getRandomNumber(4);
                System.out.println(k);
                startable[i][j] = k+1;
                addStar(k, j, i);
            }
        }
    }
    public void addStar(int k,int j,int i){
        Star s=null;
        if(k==0)
            s=new star1();
        else if(k==1)
            s=new star2();
        else if(k==2)
            s=new star3();
        else if(k==3)
            s=new star4();
        addObject(s, j, i);
        start[i][j]=s;
    }
    
    public void removeStars(Star s){
        int j=s.getX();
        int i=s.getY();
        System.out.println(i+","+j);
        removeObject(start[i][j]);
        //show();
        start[i][j]=null;
        int ys=startable[i][j];
        System.out.println("ys:"+ys);
        startable[i][j]=0;
        if(i>0&&startable[i-1][j]==ys){
            removeStars(start[i-1][j]);
            startable[i-1][j]=0;
            start[i-1][j]=null;
        }
        if(i<9&&startable[i+1][j]==ys){
            removeStars(start[i+1][j]);
            startable[i+1][j]=0;
            start[i+1][j]=null;
        }
        if(j>0&&startable[i][j-1]==ys){
            removeStars(start[i][j-1]);
            startable[i][j-1]=0;
            start[i][j-1]=null;
        }
        if(j<6&&startable[i][j+1]==ys){
            removeStars(start[i][j+1]);
            startable[i][j+1]=0;
            start[i][j+1]=null;
        }    

    }
    
    public void show(){
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<7;j++){
                System.out.print(startable[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void refresh(){
        int l=getWidth();
        int h=getHeight();
        System.out.println("l"+l+"h"+h);
        int count;
        //列上的合并
        for(int j=0;j<l;j++){
            count = 0;int i=0;
            while(i==9||startable[i++][j]!=0) {break;}//j列上第一个不空的对象在i行
            i--;
            int ii=i;
            System.out.println("这是第"+j+"列，第"+i+"行，是第一个该列不空的对象，现在对它进行下井。");
            for(;i<h;i++){
                if(startable[i][j]==0){
                    System.out.println("在该列找到一个空对象，他在"+i+"行");
                    int k=i;
                    System.out.println("i"+i+" j"+j);
                    while(true){
                        if(k>9) break;
                        if(startable[k][j]!=0) break;
                        count++;
                        k++;
                    }//有count个连续空块,k-1是最下面的空对象
                   System.out.println("count:"+count);
                    int cc=k-count-1;  //把cc上面的块都下移count步,包括cc的
                    System.out.println("现在把"+cc+"行上的块都下移"+count+"步");
                    for(;cc>=0&&startable[cc][j]!=0;cc--){
                        startable[cc+count][j]=startable[cc][j];
                        start[cc+count][j] = start[cc][j];
                        start[cc][j].turnTowards(j,10);
                        start[cc][j].move(count);
                    }
                    show();
                    //改变移动后上方的空块
                    int ccc=ii;
                    while(count!=0) {
                        startable[ccc][j]=0;
                        start[ccc][j]=null;
                        count--;
                        ccc++;
                    }
                    i=ccc;
                }
            }
            System.out.println("消第"+j+"列");
            show();
        }
        
    }


}
