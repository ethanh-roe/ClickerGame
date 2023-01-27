/**
 * 
 */
package scenes;

import java.awt.Graphics;
import main.Game;
import ui.MyButton;

import static main.GameStates.*;

/**
 * @author eroe
 *
 */
public class Menu extends GameScene implements SceneMethods {

	private MyButton bPlaying, bSettings, bStats, bAchievements;

	private int panelWidth, panelHeight;

	private final int numButtons = 4;

	public Menu(Game game) {
		super(game);
		
		panelWidth = game.getPanelWidth();
		panelHeight = game.getPanelHeight();

		initButtons();

	}

	private int getButtonWidth() {
		return panelWidth / numButtons;
	}

	private int getButtonHeight() {
		return ((panelHeight * 3) / 4) / numButtons;
	}

	private int getButtonX() {
		return ((panelWidth / 2) - (getButtonWidth() / 2));
	}

	private int getButtonY(int n) {
		if (n == 1) {
			return ((panelHeight / 32) + ((n * getButtonHeight()) - getButtonHeight()));
		} else {
			return ((panelHeight / 32) + ((n * getButtonHeight()) - getButtonHeight()) + (n - 1) * 50);
		}

	}

	private void initButtons() {

		int bWidth = getButtonWidth();
		int bHeight = getButtonHeight();

		bPlaying = new MyButton("Play", getButtonX(), getButtonY(1), bWidth, bHeight);
		bSettings = new MyButton("Settings", getButtonX(), getButtonY(2), bWidth, bHeight);
		bStats = new MyButton("Statistics", getButtonX(), getButtonY(3), bWidth, bHeight);
		bAchievements = new MyButton("Achievements", getButtonX(), getButtonY(4), bWidth, bHeight);
	}
	
	private void drawButtons(Graphics g) {
		bPlaying.draw(g);
		bSettings.draw(g);
		bStats.draw(g);
		bAchievements.draw(g);
	}

	@Override
	public void render(Graphics g) {

		drawButtons(g);
	}

	

	@Override
	public void mouseClicked(int x, int y) {
		if (bPlaying.getBounds().contains(x, y)) {
			setGameState(PLAYING);
			
		} else if (bSettings.getBounds().contains(x, y)) {
			setGameState(SETTINGS);
			
		} else if (bStats.getBounds().contains(x, y)) {
			setGameState(STATS);
			
		} else if (bAchievements.getBounds().contains(x, y)) {
			setGameState(ACHIEVEMENTS);
		}

	}

	@Override
	public void mouseMoved(int x, int y) {
		if (bPlaying.getBounds().contains(x, y)) {
			bPlaying.setMouseOver(true);
		} else {
			bPlaying.setMouseOver(false);
		}

		if (bSettings.getBounds().contains(x, y)) {
			bSettings.setMouseOver(true);
		} else {
			bSettings.setMouseOver(false);
		}

		if (bStats.getBounds().contains(x, y)) {
			bStats.setMouseOver(true);
		} else {
			bStats.setMouseOver(false);
		}

		if (bAchievements.getBounds().contains(x, y)) {
			bAchievements.setMouseOver(true);
		} else {
			bAchievements.setMouseOver(false);
		}

	}

	@Override
	public void mousePressed(int x, int y) {
		if (bPlaying.getBounds().contains(x, y)) {
			
			bPlaying.setMousePressed(true);
			
		} else if (bSettings.getBounds().contains(x, y)) {
			
			bSettings.setMousePressed(true);
			
		} else if (bStats.getBounds().contains(x, y)) {
			
			bStats.setMousePressed(true);
			
		} else if (bAchievements.getBounds().contains(x, y)) {
			
			bAchievements.setMousePressed(true);
		}

	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
		

	}

	private void resetButtons() {
		if(bPlaying.getMousePressed()) {
			bPlaying.resetBooleans();
		}else if(bSettings.getMousePressed()) {
			bSettings.resetBooleans();
		}else if(bStats.getMousePressed()) {
			bStats.resetBooleans();
		}else if(bAchievements.getMousePressed()) {
			bAchievements.resetBooleans();
		}
		
	}

}
