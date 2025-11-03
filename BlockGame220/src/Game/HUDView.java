package Game;
/**
 * Displays the player's score on the screen.
 *
 * This class extends JLabel and updates the score display
 * based on the HUDModel data.
 */

import javax.swing.JLabel;

public class HUDView extends javax.swing.JLabel {
	
	private JLabel scoreBoard = new JLabel();
	
	public HUDView() {
		setOpaque(false);
		setForeground(new java.awt.Color(0 , 0 , 0));
		setFont(getFont().deriveFont(java.awt.Font.BOLD, 13f));
	}
	
	public void refresh(HUDModel hud) {
		scoreBoard.setText("Score: " + hud.getScore());
		
	}
}
