package com.stefan.earthquake.controller;

import com.stefan.earthquake.model.Earthquake;
import com.stefan.earthquake.service.EarthquakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/earthquakes")
@CrossOrigin
public class EarthquakeController {
    private final EarthquakeService service;
    public EarthquakeController(EarthquakeService service){
        this.service = service;
    }
    @GetMapping("/fetch")
    public List<Earthquake>fetchData(){
        return service.fetchAndSaveEarthquakes();

    }
    @GetMapping
    public List<Earthquake> getAll(){
        return service.getAll();
    }

    @GetMapping("/after")
    public List<Earthquake>getAfterTime(@RequestParam long time){
        return service.getAfterTime(time);
    }
    @DeleteMapping("/{id}")
    public void deleteEarthquake(@PathVariable String id){
        service.deleteById(id);
    }

}
