package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AddPlayerDialog;
import view.PlaceBetDialog;

public class MakeBet implements ActionListener{
	Frame frame;
	GameEngine gameEngine;
	Player player;
	
	public MakeBet(Frame frame, GameEngine gameEngine, Player player)
	{
		this.gameEngine = gameEngine;
		this.player = player;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new PlaceBetDialog(this.frame, this.gameEngine, this.player);
	}

}
