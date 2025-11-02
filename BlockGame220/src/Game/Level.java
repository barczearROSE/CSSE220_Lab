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
	public static final Color BG = Color.BLUE;
	private Player player = new Player(10,10);
	private ArrayList<Collidable> collidables = new ArrayList<Collidable>();
	
	
	public Level() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		collidables.add(player);
		
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
//        for (Collidable c : collidables) {
//          c.draw(g2); 
//        } 
    }
    
    public void moveAll() {
    	for (Collidable c : collidables) {
    		c.move();
    	}
    	
    }
    
    public void repaint() {
    	repaint();
    }
    
    public void movePlayer(int velocityX) {
    	player.setVx(player.getVx() + velocityX);
    	
    }
    
    public void jumpPlayer(int velocityY) {
    	player.setVy(player.getVy() + velocityY);
    }
    
    
    
    
    
	

	
}
