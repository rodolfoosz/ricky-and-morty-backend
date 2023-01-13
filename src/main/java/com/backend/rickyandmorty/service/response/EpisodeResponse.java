package com.backend.rickyandmortyservice.response;

import lombok.Data;

@Data
public class EpisodeResponse {
    private Long id;
    private String name;
    private String air_date;
    private String episode;
    private String url;
    private String created;
}
