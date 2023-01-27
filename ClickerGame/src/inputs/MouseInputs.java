/**
 * 
 */
package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameStates;

/**
 * @author eroe
 *
 */
public class MouseInputs implements MouseListener, MouseMotionListener {

	private Game game;

	public MouseInputs(Game game) {
		this.game = game;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

			switch (GameStates.gameState) {
			case MENU:
				game.getMenu().mouseMoved(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlaying().mouseMoved(e.getX(), e.getY());
				break;
			case SETTINGS:
				game.getSettings().mouseMoved(e.getX(), e.getY());
				break;
			case STATS:
				game.getStats().mouseMoved(e.getX(), e.getY());
				break;
			case ACHIEVEMENTS:
				game.getAchievements().mouseMoved(e.getX(), e.getY());
				break;
			}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1) {

			switch (GameStates.gameState) {
			case MENU:
				game.getMenu().mouseClicked(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlaying().mouseClicked(e.getX(), e.getY());
				break;
			case SETTINGS:
				game.getSettings().mouseClicked(e.getX(), e.getY());
				break;
			case STATS:
				game.getStats().mouseClicked(e.getX(), e.getY());
				break;
			case ACHIEVEMENTS:
				game.getAchievements().mouseClicked(e.getX(), e.getY());
				break;
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (GameStates.gameState) {
		case MENU:
			game.getMenu().mousePressed(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().mousePressed(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().mousePressed(e.getX(), e.getY());
			break;
		case STATS:
			game.getStats().mousePressed(e.getX(), e.getY());
			break;
		case ACHIEVEMENTS:
			game.getAchievements().mousePressed(e.getX(), e.getY());
			break;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (GameStates.gameState) {
		case MENU:
			game.getMenu().mouseReleased(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().mouseReleased(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().mouseReleased(e.getX(), e.getY());
			break;
		case STATS:
			game.getStats().mouseReleased(e.getX(), e.getY());
			break;
		case ACHIEVEMENTS:
			game.getAchievements().mouseReleased(e.getX(), e.getY());
			break;
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
