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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long experienceID;

    private String experience;

}