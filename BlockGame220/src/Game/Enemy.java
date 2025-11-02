package Game;

public class Enemy extends Collidable {

	int reverse = 1;
	
	public Enemy(int X, int Y) {
		super(X, Y);
	}
	
	public void move(int maxDist, int minDist, int speed) {
		if (X + speed >= maxDist || X - speed >= minDist) {
			reverse = reverse * -1;
		};
		this.X += speed * reverse;
	};

}
