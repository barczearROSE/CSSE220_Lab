package Game;
/**
 * Sets up the main game window and display.
 *
 * This class creates the game frame, adds the LevelHandler panel,
 * and shows the game when started.
 */

import javax.swing.JFrame;

public class GameApp{

	private JFrame frame = new JFrame();
	private LevelHandler panel = new LevelHandler();
	
	//Constructs the main game window.
	public  GameApp(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();                      // Fit to preferred component sizes
        frame.setLocationRelativeTo(null); // Center on screen
		
	}
	
	public void show() {
		frame.setVisible(true);

	}
}
