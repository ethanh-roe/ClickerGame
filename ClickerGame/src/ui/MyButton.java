/**
 * 
 */
package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import audio.AudioPlayer;

/**
 * @author eroe
 *
 */
public class MyButton {

	private int x, y, width, height;
	private String text;
	private Rectangle bounds;
	private AudioPlayer audio = new AudioPlayer();;
	private boolean mouseOver, mousePressed;

	public MyButton(String text, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		
		initBounds();
	}

	private void initBounds() {
		this.bounds = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g) {

		if (mousePressed) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 39));
			drawBodyPressed(g);
			drawBorderPressed(g);
			drawTextPressed(g);

		} else {
			g.setFont(new Font("TimesRoamn", Font.PLAIN, 40));
			drawBody(g);
			drawBorder(g);
			drawText(g);
		}

	}
	private void drawBodyPressed(Graphics g) {
		if (mouseOver) {
			g.setColor(Color.gray);
		} else {
			g.setColor(Color.white);
		}
		g.fillRect(x + 3, y + 3, width - 6, height - 6);
	}
	
	private void drawBorderPressed(Graphics g) {
		
		g.setColor(Color.black);
		g.drawRect(x + 3, y + 3, width - 6, height - 6);
	}
	
	private void drawTextPressed(Graphics g) {
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		
		g.drawString(text, (x + 3) - w / 2 + (width - 6) / 2, (y + 3) + h / 3 + (height - 6) / 2);
	}
	private void drawBorder(Graphics g) {
		
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		
	}

	private void drawBody(Graphics g) {
		if (mouseOver) {
			g.setColor(Color.gray);
		} else {
			g.setColor(Color.white);
		}
		g.fillRect(x, y, width, height);

	}

	private void drawText(Graphics g) {
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();

		g.drawString(text, x - w / 2 + width / 2, y + h / 3 + height / 2);

	}

	public void resetBooleans() {
		this.mouseOver = false;
		this.mousePressed = false;
//		this.audio.playEffect(AudioPlayer.BUTTON_CLICK_DOWN);
		
	}
	
	public boolean getMousePressed() {
		return this.mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
		this.audio.playEffect(AudioPlayer.BUTTON_CLICK_RELEASE);
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
		
	}

	public Rectangle getBounds() {
		return bounds;
	}

}
