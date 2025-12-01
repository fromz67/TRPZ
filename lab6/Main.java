// приклад використання
public class Main {
    public static void main(String[] args) {
        ObservablePlaylistPlayer player = new ObservablePlaylistPlayer();

        PlayerObserver display = new NowPlayingDisplay();
        PlayerObserver logger = new PlaybackLogger();

        player.addObserver(display);
        player.addObserver(logger);

        Track track1 = new Track("Song A", "C:/Music/song_a.mp3");
        Track track2 = new Track("Song B", "C:/Music/song_b.mp3");

        player.setCurrentTrack(track1);
        player.play();

        player.pause();

        player.setCurrentTrack(track2);
        player.play();

        player.stop();
    }
}
