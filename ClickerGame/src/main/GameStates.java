/**
 * 
 */
package main;

/**
 * @author eroe
 *
 */
public enum GameStates {

	PLAYING, MENU, SETTINGS, STATS, ACHIEVEMENTS;

	public static GameStates gameState = MENU;
	
	public static void setGameState(GameStates state) {
		gameState = state;
	}

}
