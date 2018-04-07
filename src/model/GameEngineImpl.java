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
		return player.placeBet(bet);
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		// TODO Auto-generated method stub
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
		}
		for(GameEngineCallback callback : this.gameEngineCallbacks)
		{
			callback.result(player, dicePair, this);
		}
		player.setRollResult(dicePair);
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		this.players.put(player.getPlayerId(), player);		
	}

	@Override
	public Player getPlayer(String id) {
		// TODO Auto-generated method stub
		return this.players.get(id);
	}

	@Override
	public boolean removePlayer(Player player) {
		// TODO Auto-generated method stub
		this.players.remove(player.getPlayerId());
		return true;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		this.gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		return gameEngineCallbacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return this.players.values();
	}

}
