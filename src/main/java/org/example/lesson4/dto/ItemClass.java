package org.example.lesson4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemClass {
    private String item;
    private String aisle;


   public ItemClass(String item, String aisle) {
        this.item = item;
        this.aisle = aisle;
    }

    public ItemClass() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }
}
