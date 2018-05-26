package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Cancel;
import controller.PlaceBet;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlaceBetDialog extends JDialog {
	PlaceBet placeBet;
	MainWindow frame;
	
	public PlaceBetDialog(MainWindow frame, GameEngine gameEngine)
	{
		super(frame, "Place Bet");
		this.frame = frame;
	//	JLabel heading = new JLabel("Place Bet");
		JTextField bet = new JTextField(30);
		JLabel betLabel = new JLabel("Enter Bet:");
		
		JButton place = new JButton("Place Bet");
		this.placeBet = new PlaceBet(frame, gameEngine, bet, this);
		place.addActionListener(this.placeBet);
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new Cancel(this));
		
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//				.addComponent(heading)
				.addGroup(layout.createSequentialGroup()
					.addComponent(betLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(bet, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addComponent(cancel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(place, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
//				.addComponent(heading)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(betLabel)
					.addComponent(bet))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cancel)
						.addComponent(place))
				);

		add(panel);
		setBounds(400, 400, 500, 400);
		pack();
		setVisible(true);
	}
}