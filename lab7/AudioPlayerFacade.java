import java.util.List;

public class AudioPlayerFacade {

    private final PlaylistService playlistService;
    private final LibraryService libraryService;
    private final AudioEngine audioEngine;

    public AudioPlayerFacade(PlaylistService playlistService,
                             LibraryService libraryService,
                             AudioEngine audioEngine) {
        this.playlistService = playlistService;
        this.libraryService = libraryService;
        this.audioEngine = audioEngine;
    }

    public Playlist createPlaylistAndAddTrack(String playlistName, Track track) {
        Playlist playlist = playlistService.createPlaylist(playlistName);
        playlistService.addTrackToPlaylist(playlist, track);
        return playlist;
    }

    public List<Track> searchTracks(String query) {
        return libraryService.search(query);
    }

    public void playTrack(Track track) {
        audioEngine.play(track);
    }

    public void addTrackToLibrary(Track track) {
        libraryService.addToLibrary(track);
    }
}
