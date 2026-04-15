package com.stefan.earthquake.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Earthquake     {

    @Id
    private String id;

    private double magnitude;

    private String place;

    private String title;

    private long time;
    @Column(name = "mag_type")
    private String magType;
    private Double longitude;
    private Double latitude;



}


