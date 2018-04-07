package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		DicePair dicePair = new DicePairImpl(4,3,NUM_FACES);
		this.gameEngineCallbacks.get(0).intermediateResult(player, dicePair, this);
		this.gameEngineCallbacks.get(0).result(player, dicePair, this);
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		// TODO Auto-generated method stub
		DicePair dicePair = new DicePairImpl(1,1,NUM_FACES);
		this.gameEngineCallbacks.get(0).intermediateHouseResult(dicePair, this);
		this.gameEngineCallbacks.get(0).houseResult(dicePair, this);
		
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
