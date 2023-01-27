/**
 * 
 */
package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;
import ui.MyButton;

/**
 * @author eroe
 *
 */
public class Settings extends GameScene implements SceneMethods {

	private MyButton bToggleFullScreen, bToggleMusic, bToggleSound;

	private int panelWidth, panelHeight;

	private final int numButtons = 3;

	public Settings(Game game) {
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

		bToggleFullScreen = new MyButton("Toggle Full Screen", getButtonX(), getButtonY(1), bWidth, bHeight);
		bToggleMusic = new MyButton("Toggle Music", getButtonX() - (bWidth / 2), getButtonY(2), bWidth, bHeight);
		bToggleSound = new MyButton("Toggle Sound", getButtonX() + (bWidth / 2), getButtonY(2), bWidth, bHeight);

	}

	private void drawButtons(Graphics g) {
		
		bToggleFullScreen.draw(g);
		bToggleMusic.draw(g);
		bToggleSound.draw(g);
	}

	@Override
	public void render(Graphics g) {

		drawButtons(g);
	}

	@Override
	public void mouseClicked(int x, int y) {
		
		if (bToggleFullScreen.getBounds().contains(x, y)) {

		} else if (bToggleMusic.getBounds().contains(x, y)) {
			
		} else if (bToggleSound.getBounds().contains(x, y)) {
			
		}

	}

	@Override
	public void mouseMoved(int x, int y) {
		
		if (bToggleFullScreen.getBounds().contains(x, y)) {
			bToggleFullScreen.setMouseOver(true);
		} else {
			bToggleFullScreen.setMouseOver(false);
		}

		if (bToggleMusic.getBounds().contains(x, y)) {
			bToggleMusic.setMouseOver(true);
		} else {
			bToggleMusic.setMouseOver(false);
		}

		if (bToggleSound.getBounds().contains(x, y)) {
			bToggleSound.setMouseOver(true);
		} else {
			bToggleSound.setMouseOver(false);
		}

	}

	@Override
	public void mousePressed(int x, int y) {
		
		if (bToggleFullScreen.getBounds().contains(x, y)) {
			bToggleFullScreen.setMousePressed(true);
		} else if (bToggleMusic.getBounds().contains(x, y)) {
			bToggleMusic.setMousePressed(true);
		} else if (bToggleSound.getBounds().contains(x, y)) {
			bToggleSound.setMousePressed(true);
		}

	}

	@Override
	public void mouseReleased(int x, int y) {
		
		resetButtons();
	}
	
	private void resetButtons() {
		if(bToggleFullScreen.getMousePressed()) {
			bToggleFullScreen.resetBooleans();
		}else if(bToggleMusic.getMousePressed()) {
			bToggleMusic.resetBooleans();
		}else if(bToggleSound.getMousePressed()) {
			bToggleSound.resetBooleans();
		}
	}

}
