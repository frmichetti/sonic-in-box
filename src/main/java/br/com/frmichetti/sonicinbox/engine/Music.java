/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.engine;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import br.com.frmichetti.sonicinbox.Start;


public class Music implements Runnable {

    private String MUSICA_TITLE_SCREEN = "title-screen.mid";
    private String MUSICA_AQUATIC_RUIN_ZONE = "aquatic-ruin-zone-2-.mid";
    private String MUSICA_FINAL_BOSS = "final-boss.mid";
    private String MUSICA_CHEMICAL_PLANT = "chemical-plant-zone-13-.mid";

    private boolean on;
    
    private Sequencer player;

    private Thread thread;

    private URL currentURL;

    public Music(URL from) throws InterruptedException {

        currentURL = from;

        thread = new Thread(Start.tgrpEngine, this, "Thread da Musica");
        
        thread.setPriority(Thread.MIN_PRIORITY);

    }

    public Music(URL from, boolean on) throws InterruptedException {
        this(from);
        this.on = on;
    }
    
    public Music(URI from, boolean on) throws InterruptedException, MalformedURLException {
        this(from.toURL());
        this.on = on;
    }


    public void tocarMidi(URL from, int loop) throws MidiUnavailableException, InvalidMidiDataException, IOException {
        Sequence midi = null;
        player = javax.sound.midi.MidiSystem.getSequencer();
        midi = javax.sound.midi.MidiSystem.getSequence(from);
        player.open();
        player.setSequence(midi);
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

        if (currentURL.getFile().equals("")) {

            System.out.println("Url das Musicas não Encontrado");

        } else {

            System.out.println("Resource Musics : " + currentURL.toString());
            
            System.out.println("");

            try {

                tocarMidi(new URL(currentURL.toString() + MUSICA_CHEMICAL_PLANT), 100);

            } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {

                System.err.println("Não foi Possível iniciar a Musica : " + ex.getMessage());
            }

            try {
            	
                Thread.sleep(1000);               

            } catch (InterruptedException ex) {

            	throw new RuntimeException("Falha ao Interromper " + thread.getName() + " " + ex);
            }

        }
    }


}
