package Game;
/**
 * Handles the game level, HUD, and player input.
 *
 * This class sets up the Level canvas, HUD display, control buttons,
 * and keyboard controls. It also runs the game loop via a timer to
 * update movement, collisions, and repainting.
 */

import java.awt.*;
import java.util.ArrayList;
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
	JLabel gameOverScreen = new JLabel("Game Over!");
	private int level = 1;
	Timer timer;
	
	
	private Platform lvl2Wall = new Platform(200,200,1000,1000);
	private Player player = new Player(10,10);
	
	private ArrayList<Collidable> level1 = new ArrayList<Collidable>();
	
	public LevelHandler() {
		this.setLayout(new BorderLayout(8, 8));
        this.add(canvas, BorderLayout.CENTER);
        this.setBackground(canvas.BG);
        this.buildKeys();
        
        JLabel scoreLabel = new JLabel("Score: " + score);
        JLabel lifeLabel = new JLabel("Lives: " + canvas.player.getLives());
        Font hudFont = new Font("Serif", Font.PLAIN, 24);
        
		scoreLabel.setBounds(50,50,200,30);
		lifeLabel.setBounds(50,30,200,30);
		
		scoreLabel.setFont(hudFont);
		lifeLabel.setFont(hudFont);
		
		canvas.add(scoreLabel);
		canvas.add(lifeLabel);
        JPanel layered = new JPanel();
		layered.setLayout(new OverlayLayout(layered));
		layered.setOpaque(false);
//		   
//		   
		   timer = new Timer(30, e -> {
			   canvas.moveAll();
			   canvas.checkBounds();
			   canvas.collide();
	           canvas.repaint();
	           //layered.repaint();
	           
	           if(canvas.player.getLives() <= 0)
	           {
	        	   gameOver();
	        	   timer.stop();
	           }
	        });
		   timer.start();
		  
		 /* 


		   canvas.setOpaque(true);
		   layered.add(canvas); 
		   hudView.setOpaque(false);
		   hudView.setAlignmentX(0f); // left
		   hudView.setAlignmentY(0f); // top
		   hudView.setBorder(javax.swing.BorderFactory.createEmptyBorder(8,8,0,0));
		   layered.add(hudView); // top


		   add(layered, BorderLayout.CENTER);
		   
 */

		   // initial sync
		   //hudView.refresh(hudModel);
		   
		   
		}
	
	
	
//	private JComponent buildControls(){
//		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 6));
//        JButton left = new JButton("Left");
//        JButton right = new JButton("Right");
//        JButton up = new JButton("Up");
//        
//        controls.add(left); 
//        controls.add(right);
//        controls.add(up);
//        return controls;
//	}
	
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
	                case KeyEvent.VK_DOWN:
	                	canvas.collect();
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
                case KeyEvent.VK_DOWN:
                	canvas.movePlayer(0);
                	canvas.jumpPlayer(01);
                default:
                	canvas.movePlayer(0);
                	canvas.jumpPlayer(01);
                	break;
                
	        	}
	        }
	    });
		
	}


	private void gameOver(){
		
		gameOverScreen.setBounds(250, 250, 1000, 200);
		Font gameOverFont = new Font("Serif", Font.BOLD, 100);
		gameOverScreen.setFont(gameOverFont);
		canvas.add(gameOverScreen);
		
		
	}
	
}

