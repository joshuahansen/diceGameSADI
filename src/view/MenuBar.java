package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import controller.Exit;

// Demonstrate basic menu functionality
// A more cohesive design for this example is available in Topic 6
// variable scope refactored by Caspar for better encapsulation
class CustomMenuBar extends JMenuBar
{
	public CustomMenuBar()
	{
		setBackground(Color.gray);

		// create Menu Bar
		JMenuBar menubar = new JMenuBar();
		// create Menu
		JMenu fileMenu = new JMenu("File");

		fileMenu.setMnemonic(KeyEvent.VK_F);
		menubar.add(fileMenu);

		JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_MASK));


		// add listeners to Menu Items

		exitItem.addActionListener(new Exit());

		// add MenuItems to the Menu

		fileMenu.add(exitItem);

		// and the Menu to the MenuBar
		menubar.add(fileMenu);
		add(menubar);
	}
}
