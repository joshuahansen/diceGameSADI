package controller;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainWindow;

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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String betString = bet.getText();
		int betValue = Integer.valueOf(betString);
		System.out.println(betValue);
		updatePlayer();
		if(player != null)
		{
			System.out.println("CURRENT CREDIT: " + gameEngine.getPlayer(this.player).getPoints() + " BET: "+ betValue);
			if(this.gameEngine.placeBet(gameEngine.getPlayer(this.player), betValue))
				this.dialog.dispose();	
		}
	}
	public void updatePlayer()
	{
		this.player = this.frame.getCurrentPlayer();
	}

}
