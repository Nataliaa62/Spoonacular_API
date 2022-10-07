package lesson5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

import java.io.IOException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
//создание пустого объекта,
@With
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("categoryTitle")
    private String categoryTitle;

    public Product(Integer price, String categoryTitle) {
        this.price = price;
        this.categoryTitle = categoryTitle;
    }


    public Product(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

 public Product(String title, Integer price, String categoryTitle) {

        this.title = title;
        this.price = price;
        this.categoryTitle = categoryTitle;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", categoryTitle='" + categoryTitle + '\'' +
                '}';
    }
}
