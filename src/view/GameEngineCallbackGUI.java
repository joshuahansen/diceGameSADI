package view;

import java.util.Collection;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * @author Joshua Hansen
 * GameEngineCallbackGUI used for updating the GUI when the dice has been rolled
 * each function runs on its own thread
 */
public class GameEngineCallbackGUI implements GameEngineCallback {
	private MainWindow frame;	
	
	//Constructor for getting frame reference
	public GameEngineCallbackGUI(MainWindow mainWindow)
	{
		this.frame = mainWindow;
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		SwingUtilities.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						frame.refreshDice(dicePair);
					}
				});
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				frame.refreshDice(result);
			}
		});
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				frame.refreshHouseDice(dicePair);
			}
		});
	}

	//roll house then create new results window to display round results 
	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				frame.refreshHouseDice(result);
				new ResultsWindow(frame, gameEngine, result);
			}
		});
	}
}
