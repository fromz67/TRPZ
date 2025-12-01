public class Track {
    private final long id;
    private final String title;
    private final String artist;
    private final String filePath;

    public Track(long id, String title, String artist, String filePath) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }
}
