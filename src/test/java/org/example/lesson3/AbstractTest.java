package org.example.lesson3;

import io.restassured.RestAssured;
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


    //есть файл my.properties, где хранятся переменные (apikey, url и т.д.), в одном месте - удобно менять значения
    //перед каждым тестом будет создаваться объект FileInputStream из файла my.properties.
    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/my.properties");
        //сюда будут загружаться данные из этого файла (хэшмэп)
        prop.load(configFile);

        //в переменные будут считываться  значение из файла
        apiKey =  prop.getProperty("apiKey");
        baseUrl= prop.getProperty("base_url");

    }

    //устанавливаем гет, без сета, чтобы не смогли поменять значение
    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

}

