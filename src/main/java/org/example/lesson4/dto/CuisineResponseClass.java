package org.example.lesson4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class CuisineResponseClass {

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("results")
        public List<Result> results = new ArrayList<Result>();
        @JsonProperty("offset")
        public Integer offset;
        @JsonProperty("number")
        public Integer number;
        @JsonProperty("totalResults")
        public Integer totalResults;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class Result {
            @JsonProperty("vegetarian")
            public Boolean vegetarian;
            @JsonProperty("vegan")
            public Boolean vegan;
            @JsonProperty("glutenFree")
            public Boolean glutenFree;
            @JsonProperty("dairyFree")
            public Boolean dairyFree;
            @JsonProperty("veryHealthy")
            private Boolean veryHealthy;
            @JsonProperty("cheap")
            private Boolean cheap;
            @JsonProperty("veryPopular")
            private Boolean veryPopular;
            @JsonProperty("sustainable")
            private Boolean sustainable;
            @JsonProperty("lowFodmap")
            private Boolean lowFodmap;
            @JsonProperty("weightWatcherSmartPoints")
            private Integer weightWatcherSmartPoints;
            @JsonProperty("gaps")
            private String gaps;
            @JsonProperty("preparationMinutes")
            private Integer preparationMinutes;
            @JsonProperty("cookingMinutes")
            private Integer cookingMinutes;
            @JsonProperty("aggregateLikes")
            private Integer aggregateLikes;
            @JsonProperty("healthScore")
            private Integer healthScore;
            @JsonProperty("creditsText")
            private String creditsText;
            @JsonProperty("license")
            private String license;
            @JsonProperty("sourceName")
            private String sourceName;
            @JsonProperty("pricePerServing")
            private Double pricePerServing;
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("title")
            private String title;
            @JsonProperty("author")
            private String author;

            @JsonProperty("readyInMinutes")
            private Integer readyInMinutes;
            @JsonProperty("servings")
            private Integer servings;
            @JsonProperty("sourceUrl")
            private String sourceUrl;
            @JsonProperty("image")
            private String image;
            @JsonProperty("imageType")
            private String imageType;
            @JsonProperty("nutrition")
            private Nutrition nutrition;
            @JsonProperty("summary")
            private String summary;
            @JsonProperty("cuisines")
            List<String> cuisines = new ArrayList<String>();
            @JsonProperty("dishTypes")
            private List<String> dishTypes = new ArrayList<String>();
            @JsonProperty("diets")
            private List<String> diets = new ArrayList<String>();
            @JsonProperty("occasions")
            private List<Object> occasions = new ArrayList<Object>();
            @JsonProperty("analyzedInstructions")
            private List<AnalyzedInstruction> analyzedInstructions = new ArrayList<AnalyzedInstruction>();
            @JsonProperty("spoonacularSourceUrl")
            private String spoonacularSourceUrl;
        }

            @Data
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class Nutrition {

                @JsonProperty("nutrients")
                private List<Nutrient> nutrients = new ArrayList<Nutrient>();
                @JsonProperty("properties")
                private List<Property> properties = new ArrayList<Property>();
                @JsonProperty("flavonoids")
                private List<Flavonoid> flavonoids = new ArrayList<Flavonoid>();
                @JsonProperty("ingredients")
                private List<Ingredient> ingredients = new ArrayList<Ingredient>();
                @JsonProperty("caloricBreakdown")
                private CaloricBreakdown caloricBreakdown;
                @JsonProperty("weightPerServing")
                private WeightPerServing weightPerServing;
        }

                @Data
                @JsonInclude(JsonInclude.Include.NON_NULL)
                public static class Nutrient {

                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("unit")
                    private String unit;
                    @JsonProperty("percentOfDailyNeeds")
                    private Double percentOfDailyNeeds;
                }


                @Data
                @JsonInclude(JsonInclude.Include.NON_NULL)
                public static class Property {

                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("unit")
                    private String unit;

                }

                @Data
                @JsonInclude(JsonInclude.Include.NON_NULL)
                public static class Flavonoid {

                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("unit")
                    private String unit;

                }

                @Data
                @JsonInclude(JsonInclude.Include.NON_NULL)
                public static class Ingredient {

                    @JsonProperty("id")
                    private Integer id;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("unit")
                    private String unit;
                    @JsonProperty("nutrients")
                    private List<Nutrient__1> nutrients = new ArrayList<Nutrient__1>();
                }
                    @Data
                    @JsonInclude(JsonInclude.Include.NON_NULL)
                    public static class Nutrient__1 {

                        @JsonProperty("name")
                        private String name;
                        @JsonProperty("amount")
                        private Double amount;
                        @JsonProperty("unit")
                        private String unit;
                        @JsonProperty("percentOfDailyNeeds")
                        private Double percentOfDailyNeeds;

                    }


                @Data
                @JsonInclude(JsonInclude.Include.NON_NULL)
                public static class CaloricBreakdown {

                    @JsonProperty("percentProtein")
                    private Double percentProtein;
                    @JsonProperty("percentFat")
                    private Double percentFat;
                    @JsonProperty("percentCarbs")
                    private Double percentCarbs;

                }

                @Data
                @JsonInclude(JsonInclude.Include.NON_NULL)
                public static class WeightPerServing {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("unit")
                    private String unit;

                }


            @Data
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class AnalyzedInstruction {
                @JsonProperty("name")
                private String name;
                @JsonProperty("steps")
                private List<Step> steps = new ArrayList<Step>();

            }
                @Data
                @JsonInclude(JsonInclude.Include.NON_NULL)
                public static class Step {

                    @JsonProperty("number")
                    private Integer number;
                    @JsonProperty("step")
                    private String step;
                    @JsonProperty("ingredients")
                    private List<Ingredient__1> ingredients = new ArrayList<Ingredient__1>();
                    @JsonProperty("equipment")
                    private List<Equipment> equipment = new ArrayList<Equipment>();
                    @JsonProperty("length")
                    private Length length;
                }
                    @Data
                    @JsonInclude(JsonInclude.Include.NON_NULL)
                    public static class Ingredient__1 {

                        @JsonProperty("id")
                        private Integer id;
                        @JsonProperty("name")
                        private String name;
                        @JsonProperty("localizedName")
                        private String localizedName;
                        @JsonProperty("image")
                        private String image;

                    }

                    @Data
                    @JsonInclude(JsonInclude.Include.NON_NULL)
                    public static class Equipment {

                        @JsonProperty("id")
                        private Integer id;
                        @JsonProperty("name")
                        private String name;
                        @JsonProperty("localizedName")
                        private String localizedName;
                        @JsonProperty("image")
                        private String image;

                    }

                    @Data
                    @JsonInclude(JsonInclude.Include.NON_NULL)
                    public static class Length {

                        @JsonProperty("number")
                        private Integer number;
                        @JsonProperty("unit")
                        private String unit;

                    }
                }




