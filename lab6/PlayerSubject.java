public interface PlayerSubject {
    void addObserver(PlayerObserver observer);
    void removeObserver(PlayerObserver observer);
    void notifyObservers();
}
