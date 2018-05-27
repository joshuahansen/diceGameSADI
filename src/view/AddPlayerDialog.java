package view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Cancel;
import controller.SaveNewPlayer;
import model.interfaces.GameEngine;

/**
 * @author Joshua Hansen
 * Dialog to add player
 */
public class AddPlayerDialog extends JDialog{
	
	/**
	 * Constructor to create a custom dialog
	 * @param frame: main window frame
	 * @param gameEngine game engine stores all game data
	 */
	public AddPlayerDialog(MainWindow frame, GameEngine gameEngine)
	{
		//create the labels and text fields
		JLabel heading = new JLabel("Add New Player");
		JTextField name = new JTextField(30);
		JTextField credit = new JTextField(30);
		JLabel nameLabel = new JLabel("Player Name:");
		JLabel creditLabel = new JLabel("Player Credit:");
		//add player button and custom actionEventListnener
		JButton save = new JButton("Add Player");
		save.addActionListener(new SaveNewPlayer(gameEngine, frame, name, credit, this));
		//cancel button with custom actionEventListener
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new Cancel(this));
		//panel that holds all components
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		//set out components in a Group layout pattern
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
		//add panel to dialog
		add(panel);
		//set dialog size and position
		setBounds(400, 400, 500, 400);
		pack();
		setVisible(true);
	}
}
