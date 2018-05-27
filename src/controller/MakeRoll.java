package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * 
 * @author Joshua Hansen
 * ActionListener for player to roll dice
 * Player can only roll a dice if they have placed a bet
 * Once all players have rolled the house will roll
 */
public class MakeRoll implements ActionListener{
	String player;
	GameEngine gameEngine;
	
	public MakeRoll(GameEngine gameEngine, String player)
	{
		this.gameEngine = gameEngine;
		this.player = player;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//check if there is a player set
		if(this.gameEngine.getPlayer(player) != null)
		{
			//check if the player has made a bet
			if(this.gameEngine.getPlayer(player).getBet() > 0)
			{
				//start new tread to roll to allow GUI to still work while roll is in progress
				new Thread()
				{
					@Override
					public void run()
					{
						//roll the dice
						gameEngine.rollPlayer(gameEngine.getPlayer(player), 1, 10000, 800);
						//get list of players
						Collection<Player> players = gameEngine.getAllPlayers();
						boolean allBet = true;
						for(Player player : players)
						{
							//check if player has rolled
							if(player.getRollResult() == null)
							{
								allBet = false;
								break;
							}
						}
						//if all players have rolled house will roll
						if(allBet)
						{
							gameEngine.rollHouse(1, 10000, 800);
						}
					}
				}.start();
			}
		}
	}
	//update current player
	public void updatePlayer(String player)
	{
		this.player = player;
	}

}
