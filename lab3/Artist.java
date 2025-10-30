import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Album> albums;

    public Artist() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Album> getAlbums() { return albums; }
    public void setAlbums(Set<Album> albums) { this.albums = albums; }
}

