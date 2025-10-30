package Game;

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
		   setLayout(new FlowLayout());
		   
		   
		   timer = new Timer(30, e -> {
			    canvas.moveAll();
	           canvas.repaint();
	        });
		  
		   JPanel layered = new JPanel();
		   layered.setLayout(new OverlayLayout(layered));
		   layered.setOpaque(false);


		   canvas.setOpaque(true);
		   layered.add(canvas); 
		   hudView.setOpaque(false);
		   hudView.setAlignmentX(0f); // left
		   hudView.setAlignmentY(0f); // top
		   hudView.setBorder(javax.swing.BorderFactory.createEmptyBorder(8,8,0,0));
		   layered.add(hudView); // top


		   add(layered, BorderLayout.CENTER);
		   add(buildControls(), BorderLayout.SOUTH);


		   // initial sync
		   hudView.refresh(hudModel);
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
	                	canvas.jumpPlayer(10);
	                    break;
	            }
	        }
	    });
		
	}
	
}
