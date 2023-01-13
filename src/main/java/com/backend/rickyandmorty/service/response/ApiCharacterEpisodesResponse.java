package com.backend.rickyandmortyservice.response;

import lombok.Data;

import java.util.List;

@Data
public class ApiCharacterEpisodesResponse {
    private InfoResponse info;
    private List<ApiCharacterDto> results;
}
