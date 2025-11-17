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
	private int type;
//	private int playerX;
	private int playerY;
	
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
		this.type = 0;
		this.playerX = 0;
		this.playerY = 0;
	}
	
	public Enemy(int X, int Y, int maxDist, int minDist, int type) {
		super(X, Y,40);
		this.maxDist = maxDist;
		this.minDist = minDist;
		try {
            sprite = ImageIO.read(Enemy.class.getResource("emeny.png"));
            spriteLoaded = (sprite != null);
        } catch (IOException | IllegalArgumentException ex) {
            spriteLoaded = false; // fallback to oval
        }
		this.type = type;
		this.playerX = 0;
		this.playerY = 0;
	}
	
	public void move() {
		switch(this.type) {
			case(0):
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
				break;
			case(1):
				if(this.X + this.speed >= this.maxDist ) {
					speed = speed * -1;
					this.X = this.maxDist - 1;
					
				}
				if( X - speed <= minDist) {
					speed = speed * -1;
					this.X = this.minDist + 1;
				}
				this.X += speed;
				this.Y = playerY;
				this.boundingBox.setBounds(X, Y, this.scale, this.scale);
				break;
			default:
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
				break;
		}
		
		
	};
	
	@Override
	public void draw(Graphics2D g2) {
        if (spriteLoaded & this.speed >=0) {
        	g2.drawImage(sprite, X+this.scale, Y, -this.scale, this.scale, null);
        }else if (spriteLoaded) {   
    	    g2.drawImage(sprite, X, Y, this.scale, this.scale, null);
    	}
	}
	
	public void getPlayer(Player player) {
		this.playerX = player.getX();
		this.playerY = player.getY();
	}

}

