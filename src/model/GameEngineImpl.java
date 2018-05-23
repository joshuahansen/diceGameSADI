package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine{

	Map<String, Player> players = new HashMap<String, Player>();
	List<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>();
	
	@Override
	public boolean placeBet(Player player, int bet) {
		if(!player.placeBet(bet))
		{
			return false;
		}
		else
			return true;
	}
	
	//randomly prints out dicePair results for each increment.
	//prints out final result for player and sets rollResults
	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		DicePair dicePair = null;
		Random rand = new Random();
		for(int delay = initialDelay; delay < finalDelay; delay += delayIncrement)
		{
			int d1 = rand.nextInt(NUM_FACES) + 1;
			int d2 = rand.nextInt(NUM_FACES) + 1;
			dicePair = new DicePairImpl(d1,d2,NUM_FACES);
			for(GameEngineCallback callback : this.gameEngineCallbacks)
			{
				callback.intermediateResult(player, dicePair, this);
			}
			try {
				Thread.sleep(delayIncrement);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(GameEngineCallback callback : this.gameEngineCallbacks)
		{
			callback.result(player, dicePair, this);
		}
		player.setRollResult(dicePair);
	}
	//same as rollPlayer but for the house
	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		DicePair dicePair = null;
		Random rand = new Random();
		for(int delay = initialDelay; delay < finalDelay; delay += delayIncrement)
		{
			int d1 = rand.nextInt(NUM_FACES) + 1;
			int d2 = rand.nextInt(NUM_FACES) + 1;
			dicePair = new DicePairImpl(d1,d2,NUM_FACES);
			for(GameEngineCallback callback : this.gameEngineCallbacks)
			{
				callback.intermediateHouseResult(dicePair, this);
			}
		}
		this.updatePlayers(dicePair);
		for(GameEngineCallback callback : this.gameEngineCallbacks)
		{
			callback.houseResult(dicePair, this);
		}
	}
	//loops through players and update points bet depending if they where higher or lower than the house dicePair
	private void updatePlayers(DicePair houseDice)
	{
		int houseTotal = houseDice.getDice1() + houseDice.getDice2();
		Collection<Player> allPlayers = this.getAllPlayers();
		for(Player player : allPlayers)
		{
			int playerTotal = player.getRollResult().getDice1() + player.getRollResult().getDice2();
			if(playerTotal < houseTotal)
				player.setPoints(player.getPoints() - player.getBet());
			else if(playerTotal > houseTotal)
				player.setPoints(player.getPoints() + player.getBet());
		}
	}

	@Override
	public void addPlayer(Player player) {
		this.players.put(player.getPlayerId(), player);		
	}

	@Override
	public Player getPlayer(String id) {
		return this.players.get(id);
	}

	@Override
	public boolean removePlayer(Player player) {
		this.players.remove(player.getPlayerId());
		return true;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return gameEngineCallbacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return this.players.values();
	}

}
