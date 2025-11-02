package Game;

import java.awt.Graphics2D;

public class Collidable {
	
	private int X;
	private int Y;
	private int V;
	
	public Collidable(int X, int Y, int V) {
		this.X = X;
		this.Y = Y;
		this.V = V;
	}
	
	public int getX() {
		return X;
	};
	
	public int getY() {
		return Y;
	};
	//hello
	public int getV() {
		return V;
	};
	// oh no
	
	public void setX(int X) {
		this.X = X;
	};
	
	public void setY(int Y) {
		this.Y = Y;
	};
	
	public void setV(int V) {
		this.V = V;
	};
	//hello
	public void draw(Graphics2D g2) {
		
	}

}
