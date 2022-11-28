package com.airquality.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Airqualitymonitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int dustParicle;
    private int carbonDioxide;
    private int carbonMonoxide;
    private int nitrogenDioxide;
    private int sculptureDioxide;

    private int year;
    private int month;
    private int day;

    public Airqualitymonitor() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDustParicle() {
        return dustParicle;
    }

    public void setDustParicle(int dustParicle) {
        this.dustParicle = dustParicle;
    }

    public int getCarbonDioxide() {
        return carbonDioxide;
    }

    public void setCarbonDioxide(int carbonDioxide) {
        this.carbonDioxide = carbonDioxide;
    }

    public int getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(int carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public int getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public void setNitrogenDioxide(int nitrogenDioxide) {
        this.nitrogenDioxide = nitrogenDioxide;
    }

    public int getSculptureDioxide() {
        return sculptureDioxide;
    }

    public void setSculptureDioxide(int sculptureDioxide) {
        this.sculptureDioxide = sculptureDioxide;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

}
