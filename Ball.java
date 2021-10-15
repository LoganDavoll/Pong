import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Ball here.
 * 
 * @author ldavoll 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private int dX = 2;
    private int dY = 2;
    private int Score1 = 0;
    private int Score2 = 0;
    GifImage myGif = new GifImage("Scavenger-Bot_Walking (BiggerVer.).gif");
    /**
     * It tells the Ball what it needs to do and how to do it.
     */
    public void act()
    {
        setImage( myGif.getCurrentImage() );
        move();
        checkForBounce();
        score();
        bouncePaddle();
    }
    /**
     * This tells it how to move.
     */
    public void move()
    {
        setLocation(getX() + dX, getY() + dY);
    }
    /**
     * This tells the ball what to do if it encounters a paddle.
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
    }
    /**
     * This keeps sticky paddles from occuring.
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
     * This tells it how and when to add a point to a certain player.
     */
    public void score()
    {
        if( getX() >= 568 )
        {
            setLocation(299, 199);
            Score1++;
            Greenfoot.playSound("Score.wav");
            Greenfoot.delay(20);
        }
        
        if( getX() <= 30 )
        {
            setLocation(299, 199);
            Score2++;
            Greenfoot.playSound("Score.wav");
            Greenfoot.delay(20);
        }
        
        if(Score1 == 8)
        {
            getWorld().showText("Player 1 WINS", 299, 293);
            setImage("game_over.png");
            Greenfoot.stop();
        }
        
        if(Score2 == 8)
        {
            getWorld().showText("Player 2 WINS", 299, 293);
            Greenfoot.playSound("Win.wav");
            setImage("game_over.png");
            Greenfoot.stop();
        }
    }
}