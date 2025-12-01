public class PlaylistService {

    public Playlist createPlaylist(String name) {
        System.out.println("Створення плейлиста \"" + name + "\"");
        return new Playlist(name);
    }

    public void addTrackToPlaylist(Playlist playlist, Track track) {
        playlist.addTrack(track);
    }
}
