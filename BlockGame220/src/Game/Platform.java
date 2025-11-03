package Game;
/**
 * Represents a solid platform in the game.
 */

import java.awt.Color;
import java.awt.Graphics2D;

public class Platform extends Collidable {

	public Platform(int X, int Y, int width, int height) {
		super(X,Y,width,height);
	}
	
	@Override
	public void draw(Graphics2D g2) {
		Color temp = g2.getColor();
		g2.setColor(Color.BLACK);
		g2.draw(this.boundingBox);
		g2.fill(this.boundingBox);
		g2.setColor(temp);
	}

}
