package com.renaud.TP3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AdresseResponse(String type, List<Feature> features) {}
