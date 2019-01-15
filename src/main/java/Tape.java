public class Tape extends Component implements IEject, IInsert, IPlay, IStop{
    private double tapePosition;
    private boolean trayFull, currentlyPlaying;

    public Tape(MakeType make, int model, int volume) {
        super(make, model, volume);
        this.tapePosition = 0;
        this.trayFull = false;
        this.currentlyPlaying = false;
    }

    public double getTapePosition() {
        return tapePosition;
    }

    public void rewind(double amount){
        tapePosition -= amount;
        if (tapePosition<0){
            tapePosition = 0;
        }
    }

    public void fastForward(double amount){
        if (!trayFull) {return;}
        tapePosition += amount;
        if (tapePosition>100){
            tapePosition = 100;
        }
    }


    public boolean getTrayFull() {
        return trayFull;
    }

    public boolean getCurrentlyPlaying() {
        return currentlyPlaying;
    }

    public void eject() {
        trayFull = false;
        tapePosition = 0;
    }

    public void insert() {
    trayFull = true;
    }

    public void play() {
    if (trayFull){
        currentlyPlaying = true;
    }
    }

    public void stop() {
        currentlyPlaying = false;
    }

}
