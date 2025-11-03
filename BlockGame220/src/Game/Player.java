package Game;
/**
 * Represents the player character.
 *
 * Handles movement, collision bounds, and drawing the player
 * on the screen.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Collidable {
    private BufferedImage sprite; //new
    private BufferedImage moveSprite;
    private boolean spriteLoaded = false;//new
    private boolean buffSpriteLoaded = false;
    private int lives;


		public Player(int X, int Y) {
			super(X,Y);
			this.lives  = 3;
	        try {
	            sprite = ImageIO.read(Player.class.getResource("playah.png"));
	            spriteLoaded = (sprite != null);
	            moveSprite = ImageIO.read(Player.class.getResource("dagbo.png"));
	            buffSpriteLoaded = (moveSprite != null);
	        } catch (IOException | IllegalArgumentException ex) {
	            spriteLoaded = false; // fallback to oval
	            buffSpriteLoaded = false;
	        }
		
	}
		@Override
		public void move(){
			this.X += this.Vx;
			this.Y += this.Vy;
			this.boundingBox.setBounds(X, Y, 50, 50);
		}
		
		@Override
		public boolean collide(Collidable c) {
			if(super.collide(c)) {
				if(c instanceof Platform) {
					if(c.boundingBox.intersects(new Rectangle(this.X+1,this.Y,this.boundingBox.width-1,1))) { // head collision
						this.setY(c.getY() + c.boundingBox.height);
					}else if(c.boundingBox.intersects(new Rectangle(this.X+1,this.Y + this.boundingBox.height,this.boundingBox.width-1,1))) { // foot collision
						this.setY(c.getY() - this.boundingBox.height);
					}
				}else if(c instanceof Enemy) {
					this.lives--;
				}else if(c instanceof Collectible) {
					
				}
			}
			return super.collide(c);
		}
		
		
		@Override
		public void draw(Graphics2D g2) {
			if (buffSpriteLoaded & this.Vx !=0){
	    		g2.drawImage(moveSprite, X, Y, 50,50, null);
			}else if (spriteLoaded) {   // new
	    	    g2.drawImage(sprite, X, Y, 50, 50, null);
	    	}else{
			super.draw(g2);
			Color temp = g2.getColor();
			g2.setColor(Color.RED);
			g2.draw(this.boundingBox);
			g2.fill(this.boundingBox);
			g2.setColor(temp);
	    	}
		}
		
		public int getLives() {
			return this.lives;
		}
		public void setLives(int i) {
			this.lives = i;
		}
}
