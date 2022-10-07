package lesson5;

import lesson5.dto.Product;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductIdCategoryTest extends AbstractTest {

    //Позитивный тест: получить продукт с существующим ID
    @Test
    void getProductIdCategoryTest() throws IOException {
        Response<Product> response = productService.getProductById(4)
                .execute();

        //При запросе товара с существущим ID статус-код -200
        assertThat(response.code(), equalTo(200));

        //Поля ответа (id, title, price, categoryTitle) заполнены соотвествующими значениями
        assertThat(response.body().getId(), equalTo(4));
        assertThat(response.body().getTitle(), equalTo("Samsung Watch X1000"));
        assertThat(response.body().getPrice(), equalTo(20000));
        assertThat(response.body().getCategoryTitle(), equalTo("Electronic"));
        System.out.println(response.body());
    }


    //Негативный тест: получить продукт с несуществующим ID
    @Test
    void getProductNotExistIdCategoryTest() throws IOException {
        Response<Product> response = productService.getProductById(0)
                .execute();

        //При запросе товара с несуществущим ID статус-код -404
        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));
    }
}
