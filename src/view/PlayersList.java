package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.SelectPlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlayersList extends JPanel {
	private JList<String> playersList;
	public PlayersList(MainWindow frame, GameEngine gameEngine, Toolbar toolbar)
	{
		//create the model and add elements
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(Player player : gameEngine.getAllPlayers())
		{
			listModel.addElement(player.getPlayerId()+"-  "+player.getPlayerName());
		}

		//create the list
		playersList = new JList<>(listModel);
		playersList.setFont(new Font("Sefif", Font.BOLD, 24));
		playersList.addListSelectionListener(new SelectPlayer(frame, gameEngine, listModel, toolbar));
		add(playersList);
		setPreferredSize(new Dimension(300, 300));
//		this.setSize(400,400);
	}
}