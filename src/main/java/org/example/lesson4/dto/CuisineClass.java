package org.example.lesson4.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

   //скрыто генерирует с помощью аннотации @Data (toStrinq, equals, getter, setter, конструтор)
@Data
public class CuisineClass {
    //включать при серилизации и дисерилиазции только ненулевые значения
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //порядок атрибутов (если важно расположение).необязальная аннотация
    @JsonPropertyOrder({
            "cuisine",
            "cuisines",
            "confidence"
    })
    //указывается наименование, если нужно его поменять (ошибки или непонятное значение). необязальная аннотация
        @JsonProperty("cuisine")
        private String cuisine;
        @JsonProperty("cuisines")
        private List<String> cuisines = new ArrayList<String>();
        @JsonProperty("confidence")
        private Double confidence;

    }

//*если часть атрибуов не нужны при сериализации, но нужны для бизнес-логики можно использовать @JsonIgnore