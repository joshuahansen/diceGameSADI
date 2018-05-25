package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainWindow extends JFrame{
	GameEngine gameEngine;
	Player currentPlayer;
	
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
		add(new DicePanel(), BorderLayout.CENTER);
		Toolbar toolbar = new Toolbar(this, gameEngine, currentPlayer);
		add(toolbar, BorderLayout.PAGE_END);
		PlayersList playersList = new PlayersList(this, this.gameEngine, toolbar);
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
}
