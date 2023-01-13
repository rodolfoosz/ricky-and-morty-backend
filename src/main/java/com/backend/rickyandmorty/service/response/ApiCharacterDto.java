package com.backend.rickyandmortyservice.response;

import com.backend.rickyandmortyresponse.PersonagemResponse;
import lombok.Data;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ApiCharacterDto {

    private static final RestTemplate restTemplate = new RestTemplate();
    private Long id;
    private String name;
    private String status;
    private String image;
    private String url;
    private String created;
    private List<String> episode;

    public static PersonagemResponse fromApiDto(ApiCharacterDto apiDto) {
        PersonagemResponse personagem = new PersonagemResponse();
        personagem.setId(apiDto.getId());
        personagem.setName(apiDto.getName());
        personagem.setStatus(apiDto.getStatus());
        personagem.setImage(apiDto.getImage());
        personagem.setUrl(apiDto.getUrl());
        personagem.setCreated(apiDto.getCreated());
        personagem.setEpisode(apiDto.getEpisode().stream()
                .map(ep -> restTemplate.getForObject(URI.create(ep), EpisodeResponse.class)).collect(Collectors.toList()));
        return personagem;
    }


}
