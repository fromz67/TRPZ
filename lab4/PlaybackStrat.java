public class NormalPlaybackStrategy implements PlaybackStrategy {
    @Override
    public int getNextIndex(List<Track> tracks, int currentIndex) {
        if (currentIndex + 1 < tracks.size()) return currentIndex + 1;
        return -1;
    }
}
