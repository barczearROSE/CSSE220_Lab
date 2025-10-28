package Game;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class ScoreManager {

	private static final String SCORES_FILE = "scores.txt";
	
	public static void saveScore(String player, int score) {
        try (PrintWriter out = 
                 new PrintWriter(
                   new FileWriter(SCORES_FILE, true)  // append mode
                 )
           ) {
            out.println(player + "," + score);
        } catch (IOException e) {
            System.err.println("Error saving score: " + e.getMessage());
        }
    }
	
	
	 public static List<String> loadScores() {
         List<String> lines = new ArrayList<>();
         File file = new File(SCORES_FILE);
         if (!file.exists()) {
             return lines;  // no scores file yet,  return empty list
         }
     
         try (BufferedReader in = 
                  new BufferedReader(new FileReader(file))
            ) {
             String line;
             while ((line = in.readLine()) != null) {
                 lines.add(line.trim());
             }
         } catch (IOException e) {
             System.err.println("Error loading scores: " + e.getMessage());
         }
     
         return lines;
     }
	 
}
