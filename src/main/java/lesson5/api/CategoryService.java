package lesson5.api;

import lesson5.dto.GetCategoryResponse;
import lesson5.dto.GetNotExistCategoryResponse;
import retrofit2.Call;
import retrofit2.http.*;


public interface CategoryService {
    //Указываем способ взаимодействия (м.б. Get, Post, Delete и т.д.)
    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory(@Path("id") int id);


    @GET("categories/{id}")
    Call<GetNotExistCategoryResponse> getNotExistCategory(@Path("id") int id);
}

//Call <GetCategoryResponse> - возвращается дженерик обьекта Call, внутри будет объект (класс из dto), кототрый мы будем обрабатывать как json
// getCategory - имя метода, (@Path("id")int id) - переменные будут подставляться в запрос. М.б. Path, Query и т.д.

