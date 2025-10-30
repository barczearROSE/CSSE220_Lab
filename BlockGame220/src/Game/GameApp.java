package Game;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class GameApp{

	private JFrame frame = new JFrame();
	private LevelHandler panel = new LevelHandler();
	
	//Constructs the main game window.
	public  GameApp()
	{
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();                      // Fit to preferred component sizes
        frame.setLocationRelativeTo(null); // Center on screen
		
	}
}
