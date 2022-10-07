package lesson5;

import com.github.javafaker.Faker;
import lesson5.api.ProductService;
import lesson5.dto.Product;
import lesson5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CreateProductTest extends AbstractTest{

    @Test
    void createProductInFoodCategoryPositiveTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id =  response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

        //При успешном создании продукта статус-код - 201
        assertThat(response.code(), equalTo(201));

        //Тело ответа содержит ненулевыe значения: id, title, price, categoryTitle
        assertThat(response.body().getId(), notNullValue());
        assertThat(response.body().getTitle(), notNullValue());
        assertThat(response.body().getPrice(), notNullValue());
        assertThat(response.body().getCategoryTitle(), notNullValue());

        Response<ResponseBody> response1 = productService.deleteProduct(id).execute();
        assertThat(response1.isSuccessful(), CoreMatchers.is(true));

        //При создании товара с незаполненным значением title -  статус код 201
        Response<Product> response2 = productService.createProduct(new Product(20, "Food"))
                .execute();
        assertThat(response2.isSuccessful(), CoreMatchers.is(true));
        assertThat(response2.code(), equalTo(201));

        //При создании товара с незаполненным значением title  поле Title равно null
        assertThat(response2.body().getTitle(), nullValue());
        System.out.println(response1.body());

    }

        @Test
        void createProductInFoodCategoryNegativeTest() throws IOException {
            //При создании товара с незаполненным значением categoryTitle статус код 500
            Response<Product> response2 = productService.createProduct(new Product("Soda", 20))
                    .execute();
            assertThat(response2.code(), equalTo(500));


            //При создании товара с несуществующим значением categoryTitle статус код 500
            Response<Product> response3 = productService.createProduct(new Product("Soda", 2, "EEE"))
                    .execute();
            assertThat(response3.code(), equalTo(500));
            System.out.println(response3.body());


           // При создании товара c незаполненными полями статус 500
            Response<Product> response4 = productService.createProduct(new Product())
                .execute();
            assertThat(response4.code(), equalTo(500));
            System.out.println(response4.body());
    }
}
