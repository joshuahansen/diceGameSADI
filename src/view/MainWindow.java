package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * 
 * @author Joshua Hansen
 * Main Frame that holds all other components
 */
public class MainWindow extends JFrame{
	GameEngine gameEngine;
	String currentPlayer;
	Toolbar toolbar;
	PlayersList playersList;
	DicePanel pd1;
	DicePanel pd2;
	DicePanel hd1;
	DicePanel hd2;
	
	/**
	 * Main Frame constructor
	 * @param gameEngine passes in the main game functionality
	 */
	public MainWindow(GameEngine gameEngine)
	{
		super("SADI Dice Game");
		this.gameEngine = gameEngine;
		
		//set frame size and layout
		setBounds(300, 300, 800, 600);
		this.setLayout(new BorderLayout());

		//add custom menu bar
		setJMenuBar(new CustomMenuBar(this, gameEngine));
		
		//create dice panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,3));
		
		//add player dice
		JLabel player = new JLabel("Player:");
		player.setFont(new Font("Sefif", Font.BOLD, 36));
		centerPanel.add(player);
		pd1 = new DicePanel();
		centerPanel.add(pd1);
		pd2 = new DicePanel();
		centerPanel.add(pd2);
		
		//add house dice
		JLabel house = new JLabel("House:");
		house.setFont(new Font("Sefif", Font.BOLD, 36));
		centerPanel.add(house);
		hd1 = new DicePanel();
		centerPanel.add(hd1);
		hd2 = new DicePanel();
		centerPanel.add(hd2);
		
		//add dice panel to frame
		add(centerPanel);
		
		//add custom toolbar
		this.toolbar = new Toolbar(this, gameEngine, currentPlayer);
		add(toolbar, BorderLayout.PAGE_END);
		//add players list
		this.playersList = new PlayersList(this, this.gameEngine);
		add(playersList, BorderLayout.LINE_END);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	//return the current players id
	public String getCurrentPlayer()
	{
		return this.currentPlayer;
	}
//	set the current players id
	public void setCurrentPlayer(String player)
	{
		this.currentPlayer = player;
	}
	//refresh the frame when game info has been updated
	public void refreshFrame()
	{
		this.playersList.removeAll();
		this.playersList.drawList();
		this.playersList.revalidate();
		
		this.toolbar.updateToolbar();
		this.toolbar.revalidate();
	}
	//refresh the players dice
	public void refreshDice(DicePair dicePair)
	{
		if(dicePair == null)
		{
			pd1.updateDice(0);
			pd2.updateDice(0);
		}
		else
		{
			pd1.updateDice(dicePair.getDice1());
			pd2.updateDice(dicePair.getDice2());
		}
	}
	//refresh the house dice
	public void refreshHouseDice(DicePair dicePair)
	{	
		if(dicePair == null)
		{
			hd1.updateDice(0);
			hd2.updateDice(0);
		}
		else
		{
			hd1.updateDice(dicePair.getDice1());
			hd2.updateDice(dicePair.getDice2());
		}
	}
}
