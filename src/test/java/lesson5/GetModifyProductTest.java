package lesson5;

import lesson6.db.dao.ProductsMapper;
import lesson6.db.model.Products;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class GetModifyProductTest extends  AbstractTest {

    @Test
    void getModifyProductPositiveTest() throws IOException {
        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        Products product = productsMapper.selectByPrimaryKey(4L);
        product.setTitle("updateProduct");
        product.setCategory_id(2L);
        productsMapper.updateByPrimaryKeySelective(product);
        Products productUpdate = productsMapper.selectByPrimaryKey(4L);
        session.commit();
        Assert.assertEquals(product.getTitle(), productUpdate.getTitle());
        Assert.assertEquals(product.getCategory_id(), productUpdate.getCategory_id());

    }

  @Test
    void getModifyProductNegativeTest() throws IOException {
      ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
      Products product = productsMapper.selectByPrimaryKey(1000L);
      session.commit();
      Assert.assertNull(product);
    }
}
