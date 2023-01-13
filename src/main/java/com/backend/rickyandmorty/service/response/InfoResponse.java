package com.backend.rickyandmortyservice.response;

import lombok.Data;

@Data
public class InfoResponse  {
    private Long count;
    private Long pages;
    private String next;
    private String prev;

}
