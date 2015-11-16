package audio;


public class AudioPlayer {
    private boolean useExternalSynth;

    private java.lang.String filename;

    private javax.sound.midi.Sequencer seq;

    public AudioPlayer(java.lang.String filename) {
        useExternalSynth = false;
        this.filename = filename;
        try {
            init();
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("Couldn\'t open audio file...");
            e.printStackTrace();
        }
    }

    private void init() throws java.lang.Exception {
        javax.sound.midi.MidiDevice receivingDevice = getReceivingDevice();
        receivingDevice.open();
        javax.sound.midi.Sequence sequence1 = javax.sound.midi.MidiSystem.getSequence(new java.io.File(filename));
        seq = javax.sound.midi.MidiSystem.getSequencer(false);
        javax.sound.midi.Transmitter tx1 = seq.getTransmitter();
        javax.sound.midi.Receiver rx1 = receivingDevice.getReceiver();
        tx1.setReceiver(rx1);
        seq.open();
        seq.setSequence(sequence1);
    }

    public void play() {
        if ((seq) != null)
            seq.start();
        
    }

    public void stop() {
        if ((seq) != null)
            seq.stop();
        
    }

    private javax.sound.midi.MidiDevice getReceivingDevice() throws javax.sound.midi.MidiUnavailableException {
        for (javax.sound.midi.MidiDevice.Info mdi : javax.sound.midi.MidiSystem.getMidiDeviceInfo()) {
            javax.sound.midi.MidiDevice dev = javax.sound.midi.MidiSystem.getMidiDevice(mdi);
            return dev;
        }
        return null;
    }

    private java.lang.String defaultString(java.lang.String s) {
        if (s == null)
            return "";
        
        return s;
    }
}

