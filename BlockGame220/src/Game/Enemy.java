package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Collidable {

	int reverse = 1;
	private BufferedImage sprite;
	private boolean spriteLoaded = false;
	private int maxDist;
	private int minDist;
	private int speed;
	
	public Enemy(int X, int Y, int maxDist, int minDist, int speed) {
		super(X, Y);
		this.maxDist = maxDist;
		this.minDist = minDist;
		this.speed = speed;
		try {
            sprite = ImageIO.read(Enemy.class.getResource("emeny.png"));
            spriteLoaded = (sprite != null);
        } catch (IOException | IllegalArgumentException ex) {
            spriteLoaded = false; // fallback to oval
        }
	}
	
	public void move() {
		if (X + speed >= maxDist || X - speed <= minDist) {
			if (reverse > 0) {
				this.X = maxDist;
			} else if (reverse < 0) {
				this.X = minDist;
			};
			reverse = reverse * -1;
		};
		this.X += speed * reverse;
	};
	
	@Override
	public void draw(Graphics2D g2) {
        if (spriteLoaded) {   
    	    g2.drawImage(sprite, X, Y, 512, 384, null);
    	}
	}

}
