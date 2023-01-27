/**
 * 
 */
package main;

import javax.swing.JFrame;

import game.GameMain;
import scenes.Achievements;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;
import scenes.Stats;

/**
 * @author eroe
 *
 */
public class Game extends JFrame implements Runnable {
	private GameScreen gameScreen;
	
	private Thread gameThread;
	
	private final int defaultPanelWidth = 1440;
	private final int defaultPanelHeight = 900;
	
	private int panelWidth;
	private int panelHeight;

	

	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;

	// classes
	private Render render;
	private Menu menu;
	private Settings settings;
	private Playing playing;
	private Stats stats;
	private Achievements achievements;


	
	
	public Game() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panelWidth = defaultPanelWidth;
		panelHeight = defaultPanelHeight;
		initClasses();
	
		add(gameScreen);
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
		
	}
	
	public int getPanelWidth() {
		return panelWidth;
	}
	public int getPanelHeight() {
		return panelHeight;
	}
	
	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}
	
	public void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}

	private void initClasses() {
		render = new Render(this);
		gameScreen = new GameScreen(this, panelWidth, panelHeight);
		menu = new Menu(this);
		settings = new Settings(this);
		playing = new Playing(this);
		stats = new Stats(this);
		achievements = new Achievements(this);
	}

	private void start() {
		gameThread = new Thread(this) {

		};
		
		gameThread.start();
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();

		int frames = 0;
		int updates = 0;

		while (true) {

			// render
			if (System.nanoTime() - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = System.nanoTime();
				frames++;

			}
			// update
			if (System.nanoTime() - lastUpdate >= timePerUpdate) {
				lastUpdate = System.nanoTime();
				updates++;
			}

			if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}

		}

	}


	public static void main(String[] args) {
		Game game = new Game();
		game.start();

	}

	
	public Render getRender() {
		return render;
	}

	public Menu getMenu() {
		return menu;
	}

	public Settings getSettings() {
		return settings;
	}

	public Playing getPlaying() {
		return playing;
	}

	public Stats getStats() {
		return stats;
	}

	public Achievements getAchievements() {
		return achievements;
	}

}
