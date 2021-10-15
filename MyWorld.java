import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author ldavoll 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{ 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 400, 1); 
        
        Ball ball = new Ball();
        addObject(ball, 299, 199);
        
        Paddle paddle1 = new Paddle("up", "down");
        addObject(paddle1, 563, 199);
        
        Paddle paddle2 = new Paddle("w", "s");
        addObject(paddle2, 35, 199);
        
        addObject(new Bad_Ball(), 299, 
        Greenfoot.getRandomNumber(400));
    }
}