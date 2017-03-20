import greenfoot.*;  

public class PongWorld  extends World
{
    public PongWorld()
    {    
        super(700, 500, 1);
        setBackground(new GreenfootImage("scene.jpg"));
        
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        Ball ball = new Ball();
        addObject(player1, 350, 30);
        addObject(player2, 350, 470);
        addObject(ball, 350, 250);
    }
}
