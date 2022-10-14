package lesson5;

import lesson6.db.dao.ProductsMapper;
import lesson6.db.model.Products;
import lesson6.db.model.ProductsExample;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;


public class GetProductsTest extends AbstractTest {

//получить список продутов не выше 500 руб.
    @Test
    void getProductsTest() throws IOException {

        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        ProductsExample example = new ProductsExample();
        //критерий значение стоимость продукта не более 500 руб.
        example.createCriteria().andPriceLessThan(500);

        List<Products> productsList = productsMapper.selectByExample(example);


        for (Products products : productsList)
        {
            //проверка - цена не более 500
            Assert.assertTrue(products.getPrice()<500);
            //вывести список
            System.out.println(products);
        }
        //посчитать количество
        System.out.println(productsMapper.countByExample(example));
    }

}
