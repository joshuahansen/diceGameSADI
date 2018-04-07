package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
	private Logger logger = Logger.getLogger("assignment1");

	public GameEngineCallbackImpl()
	{
		// FINE shows rolling output, INFO only shows result
		logger.setLevel(Level.FINE);
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
	{
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, "Intermediate data to log .. String.format() is good here!");
		// TO DO: complete this method to log results
		logger.log(Level.FINE, player.getPlayerName() + ": ROLLING " + "Dice 1: " + dicePair.getDice1() 
				+ " Dice 2: " + dicePair.getDice2() + " .. Total: " + (dicePair.getDice1()+dicePair.getDice2()));
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine)
	{
		// final results logged at Level.INFO
		logger.log(Level.INFO, "Result data to log .. String.format() is good here!");
		// TO DO: complete this method to log results
		logger.log(Level.INFO, player.getPlayerName() + ": *RESULT* " + "Dice 1: " + result.getDice1() 
		+ " Dice 2: " + result.getDice2() + " .. Total: " + (result.getDice1()+result.getDice2()));
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, "Intermediate data to log .. String.format() is good here!");
		// TO DO: complete this method to log results
		logger.log(Level.FINE, "House: ROLLING " + "Dice 1: " + dicePair.getDice1() 
		+ " Dice 2: " + dicePair.getDice2() + " .. Total: " + (dicePair.getDice1()+dicePair.getDice2()));
		
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, "Result data to log .. String.format() is good here!");
		// TODO Auto-generated method stub
		logger.log(Level.INFO, "House: *RESULT* " + "Dice 1: " + result.getDice1() 
		+ " Dice 2: " + result.getDice2() + " .. Total: " + (result.getDice1()+result.getDice2()));
	}

	// TO DO: complete the GameEngineCallback interface implementation

}
