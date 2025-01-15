package com.renaud.TP3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Properties(String label, String housenumber, String street, String postcode, String city) {
}
