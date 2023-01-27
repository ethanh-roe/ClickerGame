/**
 * 
 */
package audio;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author eroe
 *
 */
public class AudioPlayer {

	public static int BUTTON_CLICK_DOWN = 0;
	public static int BUTTON_CLICK_RELEASE = 1;
	public static int BUTTON_CLICK = 2;

	private Clip[] effects;
	private float volume = 0.5f;
	private boolean songMute, effectMute;

	public AudioPlayer() {
		loadSongs();
		loadEffects();
	}

	private void loadSongs() {

	}

	private void loadEffects() {
		String[] effectNames = { "ButtonClickDown1", "ButtonClickRelease", "ButtonClick" };
		effects = new Clip[effectNames.length];
		for (int i = 0; i < effectNames.length; i++) {
			System.out.println(i);
			effects[i] = getClip(effectNames[i]);
		}
	}

	private Clip getClip(String name) {
		URL url = this.getClass().getResource("/audio/" + name + ".wav");
		System.out.println(url);
		AudioInputStream audio;

		try {
			audio = AudioSystem.getAudioInputStream(url);
			Clip c = AudioSystem.getClip();
			c.open(audio);
			return c;

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void toggelEffectMute() {
		this.effectMute = !songMute;
		for (Clip c : effects) {
			BooleanControl booleanControl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
			booleanControl.setValue(effectMute);
		}
	}

	public void playEffect(int effect) {
		effects[effect].start();	
		
	}
	
	

}
