import java.awt.Point;

public class Controller 
{
    Model model;
    private boolean whosGo=false; 
    
    public Controller()
    {
    	// default constructor
    }

    public void setup(Model model)
    {
        this.model = model;
    }

    public void playermove(Point point)
    {
        model.movePlayer(point);
    } 
} 
