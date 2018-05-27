package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Joshua Hasnen
 * ActionListener for exiting the program
 */
public class Exit implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
	}

}
