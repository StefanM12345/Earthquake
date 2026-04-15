package com.stefan.earthquake;

import com.stefan.earthquake.model.Earthquake;
import com.stefan.earthquake.service.EarthquakeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EarthquakeServiceTest {

    @Autowired
    private EarthquakeService service;

    @Test
    void fetchAndSaveEarthquakes_shouldNotCrash() {

        List<Earthquake> result = service.fetchAndSaveEarthquakes();

        assertNotNull(result);
    }

    @Test
    void getAll_shouldReturnList() {

        List<Earthquake> list = service.getAll();

        assertNotNull(list);
    }

    @Test
    void getAfterTime_shouldFilterResults() {

        long now = System.currentTimeMillis();

        List<Earthquake> list = service.getAfterTime(now);

        assertNotNull(list);
    }
}