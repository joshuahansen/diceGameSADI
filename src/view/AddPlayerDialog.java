package view;

import java.awt.Frame;

import javax.swing.JDialog;

import model.interfaces.GameEngine;

public class AddPlayerDialog extends JDialog{
	
	public AddPlayerDialog(Frame frame, GameEngine gameEngine)
	{
		super(frame, "Add New Player", true);
		JDialog addPlayer = new JDialog();
		setVisible(true);
	}

}
