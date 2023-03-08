package com.ken.youtubeapi.services;

import com.ken.youtubeapi.models.Video;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface VideoService {
  public List<Video> searchByQuery(String query);
}
