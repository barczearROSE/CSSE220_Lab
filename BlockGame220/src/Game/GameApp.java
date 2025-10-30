package Game;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class GameApp{

	private JFrame frame = new JFrame("Template");
	private GamePanel panel = new GamePanel();
	
	//Constructs the main game window.
	public  GameApp()
	{
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();                      // Fit to preferred component sizes
        frame.setLocationRelativeTo(null); // Center on screen
		
	}
	
	public void show() {
		frame.setVisible(true);

	}
}
