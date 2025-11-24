public class RepeatAllPlaybackStrategy implements PlaybackStrategy {
    @Override
    public int getNextIndex(List<Track> tracks, int currentIndex) {
        return (currentIndex + 1) % tracks.size();
    }
}
