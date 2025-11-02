package Game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Collidable {
	
	protected int X;
	protected int Y;
	protected int Vx;
	protected int Vy;
    public Rectangle boundingBox;
	
	public Collidable(int X, int Y) {
		this.X = X;
		this.Y = Y;
		this.Vx = 0;
		this.Vy = 0;
		this.boundingBox = new Rectangle(this.X,this.Y,10,10);
	}
	
	public Collidable(int X, int Y, int width, int height) {
		this.X = X;
		this.Y = Y;
		this.Vx = 0;
		this.Vy = 0;
		this.boundingBox = new Rectangle(this.X,this.Y,width,height);
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
	
	public void move() {
		
	};

	public void draw(Graphics2D g2) {
		
	}

}
