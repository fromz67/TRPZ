public class PlayTrackCommand implements Command {

    private final AudioEngine engine;
    private final Track track;

    public PlayTrackCommand(AudioEngine engine, Track track) {
        this.engine = engine;
        this.track = track;
    }

    @Override
    public void execute() {
        System.out.println("Команда: відтворити трек \"" + track.getTitle() + "\"");
        engine.play(track.getFilePath());
    }
}
