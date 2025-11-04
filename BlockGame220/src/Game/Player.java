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
    private boolean collect = false;
    private int lives;
    private int score;
    private Rectangle head = new Rectangle(this.X+5,this.Y,this.boundingBox.width-5,1);
    private Rectangle feet = new Rectangle(this.X+5,this.Y + this.boundingBox.height,this.boundingBox.width-5,1);
    private Rectangle left = new Rectangle(this.X,this.Y+5,1,this.boundingBox.height-5);
    private Rectangle right = new Rectangle(this.X+this.boundingBox.width,this.Y+5,1,this.boundingBox.height-5);


		public Player(int X, int Y) {
			super(X,Y);
			this.lives  = 3;
	        try {
	            sprite = ImageIO.read(Player.class.getResource("dagobo.png"));
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
			
			this.head.setBounds(this.X+5,this.Y,this.boundingBox.width-10,1);
			
			this.feet.setBounds(this.X+5,this.Y + this.boundingBox.height-1,this.boundingBox.width-10,1);
			
			this.left.setBounds(this.X,this.Y+10,1,this.boundingBox.height-15);
			
			this.right.setBounds(this.X+this.boundingBox.width-1,this.Y+10,1,this.boundingBox.height-15);
		}
		
		@Override
		public boolean collide(Collidable c) {
			if(super.collide(c)) {
				if(c instanceof Platform) {
					if(c.boundingBox.intersects(this.left)) { // left side collison
						this.setX(c.getX() + c.boundingBox.width);
					}else if(c.boundingBox.intersects(this.right)) { //right side collison
						this.setX(c.getX() - this.boundingBox.width);
					}else if(c.boundingBox.intersects(this.head)) { // head collision
						this.setY(c.getY() + c.boundingBox.height);
					}else if(c.boundingBox.intersects(this.feet)) { // foot collision
						this.setY(c.getY() - this.boundingBox.height);
					}
				}else if(c instanceof Enemy) {
					this.lives--;
					this.X = startX;
					this.Y = startY;
				}else if(c instanceof Collectible) {
					if(this.collect) {
						this.score++;
						((Collectible) c).setCollected(true);
					}
				}
			}
			return super.collide(c);
		}
		
		
		@Override
		public void draw(Graphics2D g2) {
			//Platform collision boxes test
//			Color temp = g2.getColor();
//			g2.setColor(Color.RED);
//			g2.draw(this.head);
//			g2.fill(this.head);
//			g2.setColor(Color.orange);
//			g2.draw(this.feet);
//			g2.fill(this.feet);
//			g2.setColor(Color.GREEN);
//			g2.draw(this.left);
//			g2.fill(this.left);
//			g2.setColor(Color.BLUE);
//			g2.draw(this.right);
//			g2.fill(this.right);
//			g2.setColor(temp);
			
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
		public int getScore() {
			return this.score;
		}
		public void setScore(int i) {
			this.score = i;
		}
		public void setCollect(boolean b) {
			this.collect = b;
		}
}
