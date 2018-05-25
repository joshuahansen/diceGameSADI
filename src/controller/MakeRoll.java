package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MakeRoll implements ActionListener{
	Player player;
	GameEngine gameEngine;
	
	public MakeRoll(GameEngine gameEngine, Player player)
	{
		this.gameEngine = gameEngine;
		this.player = player;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.gameEngine.rollPlayer(this.player, 1, 10000, 1000);
		this.gameEngine.rollHouse(1, 1000, 100);
	}

}
