package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.SelectPlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
/**
 * 
 * @author Joshua Hansen
 *	Custom Panel that holds a list of players
 */
public class PlayersList extends JPanel {
	private JList<String> playersList;
	private MainWindow frame;
	private GameEngine gameEngine;

	//constructor to initialize list
	public PlayersList(MainWindow frame, GameEngine gameEngine)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
		drawList();
		setBorder(BorderFactory.createTitledBorder("Player List: "));
	}
	//Draw function for adding list and refreshing list on change
	public void drawList()
	{
		//create the model and add elements
				DefaultListModel<String> listModel = new DefaultListModel<>();
				for(Player player : gameEngine.getAllPlayers())
				{
					listModel.addElement(player.getPlayerId()+"-  "+player.getPlayerName()+ "    Credit: " + player.getPoints());
				}

				//create the list
				JScrollPane scrollPane = new JScrollPane();
				playersList = new JList<>(listModel);
				playersList.setFont(new Font("Sefif", Font.BOLD, 24));
				playersList.addListSelectionListener(new SelectPlayer(frame, gameEngine, listModel, playersList));
				
				//set size of list
				playersList.setPreferredSize(new Dimension(350, 350));
				playersList.setMinimumSize(new Dimension(350, 350));
				//add scrollpane to list
				scrollPane.setViewportView(playersList);
				add(playersList);
	}
}
