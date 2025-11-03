package Game;
/**
 * Represents a single level of the game.
 *
 * This class manages the player, platforms, enemies, and 
 * collectible objects. It handles drawing, movement, and simple
 * collision logic.
 */

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
	public final Color BG = Color.WHITE;
	private Player player = new Player(10,10);
	private Platform bottom = new Platform(0,768-10);
	private ArrayList<Collidable> collidables = new ArrayList<Collidable>();
	private Enemy enemy1 = new Enemy(512, 384, 768, 256);
	
	
	public Level() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		collidables.add(player);
		collidables.add(bottom);
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
    
    public void collide() {
    	for(Collidable c : collidables) {
    		for(Collidable k : collidables) {
    			if(c!=k) {
    				c.collide(k);
    			}
    		}
    	}
    	if(player.boundingBox.intersects(bottom.boundingBox)) {
    		player.setY(bottom.getY() - player.boundingBox.height);
    	}
    }

    
    public void movePlayer(int velocityX) {
    	player.setVx(velocityX);
    	
    }
    
    public void jumpPlayer(int velocityY) {
    	player.setVy(velocityY);
    }
    
    
    
    
    
	

}
