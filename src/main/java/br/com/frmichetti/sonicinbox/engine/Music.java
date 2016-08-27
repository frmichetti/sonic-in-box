/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.engine;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import br.com.frmichetti.sonicinbox.Start;
import br.com.frmichetti.sonicinbox.util.MyPath;


public class Music implements Runnable {

	private String MUSICA_TITLE_SCREEN = "title-screen.mid";
	private String MUSICA_AQUATIC_RUIN_ZONE = "aquatic-ruin-zone-2-.mid";
	private String MUSICA_FINAL_BOSS = "final-boss.mid";
	private String MUSICA_CHEMICAL_PLANT = "chemical-plant-zone-13-.mid";

	private boolean on;

	private Sequencer player;

	private Thread thread;    

	private String currentURL = MyPath.MUSICS_OPEN_SHIFT;

	public Music() {

		thread = new Thread(Start.tgrpEngine, this, "Music Thread");

		thread.setPriority(Thread.MIN_PRIORITY);		
		
		on = true;
	}


	public void doPlayMidi(URL from, int loop) {
		
		Sequence midi = null;
		
		try {
			
			player = javax.sound.midi.MidiSystem.getSequencer();
			
			midi = javax.sound.midi.MidiSystem.getSequence(from);
			
			player.open();
			
			player.setSequence(midi);
			
		} catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		player.setLoopCount(loop);
		
		player.start();

	}

	public void resume() {
		if (player.isOpen() && player.isRunning()) {
			player.stop();

		} else if (player.isOpen() && !player.isRunning()) {
			player.start();
		}
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {

		this.on = on;

		if (this.on) {

			player.start();

		} else {

			player.stop();
		}
	}    

	public Thread getThread() {
		return thread;
	}

	@Override
	public void run() {

			try {
				
				URL u = new URL(currentURL + MUSICA_CHEMICAL_PLANT);
				
				doPlayMidi(u, 100);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}			
	

		try {

			Thread.sleep(1000);               

		} catch (InterruptedException ex) {

			throw new RuntimeException("Falha ao Interromper " + thread.getName() + " " + ex);
		}

	}
}



