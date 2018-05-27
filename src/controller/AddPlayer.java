package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.AddPlayerDialog;
import view.MainWindow;
/**
 * 
 * @author Joshua Hasnen
 *	action listener for opening add player dialog
 */
public class AddPlayer implements ActionListener {
	GameEngine gameEngine;
	MainWindow frame;
	
	public AddPlayer(MainWindow frame, GameEngine gameEngine)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new AddPlayerDialog(this.frame, this.gameEngine);
	}

}
