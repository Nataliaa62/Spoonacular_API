package lesson5;

import com.github.javafaker.Faker;
import lesson5.api.ProductService;
import lesson5.dto.Product;

import lesson5.utils.RetrofitUtils;
import lesson6.db.dao.ProductsMapper;
import lesson6.db.model.Products;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.InputStream;

public class AbstractTest {
    SqlSession session = null;
    Product product = null;
    Faker faker = new Faker();
    long id;
    static ProductService productService;

   @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }
    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
    }

    @BeforeEach
        //надо добавить иницаиализацию подключения к своему майбатис, доавтить в свои абтср классы, бефор алл.
    void session() throws IOException {
        //путь до айла, так как в ресурсе находится, то и не указывать абсл. путь
        String resource = "mybatis-config.xml";
        //создается инпут стрим и читаем данные из файла
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //испл. интрефейс склсешнфэктори, преедаем соотвю интупт стрим на вход
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        //получаем объект склсейшнфетори и открываем сессию, т.е. создаем скл сессию для доступа к базе данных , проихволит подключение
        session = sqlSessionFactory.openSession();

    }
}
