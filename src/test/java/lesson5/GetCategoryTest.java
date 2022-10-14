package lesson5;

import lesson6.db.dao.CategoriesMapper;
import lesson6.db.model.Categories;
import lesson6.db.model.CategoriesExample;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;


public class GetCategoryTest extends AbstractTest {
@Test
    void getCategoryByIdPositiveTest() {
        CategoriesMapper categoryMapper = session.getMapper(CategoriesMapper.class);
        CategoriesExample example = new CategoriesExample();
        //получить все категории по порядку
         example.getOrderByClause();

        List<Categories> categoriesList = categoryMapper.selectByExample(example);
        Assert.assertFalse(categoriesList.isEmpty());
        for (Categories categories : categoriesList) {
          System.out.println(categories);
        }
        //посчитать количество
        System.out.println(categoryMapper.countByExample(example));
    }

}



