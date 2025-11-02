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
			this.X+=10;
			this.X += this.Vx;
			this.Y += this.Vy;
			System.out.println("HELLO");
			
		}
		
		@Override
		public void draw(Graphics2D g2) {
			super.draw(g2);
			Color temp = g2.getColor();
			g2.setColor(Color.RED);
			Rectangle r = new Rectangle(X,Y,X+10,Y+10);
			g2.draw(r);
			g2.fill(r);
			g2.setColor(temp);
		}
}
