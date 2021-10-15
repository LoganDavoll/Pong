import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Ball here.
 * 
 * @author ldavoll 
 * @version (a version number or a date)
 */
public class Bad_Ball extends Actor
{
    private int dX = 2;
    private int dY = 2;
    private int Score1 = 0;
    private int Score2 = 0;
    GifImage myGif = new GifImage("Broken_Scavenger-Bot_Walking (BiggerVer.).gif");
    /**
     * It tells the Bad_Ball what it needs to do and how to do it.
     */
    public void act()
    {
        setImage( myGif.getCurrentImage() );
        move();
        checkForBounce();
        incinerate();
        bouncePaddle();
    }
    /**
     * Tells it how to move.
     */
    public void move()
    {
        setLocation( getX() + dX, getY() + dY);
    }
    /**
     * Tells it how to bounce off paddles, but if it does bounce off a
     * paddle it will take away a point from the person whose paddle it
     * bounced off of.
     */
    public void checkForBounce()
    {
        if(getX() <= 0 || getX() >= getWorld().getWidth()-1)
        {
            dX = -dX;
        }
        
        if(getY() <= 0 || getY() >= getWorld().getHeight()-1)
        {
            dY = -dY;
        }
        
        if(isTouching(Paddle.class) && getX() <= 60)
        {
            Score1--;
        }
        
        if(isTouching(Paddle.class) && getX() <= 535)
        {
            Score2--;
        }
    }
    /**
     * Stops the sticky paddle.
     */
    public void bouncePaddle()
    {
        if(isTouching(Paddle.class) && getX() <= 60)
        {
           dX = 15;
           move();
           dX = 2;
           Greenfoot.playSound("Ball_hit.wav");
        }
        
         if(isTouching(Paddle.class) && getX() >= 535)
        {
           dX = -15;
           move();
           dX = -2;
           Greenfoot.playSound("Ball_hit.wav");
        }
    }
    /**
     * Tells it how to Incinerate, its one perpose.
     */
    public void incinerate()
    {
        if( getX() >= 568 )
        {
            setLocation(299, Greenfoot.getRandomNumber(400));
            Greenfoot.playSound("Incinerate.wav");
        }
        
        if( getX() <= 30 )
        {
            setLocation(299, Greenfoot.getRandomNumber(400));
            Greenfoot.playSound("Incinerate.wav");
        }
    }
}