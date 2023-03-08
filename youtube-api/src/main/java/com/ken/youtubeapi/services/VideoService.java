package com.ken.youtubeapi.services;

import org.springframework.stereotype.Service;

@Service
public interface VideoService {
  public String searchByQuery(String query);
}
