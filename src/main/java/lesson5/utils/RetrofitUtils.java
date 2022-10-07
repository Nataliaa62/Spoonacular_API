package lesson5.utils;


import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
//утилитарный класс (все методы статические). не пишем статик у каждого класса
@UtilityClass
public class RetrofitUtils {
    //создается объект Properties, читается из файла my.properties (блок урл, где хранится баз урл)
    Properties prop = new Properties();
    private static InputStream configFile;

    static {
        try {
            configFile = new FileInputStream("src/main/resources/my.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // мы не знаем какие экспешены могут быть вызваны.  сники скрывает, это не очень хорошо
    @SneakyThrows
    public String getBaseUrl() {
        prop.load(configFile);
        return prop.getProperty("url");
    }

    //здесь определны два перехватчика
    //логин стандартный перехвачтичк (от НТТР3)
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    //тот который мы написали
    LoggingInterceptor logging2 = new LoggingInterceptor();
    //доступ к самому НТТР3 клиенту
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    // Retrofit  статический метод. Обращение как к стат. методу вернет объект Retrofit.
    //билдер: BaseUrl, добавлем фабрику (определяет в качестве сериал/десиреализации будет джексон).
    //он понадобится для взаимодействи с объектами Retrofit,  его настроиили.
    // это способ логирования. В RestAssured PrettyPeek и другие, а тут вариативности больше за счет класса перехватчика,
    //логируем то что нам нужно.

/*    public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }*/

    public Retrofit getRetrofit(){
        //опредеяем уровень логирования, указываем что конкрто мы х. залогировать. можно бади, хедер и т.д.
        logging.setLevel(BODY);
        //настраиваем нттх клиента. он б. исп. перехватчик.
        httpClient.addInterceptor(logging2);
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

}