import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
        name = "PlaylistTracks",
        joinColumns = { @JoinColumn(name = "PlaylistId") },
        inverseJoinColumns = { @JoinColumn(name = "TrackId") }
    )
    private Set<Track> tracks;

    // Геттери, сеттери та конструктори
}
