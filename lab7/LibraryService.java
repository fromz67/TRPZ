import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryService {

    private final List<Track> library = new ArrayList<>();

    public void addToLibrary(Track track) {
        library.add(track);
    }

    public List<Track> search(String query) {
        System.out.println("Пошук треків за запитом: \"" + query + "\"");
        return library.stream()
                .filter(t -> t.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
