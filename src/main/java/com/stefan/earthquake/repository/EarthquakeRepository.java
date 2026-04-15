package com.stefan.earthquake.repository;

import com.stefan.earthquake.model.Earthquake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarthquakeRepository extends JpaRepository<Earthquake, String> {
}
