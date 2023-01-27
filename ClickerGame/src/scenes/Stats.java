/**
 * 
 */
package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

/**
 * @author eroe
 *
 */
public class Stats extends GameScene implements SceneMethods{

	public Stats(Game game) {
		super(game);	  
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(100, 100, 250, 50);
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
