package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Collidable {

		public Player(int X, int Y) {
			super(X,Y);
		
	}
		@Override
		public void move(){
			this.X += this.Vx;
			this.Y += this.Vy;
			
		}
		
		@Override
		public void draw(Graphics2D g2) {
			super.draw(g2);
			Color temp = g2.getColor();
			g2.setColor(Color.RED);
			g2.drawRect(X, Y, X+10, Y+10);
			g2.fillRect(X, Y, X+10, Y+10);
			g2.setColor(temp);
		}
}
