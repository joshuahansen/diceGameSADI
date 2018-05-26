package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

import model.interfaces.GameEngine;
import model.interfaces.Player;

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
		if(this.gameEngine.getPlayer(player) != null)
		{
			if(this.gameEngine.getPlayer(player).getBet() > 0)
			{
				new Thread()
				{
					@Override
					public void run()
					{
						gameEngine.rollPlayer(gameEngine.getPlayer(player), 1, 10000, 800);
						Collection<Player> players = gameEngine.getAllPlayers();
						boolean allBet = true;
						for(Player player : players)
						{
							if(player.getRollResult() == null)
							{
								allBet = false;
								break;
							}
						}
						if(allBet)
						{
							gameEngine.rollHouse(1, 10000, 800);
						}
					}
				}.start();
			}
		}
	}
	public void updatePlayer(String player)
	{
		this.player = player;
	}

}
