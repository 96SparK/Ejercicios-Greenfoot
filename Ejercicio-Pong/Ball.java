import greenfoot.*;  

public class Ball  extends Actor
{
    private int incx;
    private int espera;
    private int incy;
    private boolean destroy;
    private int scorePlayer1;
    private int scorePlayer2;
    private int maxPts;
    private int dirX;
    private int dirY;
    private int tiempo;
    private boolean ganador;
    private boolean speed;
    private World mundo;
    
    @Override
    public void act() 
    {
        espera = 10;
        incx = 1;
        incy = 1;
        maxPts = 5;
        mundo = getWorld();
        mundo.showText("Player 1: "+scorePlayer1+" pts", 100, 20);
        mundo.showText("Player 2: "+scorePlayer2+" pts", 100, mundo.getHeight()-20);
        mundo.showText("Tiempo: "+(tiempo/100)+" seg",mundo.getWidth()/2 + mundo.getWidth()/3, mundo.getHeight()/2);
        if(tiempo/100 >= 15 && tiempo/100 <= 20 && speed)
        {
            incx = 2;
            incy = 2;
        }
        else if( tiempo/100 >= 21 && tiempo/100 <= 30 && speed)
        {
            incx = 3;
            incy = 3;
        }
        if(tiempo/100 >= 31 && speed)
        {
            incx = 4;
            incy = 4;
        }
        if(this.getY() > mundo.getHeight()-20 || this.getY() < 20)
        {
            if(this.getY() > mundo.getHeight()-20 && scorePlayer1 < maxPts)
            {
                scorePlayer1 += 1;
            }
            if(this.getY() < 20  && scorePlayer2 < maxPts)
            {
                scorePlayer2 += 1;
            }
            destroy = true;
            speed = false;
            dirX = 0;
            dirY = 0;
        }
        if(destroy == false && ganador == false)
        {
            if(dirX == 0 && dirY == 0)
            {
                setDirecc();
            }
            else
            {
                if(this.isTouching(Player2.class) || this.isTouching(Player1.class))
                {
                    setDirecc();
                    speed = true;
                }
            }
            if(this.getX() > 0 && this.getX() < mundo.getWidth())
            {
                if(this.getX() <= 6)
                {
                   dirX = 1;
                   setLocation(this.getX()+incx*dirX,this.getY());
                }
                else 
                {
                    if(this.getX() == mundo.getWidth()-1)
                    {
                        dirX = -1;
                        setLocation(this.getX()+incx*dirX,this.getY());
                    }
                    else
                    {
                        setLocation(this.getX()+incx*dirX,this.getY());
                    }
                }
            }
            if(this.getY() > 0 && this.getY() < mundo.getHeight())
            {
                if(this.getY() == 0)
                {
                   dirY = 1;
                   setLocation(this.getX(),this.getY()+incy*dirY);
                }
                else
                {
                    if(this.getY() == mundo.getHeight()-1)
                    {
                        dirY = -1;
                        setLocation(this.getX(),this.getY()+incy*dirY);
                    }
                    else
                    {
                        setLocation(this.getX(),this.getY()+incy*dirY);
                    }
                }
            }
        }
        else
        {
            if(scorePlayer1 < maxPts && scorePlayer2 < maxPts)
            {
                destroy = false;
                this.setLocation(350,250);
            }
            else
            {
                mundo.showText("Player 1: "+scorePlayer1+" pts", 100, 20);
                mundo.showText("Player 2: "+scorePlayer2+" pts", 100, mundo.getHeight()-20);
                if(scorePlayer1 > scorePlayer2)
                {
                    mundo.showText("Winner Player 1", mundo.getWidth()/2, mundo.getHeight()/2);
                }
                else
                {
                    mundo.showText("Winner Player 2", mundo.getWidth()/2, mundo.getHeight()/2);
                }
                ganador = true;
                Greenfoot.delay(espera*10);
                Greenfoot.stop();
            }
            Greenfoot.delay(espera);
        }
        tiempo+= 1;
    }
    
    private void setDirecc()
    {
        dirX = Greenfoot.getRandomNumber(2);
        dirY = Greenfoot.getRandomNumber(2);
        if(dirX == 0)
        {
            dirX = -1;
        }
        else
        {
            dirX = 1;
        }
        if(dirY == 0)
        {
            dirY = -1;
        }
        else
        {
            dirY = 1;
        }
    }
}
