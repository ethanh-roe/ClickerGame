/**
 * 
 */
package game;

import main.Game;

/**
 * @author eroe
 *
 */
public class GameMain {
	
	private int numbers = 0;
	private double clickMultiplyer = 1.0;
	private int numbersPerSecond = 0;
	
	
	public GameMain(Game game) {
		
	}
	
	public void incrementNumbersByClick() {
		
		numbers += clickMultiplyer;
	}


	public int getNumbers() {
		return numbers;
	}


	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}


	public double getClickMultiplyer() {
		return clickMultiplyer;
	}


	public void setClickMultiplyer(int clickMultiplyer) {
		this.clickMultiplyer = clickMultiplyer;
	}


	public int getNumbersPerSecond() {
		return numbersPerSecond;
	}


	public void setNumbersPerSecond(int numbersPerSecond) {
		this.numbersPerSecond = numbersPerSecond;
	}
	
	
}
