import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpClientService {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String API_BASE_URL = "http://localhost:8080/api/playlists";

    public Playlist createPlaylist(String name) throws Exception {

        String jsonBody = "{\"name\":\"" + name + "\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            return objectMapper.readValue(response.body(), Playlist.class);
        } else {
            throw new RuntimeException("Failed to create playlist");
        }
    }

    public List<Playlist> getAllPlaylists() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL))
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return objectMapper.readValue(response.body(), 
            objectMapper.getTypeFactory().constructCollectionType(List.class, Playlist.class));
    }
}
