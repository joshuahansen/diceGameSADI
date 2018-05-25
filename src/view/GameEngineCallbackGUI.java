package view;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback {
	public MainWindow frame;
	
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
				//TODO insert intermediate house result update
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
				//TODO insert house result update
			}
		});
	}
}
