import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private AlbumRepository albumRepository; 
  
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Track getTrackById(int trackId) {
        return trackRepository.findById(trackId)
                .orElseThrow(() -> new RuntimeException("Track not found with id: " + trackId));
    }

    public Track createTrack(TrackController.TrackRequest request) {
        Album album = albumRepository.findById(request.albumId)
                .orElseThrow(() -> new RuntimeException("Album not found with id: " + request.albumId));

        Track newTrack = new Track();
        newTrack.setTitle(request.title);
        newTrack.setDuration(request.duration);
        newTrack.setFilePath(request.filePath);
        newTrack.setAlbum(album);

        return trackRepository.save(newTrack);
    }

    public Track updateTrack(int trackId, TrackController.TrackRequest request) {

        Track existingTrack = trackRepository.findById(trackId)
                .orElseThrow(() -> new RuntimeException("Track not found with id: " + trackId));


        Album album = albumRepository.findById(request.albumId)
                .orElseThrow(() -> new RuntimeException("Album not found with id: " + request.albumId));

        existingTrack.setTitle(request.title);
        existingTrack.setDuration(request.duration);
        existingTrack.setFilePath(request.filePath);
        existingTrack.setAlbum(album);

        return trackRepository.save(existingTrack);
    }
    

    public void deleteTrack(int trackId) {

        if (!trackRepository.existsById(trackId)) {
            throw new RuntimeException("Track not found with id: " + trackId);
        }

        trackRepository.deleteById(trackId);
    }
}
