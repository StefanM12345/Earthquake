package com.stefan.earthquake.service;

import com.stefan.earthquake.model.Earthquake;
import com.stefan.earthquake.repository.EarthquakeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class EarthquakeService {
    private final EarthquakeRepository repository;

    public EarthquakeService(EarthquakeRepository repository){
        this.repository = repository;
    }
    public List<Earthquake> fetchAndSaveEarthquakes(){
        try {
            String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url,String.class);
            if(response == null || response.isBlank()){
                System.out.println("USGS returnet empty response");
                return new ArrayList<>();
            }
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            if(root == null || !root.has("features")){
                System.out.println("Invalid USGS response structure");
                return new ArrayList<>();
            }

            JsonNode features = root.get("features");

            if(features == null || !features.isArray()){
                System.out.print("Features missing or not array");
                return new ArrayList<>();
            }

            List<Earthquake> list = new ArrayList<>();

            for(JsonNode feature : features){
                JsonNode properties = feature.get("properties");
                JsonNode geometry = feature.get("geometry");
                JsonNode coords = geometry.get("coordinates");

                if (!properties.hasNonNull("mag") || !properties.hasNonNull("time")) {
                    continue;
                }

                double mag = properties.get("mag").asDouble();
                long time = properties.get("time").asLong();

                double lon = coords.get(0).asDouble();
                double lat = coords.get(1).asDouble();

                if (mag > 2.0){
                    String id = feature.get("id").asText();
                    String place = properties.get("place").asText();
                    String title = properties.get("title").asText();
                    String magType = properties.get("magType").asText();

                    Earthquake eq = new Earthquake(id,mag,place,title,time,magType,lon,lat);
                    list.add(eq);
                }
            }

            repository.deleteAll();
            repository.saveAll(list);
            return list;

        }catch (Exception e){
            throw new RuntimeException("Failed to fetch earthquakes", e);
        }

    }
    public List<Earthquake> getAll(){
        return  repository.findAll();
    }
    public void deleteById(String id){
        repository.deleteById(id);
    }
    public List<Earthquake> getAfterTime(long time){
        return repository.findAll()
                .stream()
                .filter(eq->eq.getTime()>time)
                .toList();
    }
}
