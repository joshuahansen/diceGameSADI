package view;

import java.util.Collection;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback {
	private MainWindow frame;	
	
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
