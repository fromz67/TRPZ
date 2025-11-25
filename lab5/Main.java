public class Main {
    public static void main(String[] args) {
        AudioEngine engine = new AudioEngine();
        Playlist playlist = new Playlist("Улюблені треки");

        Track track1 = new Track("Song A", "C:/Music/song_a.mp3");
        Track track2 = new Track("Song B", "C:/Music/song_b.mp3");

        PlayerController controller = new PlayerController();

        controller.executeCommand(new AddTrackToPlaylistCommand(playlist, track1));
        controller.executeCommand(new AddTrackToPlaylistCommand(playlist, track2));

        controller.executeCommand(new PlayTrackCommand(engine, track1));

        controller.executeCommand(new PauseCommand(engine));
    }
}
