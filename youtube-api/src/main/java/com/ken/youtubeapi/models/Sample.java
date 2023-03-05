package com.ken.youtubeapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sample {

  private int userId;
  private int id;
  private String title;
  private String body;
}
