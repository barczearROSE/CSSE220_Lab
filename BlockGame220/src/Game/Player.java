package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Collidable {
    private BufferedImage sprite; //new
    private boolean spriteLoaded = false;//new

		public Player(int X, int Y) {
			super(X,Y);
	        try {
	            sprite = ImageIO.read(Player.class.getResource("playah.png"));
	            spriteLoaded = (sprite != null);
	        } catch (IOException | IllegalArgumentException ex) {
	            spriteLoaded = false; // fallback to oval
	        }
		
	}
		@Override
		public void move(){
			this.X += this.Vx;
			this.Y += this.Vy;
			
		}
		
		@Override
		public void draw(Graphics2D g2) {
	        if (spriteLoaded) {   // new
	    	    g2.drawImage(sprite, X, Y, 10, 10, null);
	    	} else {
			
			
			super.draw(g2);
			Color temp = g2.getColor();
			g2.setColor(Color.RED);
			g2.drawRect(X, Y, X+10, Y+10);
			g2.fillRect(X, Y, X+10, Y+10);
			g2.setColor(temp);
	    	}
		}
}
