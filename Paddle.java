import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author ldavoll 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    private String upKey;
    private String downKey;
    private int moveUp = -8;
    private int moveDown = 8;
    public Paddle(String upKey, String downKey)
    {
        this.upKey = upKey;
        this.downKey =downKey;
    }
    
    public void act()
    {
        checkKeys();
    }
    
    public void checkKeys()
    {
        if(Greenfoot.isKeyDown(upKey))
        {
            setLocation(getX() ,getY() + moveUp);
        }
        
        if(Greenfoot.isKeyDown(downKey))
        {
            setLocation(getX() ,getY() + moveDown);
        }
    }
}
