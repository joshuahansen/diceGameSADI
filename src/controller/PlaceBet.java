package controller;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainWindow;
/**
 * 
 * @author Joshua Hansen
 * ActionListener for player to place a bet
 */
public class PlaceBet implements ActionListener {
	GameEngine gameEngine;
	MainWindow frame;
	String player;
	JTextField bet;
	Dialog dialog;
	
	public PlaceBet(MainWindow frame, GameEngine gameEngine, JTextField bet, Dialog dialog)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
		this.bet = bet;
		this.dialog = dialog;
	}
	//get bet entered and check if its a valid bet. If it is dispose the dialog otherwise wait for correct bet to be placed
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String betString = bet.getText();
		int betValue = Integer.valueOf(betString);
		updatePlayer();
		if(player != null)
		{
			if(this.gameEngine.placeBet(gameEngine.getPlayer(this.player), betValue))
				frame.refreshFrame();
				this.dialog.dispose();	
		}
	}
	//update current player placing bet
	public void updatePlayer()
	{
		this.player = this.frame.getCurrentPlayer();
	}

}
