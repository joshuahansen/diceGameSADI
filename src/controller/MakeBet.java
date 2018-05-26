package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AddPlayerDialog;
import view.MainWindow;
import view.PlaceBetDialog;

public class MakeBet implements ActionListener{
	MainWindow frame;
	GameEngine gameEngine;

	
	public MakeBet(MainWindow frame, GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new PlaceBetDialog(this.frame, this.gameEngine);
	}
}
