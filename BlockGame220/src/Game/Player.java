package Game;
/**
 * Represents the player character.
 *
 * Handles movement, collision bounds, and drawing the player
 * on the screen.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Collidable {
    private BufferedImage sprite; //new
    private BufferedImage moveSprite;
    private boolean spriteLoaded = false;//new
    private boolean buffSpriteLoaded = false;


		public Player(int X, int Y) {
			super(X,Y);
	        try {
	            sprite = ImageIO.read(Player.class.getResource("playah.png"));
	            spriteLoaded = (sprite != null);
	            moveSprite = ImageIO.read(Player.class.getResource("PLAYAHMOVING.png"));
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
}
