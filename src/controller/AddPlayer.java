package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.AddPlayerDialog;

public class AddPlayer implements ActionListener {
	GameEngine gameEngine;
	Frame frame;
	
	public AddPlayer(Frame frame, GameEngine gameEngine)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Create Dialog here to enter new player details
		new AddPlayerDialog(this.frame, this.gameEngine);
	}

}
