package controller;

import java.awt.Dialog;
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
	private JTextField nameText;
	private JTextField creditText;
	private Dialog dialog;
	
	public SaveNewPlayer(GameEngine gameEngine, MainWindow mainWindow, JTextField name, JTextField credit, Dialog dialog)
	{
		this.gameEngine = gameEngine;
		this.frame = mainWindow;
		this.nameText = name;
		this.creditText = credit;
		this.dialog = dialog;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = nameText.getText();
		int credit = Integer.valueOf(creditText.getText());
		int numPlayers = gameEngine.getAllPlayers().size()+1;
		String id = Integer.toString(numPlayers);
		Player player = new SimplePlayer(id, name, credit);
		gameEngine.addPlayer(player);
		this.dialog.dispose();
		frame.refreshFrame();
	}

}
