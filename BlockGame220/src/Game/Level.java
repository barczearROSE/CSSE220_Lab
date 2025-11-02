package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Level extends JComponent{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public final Color BG = Color.BLUE;
	private Player player = new Player(10,10);
	private ArrayList<Collidable> collidables = new ArrayList<Collidable>();
	private Enemy enemy1 = new Enemy(512, 384, 768, 256, 10);
	
	
	public Level() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		collidables.add(player);
		collidables.add(enemy1);
		
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Collidable c : collidables) {
          c.draw(g2); 
        } 
    }
    
    public void moveAll() {
    	for (Collidable c : collidables) {
    		c.move();
    	}
    	
    }
    
    public void rePaint() {
    	repaint();
    }
    
    public void movePlayer(int velocityX) {
    	player.setVx(velocityX);
    	
    }
    
    public void jumpPlayer(int velocityY) {
    	player.setVy(velocityY);
    }
    
    
    
    
    
	

}
