package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;

import controller.AddPlayer;
import controller.MakeBet;
import controller.MakeRoll;
import controller.PlaceBet;
import model.interfaces.GameEngine;
import model.interfaces.Player;
/**
 * 
 * @author Joshua Hansen
 * Custom Toolbar for player to bet, roll and see current status
 * shows current player and current bet
 */
public class Toolbar extends JToolBar{
	GameEngine gameEngine;
	String player;
	MainWindow frame;
	JLabel currentPlayer;
	JLabel currentPlayerBet;
	MakeRoll makeRoll;
	MakeBet makeBet;
	
	//constructor for initializing toolbar
	public Toolbar(MainWindow frame, GameEngine gameEngine, String player)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
		this.player = player;
		//set layout to a grid
		setLayout(new GridLayout(1,4));
		//add buttons to toolbar
		addButtons(this);
		//add current player details to toolbar
		if(this.frame.getCurrentPlayer() != null)
		{
			this.currentPlayer = new JLabel(this.gameEngine.getPlayer(this.frame.getCurrentPlayer()).getPlayerName());
			if(this.gameEngine.getPlayer(this.frame.getCurrentPlayer()).getBet() > 0)
				this.currentPlayerBet = new JLabel("Bet: $" + this.gameEngine.getPlayer(this.frame.getCurrentPlayer()).getBet());
			else
				this.currentPlayerBet = new JLabel("Bet: $0");
		}
		else
		{
			this.currentPlayer = new JLabel();
			this.currentPlayerBet = new JLabel();
		}
		currentPlayer.setFont(new Font("Sefif", Font.BOLD, 25));
		currentPlayerBet.setFont(new Font("Sefif", Font.BOLD, 25));
		add(currentPlayer);
		add(currentPlayerBet);
		System.out.println("added to panel");
		setPreferredSize(new Dimension(450,100));
	}
	//add buttons function
	protected void addButtons(JToolBar toolbar)
	{
		JButton button = null;
		//create bet button and add custom actionlistener
		button = makeButton("bet", "Place Bet", "Player can place bet");
		button.addActionListener(new MakeBet(this.frame, this.gameEngine));
		toolbar.add(button);
		//add roll button with custom actioneventlistener
		button = makeButton("roll", "Player Roll", "Player roll the dice");
		makeRoll = new MakeRoll(this.gameEngine, this.player);
		button.addActionListener(makeRoll);
		toolbar.add(button);
	}
	//generic make button function
	protected JButton makeButton(String img, String action, String tooltip)
	{
		//default size of button and image
		int btnH = 100;
		int btnW = 100;
		int imgH = 90;
		int imgW = 90;
		
		String imgLocation = "images/"+img+".png";
		URL imgURL = Toolbar.class.getResource(imgLocation);
		//create button and set size
		JButton button = new JButton();
		button.setMaximumSize(new Dimension(btnW, btnH));
		button.setPreferredSize(new Dimension(btnW,btnH));
		button.setActionCommand(action);
		button.setToolTipText(tooltip);
		//set image and resize to fit button
		ImageIcon icon = new ImageIcon(imgURL);
		Image iconImage = icon.getImage();
		Image newImage = iconImage.getScaledInstance(imgW, imgH, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);
		button.setIcon(newIcon);
		return button;
	}
	//update toolbar with current player
	public void updateToolbar()
	{
		this.currentPlayer.setText(this.gameEngine.getPlayer(this.frame.getCurrentPlayer()).getPlayerName());
		if(gameEngine.getPlayer(this.frame.getCurrentPlayer()).getBet() > 0)
			this.currentPlayerBet.setText("Bet: $" + this.gameEngine.getPlayer(frame.getCurrentPlayer()).getBet());
		else
			this.currentPlayerBet.setText("Bet: $0");
		this.makeRoll.updatePlayer(this.frame.getCurrentPlayer());
		repaint();
	}
}
