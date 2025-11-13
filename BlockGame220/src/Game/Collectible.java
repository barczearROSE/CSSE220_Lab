package Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents a collectible item in the game.
 */

public class Collectible extends Collidable {
	
	private BufferedImage sprite;
	private boolean spriteLoaded = false;
	private boolean collected = false;

	public Collectible(int X, int Y) {
		super(X, Y,50);
		try {
            sprite = ImageIO.read(Collectible.class.getResource("collectble!.png"));
            spriteLoaded = (sprite != null);
        } catch (IOException | IllegalArgumentException ex) {
            spriteLoaded = false; // fallback to oval
        }
	}
	
	@Override
	public void draw(Graphics2D g2) {
        if (spriteLoaded == true & collected == false) {
    	    g2.drawImage(sprite, X, Y, this.scale, this.scale, null);
    	}
	}
	
	public void setCollected(boolean b) {
		this.collected = b;
	}
	public boolean getCollected() {
		return this.collected;
	}
	
	

}
