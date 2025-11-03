package Game;
/**
 * Starts the game application.
 * 
 * This class runs the GameApp and opens the main game window.
 */

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(()-> new GameApp().show());

	}

}