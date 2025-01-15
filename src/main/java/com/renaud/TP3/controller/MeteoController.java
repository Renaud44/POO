package com.renaud.TP3.controller;

import com.renaud.TP3.model.AdresseResponse;
import com.renaud.TP3.model.MeteoResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MeteoController {

    private final String meteoApiKey = "aaad4e81143e282492fc3348cb7096dc6812e359bb55684b3e64571b792d86a4";

    @PostMapping("/meteo")
    public String afficherMeteo(@RequestParam("address") String address, Model model) {
        RestTemplate restTemplate = new RestTemplate();

        // Étape 1: Appeler l'API Adresse pour récupérer les coordonnées GPS
        String adresseUrl = "https://api-adresse.data.gouv.fr/search/?q=" + address.replace(" ", "+");
        AdresseResponse adresseResponse = restTemplate.getForEntity(adresseUrl, AdresseResponse.class).getBody();

        if (adresseResponse == null || adresseResponse.features().isEmpty()) {
            model.addAttribute("error", "Adresse introuvable");
            return "meteo";
        }

        // Récupérer les coordonnées GPS (latitude et longitude)
        double latitude = adresseResponse.features().get(0).geometry().coordinates().get(1);
        double longitude = adresseResponse.features().get(0).geometry().coordinates().get(0);

        // Étape 2: Appeler l'API MeteoConcept pour obtenir les informations météorologiques
        String meteoUrl = "https://api.meteo-concept.com/api/forecast/daily?token=" + meteoApiKey +
                "&latlng=" + latitude + "," + longitude;
        MeteoResponse meteoResponse = restTemplate.getForEntity(meteoUrl, MeteoResponse.class).getBody();

        if (meteoResponse == null) {
            model.addAttribute("error", "Impossible de récupérer les données météo.");
            return "meteo";
        }

        // Étape 3: Ajouter les données nécessaires au modèle
        model.addAttribute("address", address);
        model.addAttribute("features", adresseResponse.features());
        model.addAttribute("meteo", meteoResponse);

        return "meteo";
    }
}

