public class ShufflePlaybackStrategy implements PlaybackStrategy {
    private final Random random = new Random();

    @Override
    public int getNextIndex(List<Track> tracks, int currentIndex) {
        return random.nextInt(tracks.size());
    }
}
