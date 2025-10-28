import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LibraryManagerFormController {

    @FXML
    private TableView<Track> tracksTableView;
    @FXML
    private TableColumn<Track, String> titleColumn;
    @FXML
    private TableColumn<Track, Integer> durationColumn;
    
    @FXML
    private TextField titleField;
    @FXML
    private TextField durationField;
    @FXML
    private TextField filePathField;
    @FXML
    private ComboBox<Album> albumComboBox;

    private HttpClientService httpClientService = new HttpClientService();
    private ObservableList<Track> tracksList = FXCollections.observableArrayList();
    private ObservableList<Album> albumsList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTitle()));
        durationColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getDuration()));
        
        tracksTableView.setItems(tracksList);
        
        loadAllTracks();
        loadAllAlbums();
    }

    private void loadAllTracks() {
        try {
            tracksList.setAll(httpClientService.getAllTracks());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllAlbums() {
        try {
            albumsList.setAll(httpClientService.getAllAlbums());
            albumComboBox.setItems(albumsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSaveTrack() {
        try {
            TrackController.TrackRequest newTrackRequest = new TrackController.TrackRequest();
            newTrackRequest.title = titleField.getText();
            newTrackRequest.duration = Integer.parseInt(durationField.getText());
            newTrackRequest.filePath = filePathField.getText();
            newTrackRequest.albumId = albumComboBox.getValue().getId();

            Track savedTrack = httpClientService.createTrack(newTrackRequest);

            tracksList.add(savedTrack);
            clearFields();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        titleField.clear();
        durationField.clear();
        filePathField.clear();
        albumComboBox.getSelectionModel().clearSelection();
    }
}
