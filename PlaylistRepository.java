import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>
{
 // Spring сам реалізує всі базові CRUD-операції
}