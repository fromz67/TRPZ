public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("My playlist");
        playlist.addTrack(new Track("Song A", 180, "path1"));
        playlist.addTrack(new Track("Song B", 200, "path2"));
        playlist.addTrack(new Track("Song C", 240, "path3"));

        PlaylistPlayer player = new PlaylistPlayer(new NormalPlaybackStrategy());
        player.setPlaylist(playlist);

        System.out.println("=== Normal ===");
        while (player.playNext() != null) {}

        System.out.println("=== Repeat ===");
        player.setStrategy(new RepeatAllPlaybackStrategy());
        for (int i = 0; i < 5; i++) player.playNext();

        System.out.println("=== Shuffle ===");
        player.setStrategy(new ShufflePlaybackStrategy());
        for (int i = 0; i < 5; i++) player.playNext();
    }
}
