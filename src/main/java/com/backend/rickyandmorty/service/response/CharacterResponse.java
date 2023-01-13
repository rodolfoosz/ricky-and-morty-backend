package com.backend.rickyandmortyservice.response;

import com.backend.rickyandmortyresponse.PersonagemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class CharacterResponse {
    InfoResponse info;
    List<PersonagemResponse> results;

    public CharacterResponse(InfoResponse info, List<PersonagemResponse> results) {
        super();
        this.info = info;
        this.results = results;
    }
}
