/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.primeFaces.managedBean;


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
public class ManyContinentSelector implements Serializable{
    private List<String> selectedContinents;
    private String country;
    private Map<String, List<String>> continentToCountries;
    private List<String> countries;

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @PostConstruct
    public void init() {
        // Initialize continentToCountries map with countries for each continent
        // Populate the map with countries for each continent
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
    }

    public void onContinentsChange() {
        // Implement logic to update the list of countries based on the selected continents
        // In this example, we'll simply concatenate the countries of all selected continents
        List<String> selectedCountries = new ArrayList<>();
        for (String continent : selectedContinents) {
            List<String> countries = continentToCountries.get(continent);
            if (countries != null) {
                selectedCountries.addAll(countries);
            }
        }
        // Set the selected countries list
        System.out.println("Selected list: " + selectedCountries);
        setCountries(selectedCountries);
        
    }

    public List<String> getSelectedContinents() {
        return selectedContinents;
    }

    public void setSelectedContinents(List<String> selectedContinents) {
        this.selectedContinents = selectedContinents;
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

    // Getter and setter for continentToCountries map
}
