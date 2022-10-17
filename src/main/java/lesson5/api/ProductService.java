package lesson5.api;


import lesson5.dto.Product;
import lombok.Data;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
//блок апи.
//описать ту часть апи взаим., исп. интерфейсы (на котролер и продукт серси). тут реализуем те методы которые будем тетсировать.
//будем тестить все шесть сервисов.
//
public interface ProductService {


    // ниже пот тексту: возвращаемое значение м. б. продукт, но и ResponseBody (ResponseBody это войд, не всегда в ходе тестов необходимо анализировать
    // ответ и его параметры, и создавать класс джейосон). То что вернется в ответе неважно.
    @POST("products")
    Call<Product> createProduct(@Body Product createProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);

    @PUT("products")
    Call<Product> modifyProduct(@Body Product modifyProductRequest);

    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") int id);

    @GET("products")
    Call<Product[]> getProducts();

}
