public class Radio extends Component{
    private double frequency;

    public Radio(MakeType make, int model, int volume, double frequency) {
        super(make, model, volume);
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }

    public void tune(double frequency) {
        this.frequency = frequency;
    }
}
