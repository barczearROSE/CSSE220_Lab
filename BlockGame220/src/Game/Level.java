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
	public static int level = 1;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public final Color BG = Color.WHITE;
	protected Player player = new Player(10,10);
	private Platform bottom = new Platform(0,768-10,1024,10);
	private Platform other = new Platform(100,500,200,50);
	private ArrayList<Collidable> collidables = new ArrayList<Collidable>();
	private Enemy enemy1 = new Enemy(512, 384, 768, 256);
	private Collectible col1 = new Collectible(300, 200);
	
	
	
	public Level() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		collidables.add(player);
		collidables.add(bottom);
		collidables.add(enemy1);
		collidables.add(other);
		collidables.add(col1);
	}
	
	public Level(ArrayList<Collidable> levelSet) {
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		collidables = levelSet;
		this.player = (Player)collidables.get(0);
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
    }

    
    public void movePlayer(int velocityX) {
    	player.setVx(velocityX);
    	
    }
    
    public void jumpPlayer(int velocityY) {
    	player.setVy(velocityY);
    }
    
    public void collect() {
    	player.setCollect(true);
    	collide();
    	player.setCollect(false);
    }
    
    public void checkBounds() {
    	if(player.getX()>=WIDTH) {
    		player.setX(0);
    	}else if(player.getX() < 0) {
    		player.setX(WIDTH);
    	}
    	if(player.getY()>=HEIGHT) {
    		player.setY(0);
    	}else if(player.getY() < 0) {
    		player.setY(HEIGHT);
    	}
    }
    
    
    
    public void setLevel(ArrayList<Collidable> levelSet){
    	
    	this.collidables = levelSet;
    	this.player = (Player)levelSet.get(0);
    }
    
	

}
