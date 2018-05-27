package view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * 
 * @author Joshua Hansen
 * Dialog to show game results
 * shows results after house has rolled
 */
public class ResultsWindow extends Dialog {
	public ResultsWindow(MainWindow frame, GameEngine gameEngine, DicePair houseResults)
	{
		super(frame, "Results");
		JPanel window = new JPanel(new GridLayout(0,1));
		//get list of all players
		Collection<Player> players = gameEngine.getAllPlayers();
		//loops through all players and add to dialog
		for(Player player : players)
		{
			JLabel result = new JLabel(player.toString() + " Result: " +(player.getRollResult().getDice1()+player.getRollResult().getDice2()));
			result.setFont(new Font("Sefif", Font.BOLD, 24));
			window.add(result);
			//reset player info for next round
			player.placeBet(0);
			player.setRollResult(null);
		}	
		//add house results to bottom of the list
		JLabel hr = new JLabel("House Result: " + (houseResults.getDice1()+houseResults.getDice2()));
		hr.setFont(new Font("Sefif", Font.BOLD, 24));
		window.add(hr);
		//rest house dice for next round
		frame.refreshHouseDice(null);
		add(window);
		//set dialog size and position
		setBounds(400, 400, 500, 400);
		pack();
		setVisible(true);		
	}

}
