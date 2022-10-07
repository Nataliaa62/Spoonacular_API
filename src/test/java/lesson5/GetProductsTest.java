package lesson5;

import lesson5.dto.Product;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductsTest extends AbstractTest {


    // Получить список продуктов
    @Test
    void getProductsTest() throws IOException {
        Response<Product[]> response = productService.getProducts().execute();

        //При запросе списка товаров  статус-код - 200
        assertThat(response.code(), equalTo(200));

        // Поля ответа (id, title, price, categoryTitle) заполнены соотвествующими значениями
        assertThat(response.body()[3].getTitle(), containsString("Samsung Watch X1000"));

        Arrays.asList(response.body()).stream().forEach(s -> System.out.println(s));
    };

}
