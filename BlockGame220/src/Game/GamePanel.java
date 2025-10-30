package Game;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class GamePanel extends JPanel{
	private int score = 0;
	private JLabel scoreLabel = new JLabel("Score: 0");
	private JButton addPointButton = new JButton("Add Point");
	private JButton endGameButton = new JButton("End Game");
	
	public GamePanel() {
			
		   setLayout(new FlowLayout());
		   scoreLabel.setFont(scoreLabel.getFont().deriveFont(24f));
		   add(scoreLabel);
		   add(addPointButton);
		   add(endGameButton);
		   
		  
		}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		
	}
	
}
