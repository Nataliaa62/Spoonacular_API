package org.example.lesson4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShoppingListClass {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("measures")
    private Measures measures;
    @JsonProperty("usages")
    private List<Object> usages = null;
    @JsonProperty("usageRecipeIds")
    private List<Object> usageRecipeIds = null;
    @JsonProperty("pantryItem")
    private Boolean pantryItem;
    @JsonProperty("aisle")
    private String aisle;
    @JsonProperty("cost")
    private Double cost;
    @JsonProperty("ingredientId")
    private Integer ingredientId;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class Measures {

        @JsonProperty("original")
        private Original original;
        @JsonProperty("metric")
        private Metric metric;
        @JsonProperty("us")
        private Us us;


        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        private class Metric {

            @JsonProperty("amount")
            private Double amount;
            @JsonProperty("unit")
            private String unit;

        }


        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        private class Original {

            @JsonProperty("amount")
            private Double amount;
            @JsonProperty("unit")
            private String unit;

        }


        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        private class Us {

            @JsonProperty("amount")
            private Double amount;
            @JsonProperty("unit")
            private String unit;

        }
    }

}