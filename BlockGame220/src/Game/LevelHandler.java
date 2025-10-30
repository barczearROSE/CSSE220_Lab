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


public class LevelHandler extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final Level canvas = new Level();
	private int score = 0;
	private JLabel scoreLabel = new JLabel("Score: 0");
	Timer timer;
	
	public LevelHandler() {
		   setLayout(new FlowLayout());
		   scoreLabel.setFont(scoreLabel.getFont().deriveFont(24f));
		   add(scoreLabel);
		  
		}
	
	
	
	private JComponent buildControls(){
		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 6));
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton up = new JButton("Up");
        
        controls.add(left); 
        controls.add(right);
        controls.add(up);
        return controls;
	}
	
private void buildKeys() {
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		this.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            switch (e.getKeyCode()) {
	                case KeyEvent.VK_LEFT:
	                	canvas.movePlayer(-10);
	                	break;
	                case KeyEvent.VK_RIGHT:
	                	canvas.movePlayer(10);
	                	break;
	                case KeyEvent.VK_UP:
	                    
	                    break;
	            }
	        }
	    });
		
	}
	
}
