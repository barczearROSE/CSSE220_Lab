package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Level extends JComponent{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	private Player player = new Player();
	private ArrayList<Collidable> collidables = new ArrayList<Collidable>();
	
	
	public Level() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Collidable c : collidables) { //NEW
          c.draw(g2); 
        } 
    }
    
    
    
	

	
}
