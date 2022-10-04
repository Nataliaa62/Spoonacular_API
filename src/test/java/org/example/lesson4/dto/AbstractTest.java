package org.example.lesson4.dto;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {

    //объект Properties
    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;
    //2 переменнеы спеки запроса и ответа, отноястяс к проверкам,
    protected static ResponseSpecification responseSpecification;
    protected static RequestSpecification requestSpecification;

    //есть файл my.properties, где хранятся переменные (apikey, url и т.д.), в одном месте - удобно менять значения
    //перед каждым тестом будет создаваться объект FileInputStream из файла my.properties.
    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/my.properties");
        //сюда будут загружаться данные из этого файла (хэшмэп)
        prop.load(configFile);

        //в переменные будут считываться  значение из файла
        apiKey = prop.getProperty("apiKey");
        baseUrl = prop.getProperty("base_url");
        //спек отева, озмо. вынести общую логику в отдельное хранилице, применятеся для всех тестов.  созжлается через билдер,
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
              //  .expectResponseTime(Matchers.lessThan(5000L))
                .expectHeader("Connection", "keep-alive")

                //.expectHeader("Access-Control-Allow-Credentials", "true")
                .build();

        //добавляем что являтяс общим для тестов. например, апикей
        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("addRecipeNutrition", "true")
                .addQueryParam("number", 1)

                // .setContentType(ContentType.JSON)
               .log(LogDetail.ALL)
                .build();

        //глобальые перменнеы (рестасурд). будут для всех! н/р, апикей.
       RestAssured.responseSpecification = responseSpecification;
       RestAssured.requestSpecification = requestSpecification;
    }
    //это спек для исп в конкретном тесте
    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }

    public ResponseSpecification getResponseSpecification(){
        return responseSpecification;
    }

    //устанавливаем гет, без сета, чтобы не смогли поменять значение
    public static String getApiKey() {
        return apiKey;
    }


    public static String getBaseUrl() {
        return baseUrl;
    }

}

