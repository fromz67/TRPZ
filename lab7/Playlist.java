import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final String name;
    private final List<Track> tracks = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public void addTrack(Track track) {
        tracks.add(track);
        System.out.println("Трек \"" + track.getTitle() +
                "\" додано до плейлиста \"" + name + "\"");
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public String getName() {
        return name;
    }
}
