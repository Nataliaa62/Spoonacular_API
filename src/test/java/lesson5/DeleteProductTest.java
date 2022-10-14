package lesson5;

import lesson6.db.dao.ProductsMapper;
import lesson6.db.model.Products;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class DeleteProductTest extends AbstractTest {

  @Test
  @SneakyThrows
    void tearDown() {

      ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
      productsMapper.deleteByPrimaryKey(0L);
      Products productDelete =productsMapper.selectByPrimaryKey(0L);
      session.commit();
      Assert.assertNull(productDelete);

  }
}