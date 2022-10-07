package lesson5.utils;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {
    //перехвачтичк, имплементирует intercept//метод глобально.
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        //на входе объект типа chain
        //получили объект запроса
        Request request = chain.request();

        long t1 = System.nanoTime();
//сохранили инфо о времени создания запроса
        System.out.println(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));
// выполинили запрос. нттр запрос. получили респонс
        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
// залогировали изапрос
        System.out.println(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        //возвращаем респонс это свой собственно- написанный перехватчик. есть и готовые механизмы HTTP3
        return response;
    }
}
