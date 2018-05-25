package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainWindow extends JFrame{
	GameEngine gameEngine;
	Player currentPlayer;
	Toolbar toolbar;
	PlayersList playersList;
	DicePanel d1;
	DicePanel d2;
	
	public MainWindow(GameEngine gameEngine, Player[] players)
	{
		super("SADI Dice Game");
		this.gameEngine = gameEngine;
		this.currentPlayer = this.gameEngine.getPlayer("1");
		
		setBounds(300, 300, 800, 600);
		this.setLayout(new BorderLayout());
		
		JLabel greeting = new JLabel("Welcome to the dice game");
		greeting.setFont(new Font("Sefif", Font.BOLD, 36));
		add(greeting, BorderLayout.PAGE_START);
		setJMenuBar(new CustomMenuBar(this, gameEngine));
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		d1 = new DicePanel();
		centerPanel.add(d1);
		d2 = new DicePanel();
		centerPanel.add(d2);
		add(centerPanel);
		this.toolbar = new Toolbar(this, gameEngine, currentPlayer);
		add(toolbar, BorderLayout.PAGE_END);
		this.playersList = new PlayersList(this, this.gameEngine);
		add(playersList, BorderLayout.LINE_END);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public Player getCurrentPlayer()
	{
		return this.currentPlayer;
	}
	public void setCurrentPlayer(Player player)
	{
		this.currentPlayer = player;
	}
	public void refreshFrame()
	{
		this.playersList.removeAll();
		this.playersList.drawList();
		this.playersList.revalidate();
		this.toolbar.updateToolbar();
		this.toolbar.revalidate();
	}
	public void refreshDice(DicePair dicePair)
	{
		d1.updateDice(dicePair.getDice1());
		d2.updateDice(dicePair.getDice2());
	}
}
