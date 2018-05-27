package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import controller.AddPlayer;
import controller.Exit;
import model.interfaces.GameEngine;
/**
 * 
 * @author Joshua Hansen
 * Custom Menu Bar 
 */
class CustomMenuBar extends JMenuBar
{
	public CustomMenuBar(MainWindow frame, GameEngine gameEngine)
	{
		// create Menu
		JMenu fileMenu = new JMenu("File");

		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		//create menu items with keyboard shortcuts
		JMenuItem addPlayer = new JMenuItem("Add Player", KeyEvent.VK_N);
		addPlayer.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.ALT_MASK));
		
		JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_MASK));
		
		// add listeners to Menu Items

		exitItem.addActionListener(new Exit());
		addPlayer.addActionListener(new AddPlayer(frame, gameEngine));

		// add MenuItems to the Menu
		
		fileMenu.add(addPlayer);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		// and the Menu to the MenuBar
		add(fileMenu);
	}
}
