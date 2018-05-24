package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class Cancel implements ActionListener {
	JDialog dialog;
	public Cancel(JDialog dialog)
	{
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dialog.dispose();
	}

}
