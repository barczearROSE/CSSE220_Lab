package Game;
/**
 * Represents an enemy character in the game.
 *
 * Moves horizontally between a minimum and maximum distance.
 */

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Collidable {

	private BufferedImage sprite;
	private boolean spriteLoaded = false;
	private int maxDist;
	private int minDist;
	private int speed = 10;
	
	public Enemy(int X, int Y, int maxDist, int minDist) {
		super(X, Y,40);
		this.maxDist = maxDist;
		this.minDist = minDist;
		try {
            sprite = ImageIO.read(Enemy.class.getResource("emeny.png"));
            spriteLoaded = (sprite != null);
        } catch (IOException | IllegalArgumentException ex) {
            spriteLoaded = false; // fallback to oval
        }
	}
	
	public void move() {
		if(this.X + this.speed >= this.maxDist ) {
			speed = speed * -1;
			this.X = this.maxDist - 1;
			
		}
		if( X - speed <= minDist) {
			speed = speed * -1;
			this.X = this.minDist + 1;
		}
		this.X += speed;
		this.boundingBox.setBounds(X, Y, this.scale, this.scale);
	};
	
	@Override
	public void draw(Graphics2D g2) {
        if (spriteLoaded & this.speed >=0) {
        	g2.drawImage(sprite, X+this.scale, Y, -this.scale, this.scale, null);
        }else if (spriteLoaded) {   
    	    g2.drawImage(sprite, X, Y, this.scale, this.scale, null);
    	}
	}

}

