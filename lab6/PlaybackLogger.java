public class PlaybackLogger implements PlayerObserver {

    @Override
    public void update(Track currentTrack, String state) {
        String trackTitle = currentTrack != null ? currentTrack.getTitle() : "немає треку";
        System.out.println("[Logger] Подія: state=" + state + ", track=" + trackTitle);
    }
}
