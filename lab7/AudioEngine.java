public class AudioEngine {

    public void play(Track track) {
        System.out.println("Відтворення треку: " + track.getTitle() +
                " (файл: " + track.getFilePath() + ")");
    }
}
