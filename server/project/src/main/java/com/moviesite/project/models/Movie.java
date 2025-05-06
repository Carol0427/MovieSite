package com.moviesite.project.models;

import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    // @JsonProperty("ogTitle")
    private String originalTitle;

    // @JsonProperty("desc")
    private String description;

    // @JsonProperty("primImage")
    private String primaryImage;

    private String[] interests;

    // @Override
    // public String toString(){
    //     return "Person: first name = " + fName + ", last name = " + lName + ", age = " + age;
    // }
    public Movie(){
        
    }
    public Movie(String id, String originalTitle, String description, String primaryImage, String[] interests){
        // super();
        this.id = id;
        this.originalTitle = originalTitle;
        this.description = description;
        this.primaryImage = primaryImage;
        this.interests = interests;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }
    public String getOriginalTitle(){
        return this.originalTitle;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setPrimaryImage(String primaryImage){
        this.primaryImage = primaryImage;
    }
    public String getPrimaryImage(){
        return this.primaryImage;
    }
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public String[] getInterests() {
        return this.interests;
    }
}

