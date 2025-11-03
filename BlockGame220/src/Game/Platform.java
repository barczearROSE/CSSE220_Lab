package Game;
/**
 * Represents a solid platform in the game.
 */

import java.awt.Color;
import java.awt.Graphics2D;

public class Platform extends Collidable {

	public Platform(int X, int Y) {
		super(X, Y);
		this.boundingBox.setBounds(this.X,this.Y,this.X+1024,this.Y+10);
	}
	
	@Override
	public void draw(Graphics2D g2) {
		Color temp = g2.getColor();
		g2.setColor(Color.BLACK);
		g2.drawRect(X, Y, X+1024, Y+10);
		g2.fillRect(X, Y, X+1024, Y+10);
		g2.setColor(temp);
	}

}
