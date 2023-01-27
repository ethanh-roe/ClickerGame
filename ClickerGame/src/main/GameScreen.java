/**
 * 
 */
package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

/**
 * @author eroe
 *
 */
public class GameScreen extends JPanel {

	public int panelWidth, panelHeight;

	private Game game;
	public Dimension size;

	private KeyboardInputs keyboardInputs;
	private MouseInputs mouseInputs;


	public GameScreen(Game game, int panelWidth, int panelHeight) {
		this.game = game;

		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;

		initInputs();
		setPanelSize();
		setVisible(true);
	}

	private void initInputs() {
		keyboardInputs = new KeyboardInputs(game);
		mouseInputs = new MouseInputs(game);

		addKeyListener(keyboardInputs);
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

		requestFocus();

	}

	public int getPanelWidth() {
		return panelWidth;
	}

	public int getPanelHeight() {
		return panelHeight;
	}

	private void setPanelSize() {
		size = new Dimension(panelWidth, panelHeight);

		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		game.getRender().render(g);

	}

}
