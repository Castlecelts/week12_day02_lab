public abstract class Component {

    private MakeType make;
    private int model, volume;


    public Component(MakeType make, int model, int volume) {
        this.make = make;
        this.model = model;
        this.volume = volume;
    }

    public MakeType getMake() {
        return make;
    }

    public int getModel() {
        return model;
    }

    public int getVolume() {
        return volume;
    }

    public void changeVolume(int changeVolume){
        volume += changeVolume;
        if (volume < 0){
            volume = 0;
        }
        if (volume > 100){
            volume = 100;
        }
    }
}
