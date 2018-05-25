package controller;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainWindow;
import view.Toolbar;

public class SelectPlayer implements ListSelectionListener {
	private GameEngine gameEngine;
	private MainWindow frame;
	private DefaultListModel list;
	private Toolbar toolbar;
	public SelectPlayer(MainWindow frame, GameEngine gameEngine, DefaultListModel<String> list, Toolbar toolbar)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
		this.list = list;
		this.toolbar = toolbar;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int playerIndex = e.getFirstIndex();
		String player = (String) list.get(playerIndex);
		String[] splitString = player.split("-");
		frame.setCurrentPlayer(gameEngine.getPlayer(splitString[0]));
		System.out.println("NEW PLAYER SELECTED " + frame.getCurrentPlayer());
		
		toolbar.invalidate();
		toolbar.validate();
		toolbar.repaint();
	}

}
