import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Tracks")
public class Track {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String title;
 private int duration;
 private String filePath;
 @ManyToOne
 @JoinColumn(name = "AlbumId")
 private Album album;
 @ManyToMany(mappedBy = "tracks")
 private Set<Playlist> playlists;
 // геттери сетери
}


