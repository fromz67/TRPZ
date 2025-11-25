public class AddTrackToPlaylistCommand implements Command {

    private final Playlist playlist;
    private final Track track;

    public AddTrackToPlaylistCommand(Playlist playlist, Track track) {
        this.playlist = playlist;
        this.track = track;
    }

    @Override
    public void execute() {
        System.out.println("Команда: додати трек \"" + track.getTitle() +
                "\" до плейлиста");
        playlist.addTrack(track);
    }
}
