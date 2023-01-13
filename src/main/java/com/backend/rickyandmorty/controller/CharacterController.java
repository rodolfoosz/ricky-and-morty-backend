package com.backend.rickyandmortycontroller;

import com.backend.rickyandmortyrequest.CharacterRequest;
import com.backend.rickyandmortyresponse.PersonagemResponse;
import com.backend.rickyandmortyservice.CharacterService;
import com.backend.rickyandmortyservice.response.ApiCharacterDto;
import com.backend.rickyandmortyservice.response.ApiCharacterEpisodesResponse;
import com.backend.rickyandmortyservice.response.CharacterResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;
    @GetMapping("personagens")
    public ResponseEntity<CharacterResponse> getPersonagem(@ModelAttribute (value = "Personagem") CharacterRequest CharacterRequest) {

        ApiCharacterEpisodesResponse response = characterService.getPersonagem(CharacterRequest);


        List<PersonagemResponse> characters = response.getResults().stream().map(ApiCharacterDto::fromApiDto)
                .collect(Collectors.toList());

        //return new CharacterResponse(response.getInfo(), CharacterResponse);
        return new ResponseEntity<>(new CharacterResponse(response.getInfo(), characters), HttpStatus.OK);
    }
}