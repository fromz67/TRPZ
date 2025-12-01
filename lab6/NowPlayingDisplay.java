public class NowPlayingDisplay implements PlayerObserver {

    @Override
    public void update(Track currentTrack, String state) {
        String trackTitle = currentTrack != null ? currentTrack.getTitle() : "немає треку";
        System.out.println("[NowPlayingDisplay] Стан: " + state +
                ", трек: " + trackTitle);
    }
}
