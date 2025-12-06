public class Track extends MusicComponent {
    private final String title;
    private final String artist;

    public Track(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("▶ Відтворення треку: " + title + " — " + artist);
    }
}
