import java.util.ArrayList;

public class Stereo {

    private ArrayList<Component> components;
    private String name;

    public Stereo(String name) {
        this.components = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void addComponent(Component component){
        components.add(component);
    }
}
