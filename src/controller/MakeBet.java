package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MakeBet implements ActionListener{
	GameEngine gameEngine;
	Player player;
	
	public MakeBet(GameEngine gameEngine, Player player)
	{
		this.gameEngine = gameEngine;
		this.player = player;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO open dialog to enter bet amount and place bet
		this.gameEngine.placeBet(this.player, 100);
	}

}
