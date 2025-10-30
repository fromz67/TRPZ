import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tracks") 
public class TrackController {

    @Autowired
    private TrackService trackService; 

    public static class TrackRequest {
        public String title;
        public int duration;
        public String filePath;
        public int albumId;
    }

    @GetMapping
    public ResponseEntity<List<Track>> getAllTracks() {
        List<Track> tracks = trackService.getAllTracks();
        return ResponseEntity.ok(tracks);
    }

    @GetMapping("/{trackId}")
    public ResponseEntity<Track> getTrackById(@PathVariable int trackId) {
        Track track = trackService.getTrackById(trackId);
        return ResponseEntity.ok(track);
    }

    @PostMapping
    public ResponseEntity<Track> createTrack(@RequestBody TrackRequest request) {
        Track newTrack = trackService.createTrack(request);
        return new ResponseEntity<>(newTrack, HttpStatus.CREATED);
    }

    @DeleteMapping("/{trackId}")
    public ResponseEntity<Void> deleteTrack(@PathVariable int trackId) {
        trackService.deleteTrack(trackId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{trackId}")
    public ResponseEntity<Track> updateTrack(
            @PathVariable int trackId, 
            @RequestBody TrackRequest request) {
        Track updatedTrack = trackService.updateTrack(trackId, request);
        return ResponseEntity.ok(updatedTrack);
    }
}

