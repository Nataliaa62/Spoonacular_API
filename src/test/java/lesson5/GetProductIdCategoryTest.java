package lesson5;

import lesson5.dto.Product;
import lesson6.db.dao.ProductsMapper;
import lesson6.db.model.Products;
import lesson6.db.model.ProductsExample;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetProductIdCategoryTest extends AbstractTest {

    //Позитивный тест: получить продукт с существующим ID
    @Test
    void getProductIdCategoryTest() throws IOException {
        //В getMapper передаем состветсвующий класс, получаем объект productsMapper (интерфейс), и  производим с ним действия
        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        //Создаем экземпляр объекта ProductsExample (большой список условий)
        ProductsExample example = new ProductsExample();

        //выбираем нужное нам условие, заполняем значением
        example.createCriteria().andIdEqualTo(3L);
        //3. у productsMapper вывзываем метод selectByExample, передаем усвлоие и получаем объект лист
        List<Products> list = productsMapper.selectByExample(example);

        Assert.assertNotNull(example);
        assertThat(list.size(), equalTo(1));
        System.out.println(example);
        System.out.println(productsMapper.countByExample(example));

    }


    //Негативный тест: получить продукт с несуществующим ID
    @Test
    void getProductNotExistIdCategoryTest() throws IOException {
        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        ProductsExample example = new ProductsExample();

        example.createCriteria().andIdEqualTo(1000L);
        List<Products> list = productsMapper.selectByExample(example);

        Assert.assertTrue(list.size() == 0);
        System.out.println(productsMapper.countByExample(example));
    }
}
