import java.util.List;

public class ClientUI {

    public static void main(String[] args) {
        PlaylistService playlistService = new PlaylistService();
        LibraryService libraryService = new LibraryService();
        AudioEngine audioEngine = new AudioEngine();

        AudioPlayerFacade facade =
                new AudioPlayerFacade(playlistService, libraryService, audioEngine);

        // тестові дані
        Track track1 = new Track(1, "Song A", "Artist 1", "C:/Music/song_a.mp3");
        Track track2 = new Track(2, "Love Song", "Artist 2", "C:/Music/love_song.mp3");

        facade.addTrackToLibrary(track1);
        facade.addTrackToLibrary(track2);

        List<Track> found = facade.searchTracks("song");

        if (!found.isEmpty()) {
            Playlist playlist = facade.createPlaylistAndAddTrack("Мій плейлист", found.get(0));

            facade.playTrack(found.get(0));

            System.out.println("У плейлисті \"" + playlist.getName() +
                    "\" треків: " + playlist.getTracks().size());
        }
    }
}
