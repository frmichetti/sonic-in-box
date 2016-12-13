package br.com.codecode.sonicinbox.engine;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import br.com.codecode.sonicinbox.Start;

public final class Music implements Runnable {

    @SuppressWarnings("unused")
    private final String MUSIC_TITLE_SCREEN = "title-screen.mid";

    @SuppressWarnings("unused")
    private final String MUSIC_AQUATIC_RUIN_ZONE = "aquatic-ruin-zone-2-.mid";

    @SuppressWarnings("unused")
    private final String MUSIC_FINAL_BOSS = "final-boss.mid";

    private final String MUSIC_CHEMICAL_PLANT = "chemical-plant-zone-13-.mid";

    private boolean on;

    private Sequencer player;

    private Thread thread;

    private String currentURL;

    private Music() {

	thread = new Thread(Start.tgrpEngine, this, "Music Thread");

	thread.setPriority(Thread.MIN_PRIORITY);

	on = true;
    }

    public Music(String from) {
	this();
	this.currentURL = from;
    }

    public void doPlayMidi(String from, int loop) {

	Sequence midi = null;

	try {

	    player = MidiSystem.getSequencer();

	    midi = MidiSystem.getSequence(ClassLoader.class.getResourceAsStream(from));

	    player.open();

	    player.setSequence(midi);

	} catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {

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
