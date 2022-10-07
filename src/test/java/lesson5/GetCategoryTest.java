package lesson5;

import io.restassured.http.ContentType;
import lesson5.api.CategoryService;
import lesson5.dto.GetCategoryResponse;
import lesson5.dto.GetNotExistCategoryResponse;
import lesson5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetCategoryTest {

    static CategoryService categoryService;
    // Получаем экземпляр реализации интрефейса CategoryService.
    // Обращаемся к классу RetrofitUtils и вызываем метод getRetrofit() с настройками (URL,фабрика и т.д.)
    // Т.е мы имеем доступ к гет категории в категориисервис
    //этот код вывзываем HTTP метод гет
    @BeforeAll
    static void beforeAll() {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
    }

    @SneakyThrows
    @Test
            //Обращаемся к categoryService, вызываем метод getCategory, указываем входные параметры (здесь id) и execute.
            //В результате получаем объект категории Response, внутри которого в качестве body соедржится объект GetCategoryResponse.
            //метод getCategory вернул нам json, который был десериализован в объект.

    void getCategoryByIdPositiveTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(1).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        //При запросе существующего значения Category - статус-код 200

        assertThat(response.code(), equalTo(200));
        //Поле Title принимает значение запрашиваемой категории

        assertThat(response.body().getTitle(), equalTo("Food"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Food")));
        System.out.println(response.body());
    }

    //При запросе несуществующего значения Category - статус-код 404
    @Test
    void getCategoryByIdNegativeTest() throws IOException {
        Response<GetCategoryResponse> response = categoryService.getCategory(0).execute();
        assertThat(response.code(), equalTo(404));
    }
}



