package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience {
    public long getExperienceID() {
        return experienceID;
    }

    public void setExperienceID(long experienceID) {
        this.experienceID = experienceID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long experienceID;

    public String getExperienceString() {
        return experienceString;
    }

    public void setExperienceString(String experienceString) {
        this.experienceString = experienceString;
    }

    private String experienceString;

}