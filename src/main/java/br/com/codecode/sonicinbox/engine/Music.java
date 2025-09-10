package br.com.codecode.sonicinbox.engine;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import br.com.codecode.sonicinbox.Start;

// TODO: Auto-generated Javadoc
/**
 * The Class Music.
 */
public final class Music implements Runnable {

    /** The music title screen. */
    @SuppressWarnings("unused")
    private final String MUSIC_TITLE_SCREEN = "title-screen.mid";

    /** The music aquatic ruin zone. */
    @SuppressWarnings("unused")
    private final String MUSIC_AQUATIC_RUIN_ZONE = "aquatic-ruin-zone-2-.mid";

    /** The music final boss. */
    @SuppressWarnings("unused")
    private final String MUSIC_FINAL_BOSS = "final-boss.mid";

    /** The music chemical plant. */
    private final String MUSIC_CHEMICAL_PLANT = "chemical-plant-zone-13-.mid";

    /** The on. */
    private boolean on;

    /** The player. */
    private Sequencer player;

    /** The thread. */
    private Thread thread;

    /** The current URL. */
    private String currentURL;

    /**
     * Instantiates a new music.
     */
    private Music() {

	thread = new Thread(Start.tgrpEngine, this, "Music Thread");

	thread.setPriority(Thread.MIN_PRIORITY);

	on = true;
    }

    /**
     * Instantiates a new music.
     *
     * @param from the from
     */
    public Music(String from) {
	this();
	this.currentURL = from;
    }

    /**
     * Do play midi.
     *
     * @param from the from
     * @param loop the loop
     */
    public void doPlayMidi(String from, int loop) {

	Sequence midi = null;

	try {

	    player = MidiSystem.getSequencer();

	    midi = MidiSystem.getSequence(Music.class.getResourceAsStream(from));

	    player.open();

	    player.setSequence(midi);

	} catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {

	    e.printStackTrace();
	}

	player.setLoopCount(loop);

	player.start();

    }

    /**
     * Resume.
     */
    public void resume() {

	if (player.isOpen() && player.isRunning()) {
	    player.stop();

	} else if (player.isOpen() && !player.isRunning()) {
	    player.start();
	}
    }

    /**
     * Checks if is on.
     *
     * @return true, if is on
     */
    public boolean isOn() {

	return on;
    }

    /**
     * Sets the on.
     *
     * @param on the new on
     */
    public void setOn(boolean on) {

	this.on = on;

	if (this.on) {

	    player.start();

	} else {

	    player.stop();
	}
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

	doPlayMidi(currentURL + MUSIC_CHEMICAL_PLANT, 100);

	try {

	    Thread.sleep(1000);

	} catch (InterruptedException ex) {

	    throw new RuntimeException(ex);
	}

    }
}
