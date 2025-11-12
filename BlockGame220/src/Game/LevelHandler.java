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
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LevelHandler extends JPanel{
	
	private final HUDModel hudModel = new HUDModel();
	private final HUDView hudView = new HUDView();
	private static final long serialVersionUID = 1L;
	private Level canvas = new Level();
	private int score = 0;
	JLabel gameOverScreen = new JLabel("Game Over!");
	private int level = 1;
	Timer timer;
	
	private int lastLevel;
	JLabel scoreLabel = new JLabel("Life Default");
    JLabel lifeLabel = new JLabel("Score Default");
	
	private Platform lvl2Wall = new Platform(200,200,1000,1000);
	private Player player = new Player(10,10);
	
	private Platform bottom = new Platform(0,768-10,1024,10);
	private Platform firstJump = new Platform(200,600,100,50);
	private Platform secondJump = new Platform(400, 500, 100, 50);
	private Platform wall = new Platform(750,100,20,700);
	private Platform downward2 = new Platform(875,400,150,50);
	private Platform downward1 = new Platform(770,150,150,50);
	private Platform downward3 = new Platform(770,650,150,50);
	
	private Enemy enemy1 = new Enemy(450, 500, 400, 500);
	private Collectible col1 = new Collectible(300, 200);
	
	private ArrayList<Collidable> level1 = new ArrayList<Collidable>();
	private ArrayList<Collidable> level2 = new ArrayList<Collidable>();
	
	public LevelHandler() {
		
		level1.add(player);
		level1.add(new Platform(0,768-10,1024,10));
		level1.add(new Collectible(230, 245));
		level1.add(new Collectible(950,150));
		level1.add(new Collectible(950,650));
		
		level1.add(firstJump);
		level1.add(secondJump);
		level1.add(new Platform(200,300,100,50));
		level1.add(new Platform(550,200,100,50));
		level1.add(wall);
		
		level1.add(downward1);
		level1.add(downward2);
		level1.add(downward3);
		
		
		
		
		level2.add(player);
		level2.add(new Platform(200,200,500,500));
		
		canvas = new Level(level1);
		
		
		this.setLayout(new BorderLayout(8, 8));
        this.add(canvas, BorderLayout.CENTER);
        this.setBackground(canvas.BG);
        this.buildKeys();
        
        JLabel scoreLabel = new JLabel();
        JLabel lifeLabel = new JLabel();
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
	   
		   timer = new Timer(30, e -> {
			   canvas.moveAll();
			   canvas.checkBounds();
			   canvas.collide();
			   lifeLabel.setText("Lives: " + canvas.player.getLives());
			   scoreLabel.setText("Score: " + canvas.player.getScore());
			   updateScore();
	           canvas.repaint();
	           //layered.repaint();
	           
	           if(canvas.player.getLives() <= 0){
	        	   gameOver();
	        	   timer.stop();
	           }
	           
	          updateLevel();
	        });
		   timer.start();
		  

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
	                case KeyEvent.VK_DOWN:
	                	canvas.collect();
	                	break;
	                case KeyEvent.VK_SPACE:
	                	canvas.remove(gameOverScreen);
	                	canvas.player.setLives(3);
	                	canvas.player.setScore(0);
	                	canvas.setLevel(level1);
	                	timer.restart();
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
	
	private void updateLevel(){
		 if(level == 2 && lastLevel == 1)
		{
			canvas.setLevel(level2);
			canvas.player.setX(10);
			canvas.player.setY(10);
			lastLevel = 2;
			
		}
		 
	}
	
	private void updateScore(){
		scoreLabel.setText("Score: " + canvas.player.getScore());
		if(canvas.player.getScore() == 3)
		{
			level = 2;
			lastLevel = 1;
			canvas.player.setScore(0);
		}
	}
	
}

