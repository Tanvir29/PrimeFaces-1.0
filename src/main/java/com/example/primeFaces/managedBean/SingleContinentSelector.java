/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.primeFaces.managedBean;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class SingleContinentSelector implements Serializable{
    private String continent;
    private String country;
    private Map<String, List<String>> continentToCountries;

    @PostConstruct
    public void init() {
        continentToCountries = new HashMap<>();
        
        // Adding countries for each continent
        List<String> asiaCountries = new ArrayList<>();
        asiaCountries.add("China");
        asiaCountries.add("India");
        asiaCountries.add("Japan");
        continentToCountries.put("Asia", asiaCountries);

        List<String> africaCountries = new ArrayList<>();
        africaCountries.add("Nigeria");
        africaCountries.add("Ethiopia");
        africaCountries.add("Egypt");
        continentToCountries.put("Africa", africaCountries);

        List<String> europeCountries = new ArrayList<>();
        europeCountries.add("Russia");
        europeCountries.add("Germany");
        europeCountries.add("France");
        continentToCountries.put("Europe", europeCountries);

        List<String> northAmericaCountries = new ArrayList<>();
        northAmericaCountries.add("USA");
        northAmericaCountries.add("Canada");
        northAmericaCountries.add("Mexico");
        continentToCountries.put("North America", northAmericaCountries);

        // Add more continents and countries as needed
    }

    public void onContinentChange() {
        // Implement logic to update the list of countries based on the selected continent
        // In this example, since countries are already populated for each continent, no additional action is required.
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getContinents() {
        return new ArrayList<>(continentToCountries.keySet());
    }

    public List<String> getCountries() {
        return continentToCountries.get(continent);
    }
}

