package lesson6;

import lesson6.db.dao.ProductsMapper;
import lesson6.db.model.Products;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExampleMain {

        public static void main( String[] args ) throws IOException {


           SqlSession session = null;
            try {
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory sqlSessionFactory = new
                        SqlSessionFactoryBuilder().build(inputStream);
                session = sqlSessionFactory.openSession();



                ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
                Products products = new Products();
                products.setTitle("eee");
                products.setPrice(22);
                products.setCategory_id(1L);

                productsMapper.insert(products);
                session.commit();

            } finally {
                session.close();
            }

        }
    }


