package client;

import javax.swing.*;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.*;
/**
 * Simple test function for starting the GUI
 * @author Joshua Hansen
 *
 */
public class SimpleTestClient
{
	public static void main(String args[])
	{
		// instantiate the GameEngine so we can make calls
		final GameEngine gameEngine = new GameEngineImpl();

		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

		MainWindow mainWindow = new MainWindow(gameEngine);
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(mainWindow));
	}
}
