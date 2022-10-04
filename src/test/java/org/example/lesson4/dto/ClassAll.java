package org.example.lesson4;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


@Data

public class ClassAll {

    @JsonIgnore
    @JsonInclude(JsonInclude.Include.NON_NULL)

    @Generated("jsonschema2pojo")

    @JsonProperty("results")
    public List<Results> results = new ArrayList<Results>();
    @JsonProperty("offset")
    public Integer offset;
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("totalResults")
    public Integer totalResults;

    @Data
    public static  class Results {
      //  @JsonIgnore
       // @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("nutrition")
        public List<Object> nutrition = new ArrayList<Object>();

        @JsonProperty("vegetarian")
        public Boolean vegetarian;
        @JsonProperty("vegan")
        public Boolean vegan;
        @JsonProperty("glutenFree")
        public Boolean glutenFree;
        @JsonProperty("dairyFree")
        public Boolean dairyFree;
        @JsonProperty("veryHealthy")
        public Boolean veryHealthy;
        @JsonProperty("cheap")
        public Boolean cheap;
        @JsonProperty("veryPopular")
        public Boolean veryPopular;
        @JsonProperty("sustainable")
        public Boolean sustainable;
        @JsonProperty("lowFodmap")
        public Boolean lowFodmap;
        @JsonProperty("weightWatcherSmartPoints")
        public Integer weightWatcherSmartPoints;
        @JsonProperty("gaps")
        public String gaps;
        @JsonProperty("preparationMinutes")
        public Integer preparationMinutes;
        @JsonProperty("cookingMinutes")
        public Integer cookingMinutes;
        @JsonProperty("aggregateLikes")
        public Integer aggregateLikes;
        @JsonProperty("healthScore")
        public Integer healthScore;
        @JsonProperty("creditsText")
        public String creditsText;
        @JsonProperty("license")
        public String license;
        @JsonProperty("sourceName")
        public String sourceName;
        @JsonProperty("pricePerServing")
        public Double pricePerServing;
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("title")
        public String title;
        @JsonProperty("readyInMinutes")
        public Integer readyInMinutes;
        @JsonProperty("servings")
        public Integer servings;
        @JsonProperty("sourceUrl")
        public String sourceUrl;
        @JsonProperty("image")
        public String image;
        @JsonProperty("imageType")
        public String imageType;
        @JsonProperty("summary")
        public String summary;
        @JsonProperty("cuisines")
        public List<String> cuisines = new ArrayList<String>();
        @JsonProperty("dishTypes")
        public List<String> dishTypes = new ArrayList<String>();
        @JsonProperty("diets")
        public List<String> diets = new ArrayList<String>();
        @JsonProperty("occasions")
        public List<Object> occasions = new ArrayList<Object>();
        @JsonProperty("spoonacularSourceUrl")
        public String spoonacularSourceUrl;

        public Results(List<Object> nutrition, Boolean vegetarian, Boolean vegan, Boolean glutenFree, Boolean dairyFree, Boolean veryHealthy, Boolean cheap, Boolean veryPopular, Boolean sustainable, Boolean lowFodmap, Integer weightWatcherSmartPoints, String gaps, Integer preparationMinutes, Integer cookingMinutes, Integer aggregateLikes, Integer healthScore, String creditsText, String license, String sourceName, Double pricePerServing, Integer id, String title, Integer readyInMinutes, Integer servings, String sourceUrl, String image, String imageType, String summary, List<String> cuisines, List<String> dishTypes, List<String> diets, List<Object> occasions, String spoonacularSourceUrl) {
            this.nutrition = nutrition;
            this.vegetarian = vegetarian;
            this.vegan = vegan;
            this.glutenFree = glutenFree;
            this.dairyFree = dairyFree;
            this.veryHealthy = veryHealthy;
            this.cheap = cheap;
            this.veryPopular = veryPopular;
            this.sustainable = sustainable;
            this.lowFodmap = lowFodmap;
            this.weightWatcherSmartPoints = weightWatcherSmartPoints;
            this.gaps = gaps;
            this.preparationMinutes = preparationMinutes;
            this.cookingMinutes = cookingMinutes;
            this.aggregateLikes = aggregateLikes;
            this.healthScore = healthScore;
            this.creditsText = creditsText;
            this.license = license;
            this.sourceName = sourceName;
            this.pricePerServing = pricePerServing;
            this.id = id;
            this.title = title;
            this.readyInMinutes = readyInMinutes;
            this.servings = servings;
            this.sourceUrl = sourceUrl;
            this.image = image;
            this.imageType = imageType;
            this.summary = summary;
            this.cuisines = cuisines;
            this.dishTypes = dishTypes;
            this.diets = diets;
            this.occasions = occasions;
            this.spoonacularSourceUrl = spoonacularSourceUrl;
        }
    }
}