/**
 * 
 */
package ui;

import java.awt.Graphics;

/**
 * @author eroe
 *
 */
public class MyLabel {

	private String text;
	private int x, y, width, height;

	public MyLabel(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public void draw(Graphics g) {
		drawBody(g);
		drawBorder(g);
		drawText(g);
	}

	private void drawBody(Graphics g) {

	}

	private void drawBorder(Graphics g) {

	}

	private void drawText(Graphics g) {
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();

		g.drawString(text, x - w / 2 + width / 2, y + h / 3 + height / 2);

	}

}
