/**
 * 
 */
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GameStates;

import static main.GameStates.*;

/**
 * @author eroe
 *
 */
public class KeyboardInputs implements KeyListener{

private Game game;
	
	public KeyboardInputs(Game game) {
		this.game = game;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			GameStates.gameState = MENU;
			break;
		case KeyEvent.VK_A:
			GameStates.gameState = PLAYING;
			break;
		case KeyEvent.VK_S:
			GameStates.gameState = SETTINGS;
			break;
		case KeyEvent.VK_D:
			GameStates.gameState = STATS;
			break;
		case KeyEvent.VK_Q:
			GameStates.gameState = ACHIEVEMENTS;
			break;
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
