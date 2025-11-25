public interface PlaybackStrategy {
    int getNextIndex(List<Track> tracks, int currentIndex);
}
