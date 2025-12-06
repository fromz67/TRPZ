public class ClientUI {
    public static void main(String[] args) {

        Track t1 = new Track("Song A", "Artist 1");
        Track t2 = new Track("Song B", "Artist 2");
        Track t3 = new Track("Love Story", "Artist 3");

        PlaylistComposite playlist1 = new PlaylistComposite("Мій плейлист");
        playlist1.add(t1);
        playlist1.add(t2);

        PlaylistComposite playlist2 = new PlaylistComposite("Романтичні");
        playlist2.add(t3);

        // вкладений плейлист
        playlist1.add(playlist2);

        playlist1.play();
    }
}
