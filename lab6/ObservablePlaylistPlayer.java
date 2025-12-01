import java.util.ArrayList;
import java.util.List;

public class ObservablePlaylistPlayer implements PlayerSubject {

    private final List<PlayerObserver> observers = new ArrayList<>();
    private Track currentTrack;
    private String state = "STOPPED"; // PLAYING, PAUSED, STOPPED etc.

    @Override
    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PlayerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PlayerObserver observer : observers) {
            observer.update(currentTrack, state);
        }
    }

    public void setCurrentTrack(Track track) {
        this.currentTrack = track;
        System.out.println("Обрано трек: " + track.getTitle());
        notifyObservers();
    }

    public void play() {
        if (currentTrack == null) {
            System.out.println("Немає обраного треку для відтворення.");
            return;
        }
        state = "PLAYING";
        System.out.println("Відтворення: " + currentTrack.getTitle());
        notifyObservers();
    }

    public void pause() {
        if (!"PLAYING".equals(state)) return;
        state = "PAUSED";
        System.out.println("Пауза");
        notifyObservers();
    }

    public void stop() {
        state = "STOPPED";
        System.out.println("Зупинка");
        notifyObservers();
    }
}
