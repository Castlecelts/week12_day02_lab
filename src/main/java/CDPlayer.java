public class CDPlayer extends Component implements IEject, IInsert, IPlay, IStop {

    private int currentTrack;
    private Boolean trayFull, currentlyPlaying;

    public CDPlayer(MakeType make, int model, int volume) {
        super(make, model, volume);
        this.currentTrack = 0;
        this.trayFull = false;
        this.currentlyPlaying = false;
    }

    public int getCurrentTrack() {
        return currentTrack;
    }

    public void skipTrack(){
        if (trayFull){
        currentTrack++;
        }
    }


    public Boolean getTrayFull() {
        return trayFull;
    }

    public Boolean getCurrentlyPlaying() {
        return currentlyPlaying;
    }

    public void eject() {
        trayFull = false;
        currentTrack = 0;
    }

    public void insert() {
        trayFull = true;
        currentTrack = 1;
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

