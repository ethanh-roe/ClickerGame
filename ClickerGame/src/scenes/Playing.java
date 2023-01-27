/**
 * 
 */
package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import game.GameMain;
import main.Game;
import ui.MyButton;
import ui.MyLabel;

/**
 * @author eroe
 *
 */
public class Playing extends GameScene implements SceneMethods {

	private BufferedImage img;

	private MyButton bClick;
	
	private MyLabel lNumNumbers;
	
	private GameMain gameMain;

	public Playing(Game game) {
		super(game);
		gameMain = new GameMain(game);
		importImage();
		initButtons();
		initLabels();
	}
	
	private void initLabels() {
		lNumNumbers = new MyLabel("0 numbers", 100, 775, 300, 75);
	}

	private void initButtons() {
		bClick = new MyButton("Click Me", 100, 450, 300, 300);
	}
		
	
	private void drawButtons(Graphics g) {
		bClick.draw(g);
	}
	
	private void drawLabels(Graphics g) {
		lNumNumbers.draw(g);
	}

	@Override
	public void render(Graphics g) {
		drawButtons(g);
		drawLabels(g);

	}

	private void importImage() {
		InputStream is = getClass().getResourceAsStream("/img/ClickMe.jpg");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(int x, int y) {
		if (bClick.getBounds().contains(x, y)) {
			gameMain.incrementNumbersByClick();
			lNumNumbers.setText(gameMain.getNumbers() + " numbers");
		}

	}

	@Override
	public void mouseMoved(int x, int y) {
		if (bClick.getBounds().contains(x, y)) {
			bClick.setMouseOver(true);
		} else {
			bClick.setMouseOver(false);
		}
	}

	@Override
	public void mousePressed(int x, int y) {
		if (bClick.getBounds().contains(x, y)) {
			bClick.setMousePressed(true);
		}

	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();

	}

	private void resetButtons() {
		if (bClick.getMousePressed()) {
			bClick.resetBooleans();
		}

	}

}
