public class PlaylistPlayer {

    private Playlist playlist;
    private int currentIndex = -1;
    private PlaybackStrategy strategy;

    public PlaylistPlayer(PlaybackStrategy strategy) {
        this.strategy = strategy;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        this.currentIndex = -1;
    }

    public void setStrategy(PlaybackStrategy strategy) {
        this.strategy = strategy;
    }

    public Track playNext() {
        List<Track> tracks = playlist.getTracks();
        currentIndex = strategy.getNextIndex(tracks, currentIndex);

        if (currentIndex == -1) {
            System.out.println("Кінець плейлиста.");
            return null;
        }

        Track track = tracks.get(currentIndex);
        System.out.println("Грає: " + track.getTitle());
        return track;
    }
}
