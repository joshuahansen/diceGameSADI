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
import model.interfaces.GameEngine;

public class AddPlayerDialog extends JDialog{
	
	public AddPlayerDialog(Frame frame, GameEngine gameEngine)
	{
//		JDialog addPlayer = new JDialog(frame, "Add Player", true);
		JLabel heading = new JLabel("Add New Player");
		JTextField name = new JTextField(30);
		JTextField credit = new JTextField(30);
		JLabel nameLabel = new JLabel("Player Name:");
		JLabel creditLabel = new JLabel("Player Credit:");
		JButton save = new JButton("Add Player");
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new Cancel(this));
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(heading)
				.addGroup(layout.createSequentialGroup()
					.addComponent(nameLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(name, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addComponent(creditLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(credit, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addComponent(cancel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(save, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(heading)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(nameLabel)
					.addComponent(name))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(creditLabel)
					.addComponent(credit))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cancel)
						.addComponent(save))
				);

		add(panel);
		setBounds(200, 200, 500, 400);
		pack();
		setVisible(true);
	}
}
