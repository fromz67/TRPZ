import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainFormController {

    @FXML
    private ListView<String> playlistListView; 

    @FXML
    private TextField newPlaylistNameField; 

    private ObservableList<String> observablePlaylists = FXCollections.observableArrayList();
    
    private HttpClientService httpClientService = new HttpClientService();

    @FXML
    public void initialize() {
        playlistListView.setItems(observablePlaylists);
        loadPlaylists();
    }

    private void loadPlaylists() {
        try {
            observablePlaylists.clear();
            httpClientService.getAllPlaylists().forEach(playlist -> {
                observablePlaylists.add(playlist.getName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCreatePlaylistButton() {
        String name = newPlaylistNameField.getText();
        if (name == null || name.trim().isEmpty()) {
            return;
        }

        try {
            Playlist newPlaylist = httpClientService.createPlaylist(name);
            
            observablePlaylists.add(newPlaylist.getName());
            
            newPlaylistNameField.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
