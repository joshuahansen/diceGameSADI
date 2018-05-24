package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.MenuBar;

import javax.swing.*;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainWindow extends JFrame{
	
	public MainWindow(GameEngine gameEngine, Player[] players)
	{
		setBounds(100, 100, 800, 600);
		// if you wanted to start with JFrame maximized
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel greeting = new JLabel("Welcome to the dice game");
		// this. is optional .. we are calling the method on the JFrame
		this.setLayout(new BorderLayout());
		add(greeting, BorderLayout.PAGE_START);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new CustomMenuBar());
		this.add(new Toolbar(this, gameEngine, players[0]));
		setVisible(true);
	}

}
