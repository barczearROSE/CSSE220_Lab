package Game;
/**
 * Handles the game level, HUD, and player input.
 *
 * This class sets up the Level canvas, HUD display, control buttons,
 * and keyboard controls. It also runs the game loop via a timer to
 * update movement, collisions, and repainting.
 */

import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LevelHandler extends JPanel{
	
	private final HUDModel hudModel = new HUDModel();
	private final HUDView hudView = new HUDView();
	private static final long serialVersionUID = 1L;
	private final Level canvas = new Level();
	private int score = 0;
	
	Timer timer;
	
	public LevelHandler() {
		this.setLayout(new BorderLayout(8, 8));
        this.add(canvas, BorderLayout.CENTER);
        this.setBackground(canvas.BG);
        this.add(buildControls(), BorderLayout.SOUTH);
        this.buildKeys();
//		   setLayout(new FlowLayout());
//		   
//		   
		   timer = new Timer(30, e -> {
			   canvas.moveAll();
			   canvas.collide();
	           canvas.repaint();
	        });
		   timer.start();
		  
//		   JPanel layered = new JPanel();
//		   layered.setLayout(new OverlayLayout(layered));
//		   layered.setOpaque(false);
//
//
//		   canvas.setOpaque(true);
//		   layered.add(canvas); 
//		   hudView.setOpaque(false);
//		   hudView.setAlignmentX(0f); // left
//		   hudView.setAlignmentY(0f); // top
//		   hudView.setBorder(javax.swing.BorderFactory.createEmptyBorder(8,8,0,0));
//		   layered.add(hudView); // top
//
//
//		   add(layered, BorderLayout.CENTER);
//		   add(buildControls(), BorderLayout.SOUTH);
//
//
//		   // initial sync
//		   hudView.refresh(hudModel);
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
	                	canvas.jumpPlayer(-10);
	                    break;
	                default:
	                	canvas.movePlayer(0);
	                	canvas.jumpPlayer(01);
	                	break;
	                
	            }
	        }
	        public void keyReleased(KeyEvent e) {
	        	switch (e.getKeyCode()) {
	            case KeyEvent.KEY_RELEASED:
                	canvas.movePlayer(0);
                	canvas.jumpPlayer(01);
                	break;
                case KeyEvent.VK_LEFT:
                	canvas.movePlayer(0);
                	canvas.jumpPlayer(01);
                	break;
                case KeyEvent.VK_RIGHT:
                	canvas.movePlayer(0);
                	canvas.jumpPlayer(01);
                	break;
                case KeyEvent.VK_UP:
                	canvas.movePlayer(0);
                	canvas.jumpPlayer(01);
                    break;
                default:
                	canvas.movePlayer(0);
                	canvas.jumpPlayer(01);
                	break;
                
            }
	        }
	    });
		
	}
	
}

