import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ArtistId")
    private Artist artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Track> tracks;

    public Album() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public Artist getArtist() { return artist; }
    public void setArtist(Artist artist) { this.artist = artist; }
    public Set<Track> getTracks() { return tracks; }
    public void setTracks(Set<Track> tracks) { this.tracks = tracks; }
}

