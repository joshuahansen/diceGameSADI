package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainWindow;

public class SaveNewPlayer implements ActionListener {

	private GameEngine gameEngine;
	private MainWindow frame;
	private String name;
	private int credit;
	
	public SaveNewPlayer(GameEngine gameEngine, MainWindow mainWindow, JTextField name, JTextField credit)
	{
		this.gameEngine = gameEngine;
		this.frame = mainWindow;
		this.name = name.getText();
		this.credit = Integer.getInteger(credit.getText());
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int numPlayers = gameEngine.getAllPlayers().size()+1;
		String id = "1";
		Player player = new SimplePlayer(id, this.name, this.credit);
		gameEngine.addPlayer(player);
		
	}

}
