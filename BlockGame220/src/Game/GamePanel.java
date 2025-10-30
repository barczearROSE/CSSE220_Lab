package Game;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class GamePanel extends JPanel{
	
	private final GameComponent canvas = new GameComponent();
	private int score = 0;
	private JLabel scoreLabel = new JLabel("Score: 0");
	Timer timer;
	
	public GamePanel() {
		   setLayout(new FlowLayout());
		   scoreLabel.setFont(scoreLabel.getFont().deriveFont(24f));
		   add(scoreLabel);
		  
		}
	
	
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		
	}
	
	
	/*
	private JComponent buildControls()
	{
		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 6));
		
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton up = new JButton("Up");
        
        left
        
        
        
		return 
	} */
	
	/*
	private void buildKeys() 
	{
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		this.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            switch (e.getKeyCode()) {
	                case KeyEvent.VK_LEFT -> canvas.moveDelta(-10);
	                case KeyEvent.VK_RIGHT -> canvas.moveDelta(10);
	                case KeyEvent.VK_UP -> canvas.moveUp
	                case KeyEvent.VK_B -> {
	                    int x = (int)(Math.random() * canvas.getWidth());
	                    int y = (int)(Math.random() * canvas.getHeight());
	                    canvas.addBall(x, y);
	                }
	            }
	        }
	    });
		
	}
	*/
	
}
