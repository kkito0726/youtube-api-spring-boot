package com.ken.youtubeapi.services;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.ken.youtubeapi.models.Video;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
  private static final JsonFactory JSON_FACTORY = new JacksonFactory();
  private static final HttpRequestInitializer HTTP_REQUEST_INITIALIZER = new HttpRequestInitializer() {
    public void initialize(HttpRequest request) throws IOException {}
  };

  private static final long NUMBER_OF_VIDEOS_RETURNED = 50;
  private static YouTube youtube;

  Dotenv dotenv = Dotenv.load();
  private final String API_KEY = dotenv.get("API_KEY");

  public List<Video> searchByQuery(String query) {
    try {
      youtube =
        new YouTube.Builder(
          HTTP_TRANSPORT,
          JSON_FACTORY,
          HTTP_REQUEST_INITIALIZER
        )
          .setApplicationName("youtube-search-api")
          .build();

      YouTube.Search.List search = youtube.search().list("id,snippet");

      search.setKey(API_KEY);
      search.setQ(query);
      search.setType("video");
      search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

      SearchListResponse searchResponse = search.execute();
      List<SearchResult> searchResults = searchResponse.getItems();

      if (searchResults != null) {
        List<Video> videos = map2Videos(searchResults);
        return videos;
      }
    } catch (GoogleJsonResponseException e) {
      System.err.println(
        "There was a service error: " +
        e.getDetails().getCode() +
        " : " +
        e.getDetails().getMessage()
      );
    } catch (IOException e) {
      System.err.println(
        "There was an IO error: " + e.getCause() + " : " + e.getMessage()
      );
    }

    return new ArrayList<Video>(Arrays.asList(new Video()));
  }

  private List<Video> map2Videos(List<SearchResult> searchResults) {
    List<Video> videos = searchResults
      .stream()
      .map(video ->
        new Video(
          video.getSnippet().getChannelId(),
          video.getSnippet().getTitle(),
          video.getId().getVideoId(),
          video.getSnippet().getThumbnails().getHigh().getUrl(),
          video.getSnippet().getPublishedAt(),
          video.getSnippet().getDescription()
        )
      )
      .toList();
    return videos;
  }
}
