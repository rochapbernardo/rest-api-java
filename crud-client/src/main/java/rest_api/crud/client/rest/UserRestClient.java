package rest_api.crud.client.rest;

import org.springframework.stereotype.Component;
import rest_api.crud.client.model.User;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@Component
public class UserRestClient {
    private static final String BASE_URL = "http://localhost:8081/api/users";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<User> getAllUsers() throws Exception{
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(res.body(), new TypeReference<List<User>>() {});
    }

    public User getUser(long id) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(res.body(), User.class);
    }

    public User createUser(User u) throws Exception {
        String json = mapper.writeValueAsString(u);

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(res.body(), User.class);
    }

    public User updateUser(long id, User u) throws Exception {
        String json = mapper.writeValueAsString(u);

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(res.body(), User.class);
    }

    public void deleteUser(long id) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .DELETE()
                .build();

        client.send(req, HttpResponse.BodyHandlers.ofString());
    }
}
