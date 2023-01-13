package com.backend.rickyandmortyresponse;

import com.backend.rickyandmortyservice.response.EpisodeResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class PersonagemResponse {
    private Long id;
    private String name;
    private String status;

    private String image;
    private String url;
    private String created;
    private List<EpisodeResponse> episode;
}
