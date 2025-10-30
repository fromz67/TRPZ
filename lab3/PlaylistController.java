import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    public static class CreatePlaylistRequest {
        public String name;
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody CreatePlaylistRequest request) {
        Playlist newPlaylist = playlistService.createPlaylist(request.name);
        return new ResponseEntity<>(newPlaylist, HttpStatus.CREATED);
    }

    @PostMapping("/{playlistId}/tracks")
    public ResponseEntity<Playlist> addTrack(
            @PathVariable int playlistId, 
            @RequestBody int trackId) {
        Playlist updatedPlaylist = playlistService.addTrackToPlaylist(playlistId, trackId);
        return ResponseEntity.ok(updatedPlaylist);
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        List<Playlist> playlists = playlistService.getAllPlaylists();
        return ResponseEntity.ok(playlists);
    }
}

