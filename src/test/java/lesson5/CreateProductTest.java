package lesson5;

import lesson6.db.dao.ProductsMapper;
import lesson6.db.model.Products;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CreateProductTest extends AbstractTest {
    long id;

    @Test
    void createProductInFoodCategoryPositiveTest() throws IOException {

        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        Products products = new Products();
        //заполняем продукт значениями
        products.setTitle("Soda");
        products.setPrice(61);
        products.setCategory_id(1L);
        //и делаем insert (запись созданного продукта в БД)
        productsMapper.insert(products);
        // session.commit();
        //выбрать из БД с id продукта, который создали и сравнить
        Products productCreate = productsMapper.selectByPrimaryKey(products.getId());

        Assert.assertNotNull(productCreate);
        Assert.assertEquals(products.getId(), productCreate.getId());
        Assert.assertEquals(products.getPrice(), productCreate.getPrice());
        Assert.assertEquals(products.getCategory_id(), productCreate.getCategory_id());
        Assert.assertEquals(products.getTitle(), productCreate.getTitle());
        id = productCreate.getId();
    }


    @Test
    void createProductInFoodCategoryNegativeTest(){

        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        Products products = new Products();
        products.setPrice(61);
        products.setCategory_id(1L);
        productsMapper.insert(products);

        session.commit();
        Products productCreate = productsMapper.selectByPrimaryKey(products.getId());
        Assert.assertNotNull(productCreate);
        Assert.assertEquals(products.getId(), productCreate.getId());
        Assert.assertEquals(productCreate.getTitle(), null);
        id = productCreate.getId();
    }

  @AfterEach
    @Test
    void deleteProductTest() {
        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        productsMapper.deleteByPrimaryKey(id);
        Products productDelete = productsMapper.selectByPrimaryKey(id);
        session.commit();
        Assert.assertNull(productDelete);
    }
}