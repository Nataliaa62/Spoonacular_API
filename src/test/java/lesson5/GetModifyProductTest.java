package lesson5;

import lesson5.dto.Product;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetModifyProductTest extends  AbstractTest {

    @Test
    void getModifyProductPositiveTest() throws IOException {

        Response<Product> response = productService.modifyProduct(new Product(1, "NoBread", 30, "Electronic"))
                .execute();

        assertThat(response.code(), equalTo(200));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("NoBread"));
        assertThat(response.body().getPrice(), equalTo(30));
        assertThat(response.body().getCategoryTitle(), equalTo("Electronic"));
        System.out.println(response.body());

    }

    @Test
    void getModifyProductNegativeTest() throws IOException {

        Response<Product> response = productService.modifyProduct(new Product(100, "NoBread", 30, "Electronic"))
                .execute();
        // При модификации товара несуществующим ID  статус-код -400
        assertThat(response.code(), equalTo(400));
        assertThat(response.body(), equalTo(null));


        Response<Product> response1 = productService.modifyProduct(new Product(1, "NoBread", 30, "УУУ"))
                .execute();
        // При модификации товара несуществующим ID  статус-код -500
        assertThat(response1.code(), equalTo(500));
        assertThat(response1.body(), equalTo(null));

    }
}
