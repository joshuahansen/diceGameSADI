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

public class ResultsWindow extends Dialog {
	public ResultsWindow(MainWindow frame, GameEngine gameEngine, DicePair houseResults)
	{
		super(frame, "Results");
		JPanel window = new JPanel(new GridLayout(0,1));
		Collection<Player> players = gameEngine.getAllPlayers();
		for(Player player : players)
		{
			JLabel result = new JLabel(player.toString() + " Result: " +(player.getRollResult().getDice1()+player.getRollResult().getDice2()));
			result.setFont(new Font("Sefif", Font.BOLD, 24));
			window.add(result);
			player.placeBet(0);
			player.setRollResult(null);
		}	
		JLabel hr = new JLabel("House Result: " + (houseResults.getDice1()+houseResults.getDice2()));
		hr.setFont(new Font("Sefif", Font.BOLD, 24));
		window.add(hr);
		frame.refreshHouseDice(null);
		add(window);
		setBounds(400, 400, 500, 400);
		pack();
		setVisible(true);		
	}

}
