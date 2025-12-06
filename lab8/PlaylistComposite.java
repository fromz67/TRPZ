import java.util.ArrayList;
import java.util.List;

public class PlaylistComposite extends MusicComponent {

    private final String name;
    private final List<MusicComponent> components = new ArrayList<>();

    public PlaylistComposite(String name) {
        this.name = name;
    }

    @Override
    public void add(MusicComponent component) {
        components.add(component);
    }

    @Override
    public void remove(MusicComponent component) {
        components.remove(component);
    }

    @Override
    public void play() {
        System.out.println("\n=== Плейлист: " + name + " ===");
        for (MusicComponent component : components) {
            component.play();
        }
    }
}
