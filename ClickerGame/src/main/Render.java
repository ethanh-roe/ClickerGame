/**
 * 
 */
package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * @author eroe
 *
 */
public class Render {

	
	private Game game;

	public Render(Game game) {
		this.game = game;
		
		
	}

	public void render(Graphics g) {

		switch (GameStates.gameState) {
		case PLAYING:
			game.getPlaying().render(g);
			break;
		case MENU:
			game.getMenu().render(g);
			break;
		case SETTINGS:
			game.getSettings().render(g);
			break;
		case STATS:
			game.getStats().render(g);
			break;
		case ACHIEVEMENTS:
			game.getAchievements().render(g);
			break;
		}

	}
	
	
}
