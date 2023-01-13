package com.backend.rickyandmortyservice;


import com.backend.rickyandmortyrequest.CharacterRequest;
import com.backend.rickyandmortyresponse.PersonagemResponse;
import com.backend.rickyandmortyservice.response.ApiCharacterEpisodesResponse;
import com.backend.rickyandmortyservice.response.CharacterResponse;
import com.backend.rickyandmortyservice.response.EpisodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class CharacterService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    private PersonagemResponse CharacterRequest;

    public ApiCharacterEpisodesResponse getPersonagem(CharacterRequest CharacterRequest){

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("https://rickandmortyapi.com/api/character");

        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", CharacterRequest.getName());
        uriComponentsBuilder.queryParams(params);

        ResponseEntity<ApiCharacterEpisodesResponse> response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.GET, entity, ApiCharacterEpisodesResponse.class);
        return response.getBody();

    }

}
