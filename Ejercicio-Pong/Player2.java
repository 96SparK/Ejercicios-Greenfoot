import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Player2 extends Actor
{
    private int distance;
    @Override
    public void act() 
    {
        distance = 10;
        World mundo = getWorld();
        if(this.getX() < mundo.getHeight()+150 && Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+distance,getY());
        }
        if(this.getX() > 50 && Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-distance,getY());
        }
    }
}
