import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    // Spring Data JPA автоматично надає методи:
    // save(), findById(), findAll(), deleteById() та ін.
}
