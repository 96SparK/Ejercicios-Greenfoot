import greenfoot.*;

public class Player1  extends Actor
{
    private int distance;
    @Override
    public void act() 
    {
        distance = 10;
        World mundo = getWorld();
        if(this.getX() < mundo.getHeight()+150 && Greenfoot.isKeyDown("s"))
        {
            setLocation(getX()+distance,getY());
        }
        if(this.getX() > 50 && Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-distance,getY());
        }
    }
}
