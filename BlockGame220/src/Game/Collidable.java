package Game;

import java.awt.Graphics2D;

public class Collidable {
	
	private int X;
	private int Y;
	private int Vx;
	private int Vy;
	
	public Collidable(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
	
	public int getX() {
		return X;
	};
	
	public int getY() {
		return Y;
	};

	public int getVx() {
		return Vx;
	};
	
	public int getVy() {
		return Vy;
	};
	
	public void setX(int X) {
		this.X = X;
	};
	
	public void setY(int Y) {
		this.Y = Y;
	};
	
	public void setVx(int V) {
		this.Vx = V;
	};
	
	public void setVy(int V) {
		this.Vy = V;
	};

	public void draw(Graphics2D g2) {
		
	}

}
