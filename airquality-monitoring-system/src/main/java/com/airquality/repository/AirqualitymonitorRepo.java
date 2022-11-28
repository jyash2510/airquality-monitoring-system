package com.airquality.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airquality.Model.Airqualitymonitor;

public interface AirqualitymonitorRepo extends JpaRepository<Airqualitymonitor, Integer> {

}
