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
		          
		  addPointButton.addActionListener(e -> addScores());
		  endGameButton.addActionListener(e -> onEndGame());
		}
	
	private void addScores() {
        score++;
        scoreLabel.setText("Score: " + score);
      }

	private void onEndGame() {
        String player = JOptionPane.showInputDialog(this, "Enter your name", "Player");
        if (player == null || player.isBlank()) player = "Anonymous";
      
        ScoreManager.saveScore(player, score);
        showLeaderboard();
      
        score = 0;
        scoreLabel.setText("Score: 0");
      }
	
	private void showLeaderboard() {
        List lines = ScoreManager.loadScores();
          StringBuilder html = new StringBuilder(
            "<html><h2>Leaderboard</h2><ol>"
        );
        for (int i = 0; i < lines.size() && i < 5; i++) {
            String[] parts = lines.get(i).split(",", 2);
            html.append("<li>")
                .append(parts[0])    // player name
                .append(": ")
                .append(parts[1])    // score
                .append("</li>");
        }
        html.append("</ol></html>");
      
        JOptionPane.showMessageDialog(
          this,
          new JLabel(html.toString()),
          "Top Scores",
          JOptionPane.PLAIN_MESSAGE
        );
      }
}
