package controller;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlaceBet implements ActionListener {
	GameEngine gameEngine;
	Player player;
	JTextField bet;
	Dialog dialog;
	
	public PlaceBet(GameEngine gameEngine, Player player, JTextField bet, Dialog dialog)
	{
		this.gameEngine = gameEngine;
		this.player = player;
		this.bet = bet;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String betString = bet.getText();
		int betValue = Integer.valueOf(betString);
		this.gameEngine.placeBet(this.player, betValue);
		this.dialog.dispose();
	}

}
