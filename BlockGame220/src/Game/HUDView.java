package Game;

import javax.swing.JLabel;

public class HUDView extends javax.swing.JLabel {
	
	private JLabel scoreBoard = new JLabel();
	
	public HUDView() {
		setOpaque(false);
		setForeground(new java.awt.Color(230,240,255));
		setFont(getFont().deriveFont(java.awt.Font.BOLD, 13f));
	}
	
	public void refresh(HUDModel hud) {
		scoreBoard.setText("Score: " + hud.getScore());
		
	}
}
