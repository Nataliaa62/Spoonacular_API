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
//тест дописать нам. надо:  в армках пред. урока 6 тестов, добавить ассерты на основании результат скл запросов.
// н-р, сделали потс запрос, сдеаоть скл. запрос  и проверить соответсетси, пут запрос. делит. тестовые классы создать
        public static void main( String[] args ) throws IOException {
          //закрыать объект сешн, это ресурс. можно и трай уив ресурс

           SqlSession session = null;
           //надо добавить иницаиализацию подключения к своему майбатис, доавтить в свои абтср классы, бефор алл.
            try {
                //путь до айла, так как в ресурсе находится, то и не указывать абсл. путь
                String resource = "mybatis-config.xml";
                //создается инпут стрим и читаем данные из файла
                InputStream inputStream = Resources.getResourceAsStream(resource);
                //испл. интрефейс склсешнфэктори, преедаем соотвю интупт стрим на вход
                SqlSessionFactory sqlSessionFactory = new
                        SqlSessionFactoryBuilder().build(inputStream);
                //получаем объект склсейшнфетори и открываем сессию, т.е. создаем скл сессию для доступа к базе данных , проихволит подключение
                session = sqlSessionFactory.openSession();
               //все вышле это подколчюене, м.н. написать метод гет и вызвать в етсах ???

/*
               //гет мээпер и передаем соств. класс. получаем оюъект categoriesMapper и с помощью енго произвоит дейстаия
                lesson6.db.dao.CategoriesMapper categoriesMapper = session.getMapper(lesson6.db.dao.CategoriesMapper.class);

               //1. сощдаем экз.объекта CategoriesExample, то есть создаем то самое усвлоие ве
                lesson6.db.model.CategoriesExample example = new lesson6.db.model.CategoriesExample();

                //и в это усвлоие доавбле в качестве индифик. д.б. экв. значения 1 (где айди равен 1)
                example.createCriteria().andIdEqualTo(1);

                //3. у categoriesMapper вывзываем метод selectByExample, передаем усвлоие и получаем объект лист
                List<lesson6.db.model.Categories> list = categoriesMapper.selectByExample(example);

                //туту же м. посчитать кол-во таких объекотов
                System.out.println(categoriesMapper.countByExample(example));*/


                ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
                Products products = new Products();
                //каким тооб разом его настариваем, м. ерез сетеры через конструкто или билдер. создаться в таблице тест
                products.setTitle("eee");
                products.setPrice(22);
                products.setCategory_id(1L);

                productsMapper.insert(products);
                session.commit();


                //что произошло: получиил лист, остоит из одного обхект категорис, ктр удоавл. усвлои. айди равне 1.
               // наш скл запрос выгядит6: селект*фрм ктегрис где айди равен 1.создали объект экзымл, доавбиди кртирей, и указали значения 1
                //и можем использ. ве в несколтких запросах.
                //будет возвращаться аррулист, рьзатся моно гет(0)
                //проверка лист >0 b >1 ? чтоооо?  если уникальность. надр првиерить



                //создавем обхект категрии
               /* lesson6.db.model.Categories categories = new lesson6.db.model.Categories();
                //каким тооб разом его настариваем, м. ерез сетеры через конструкто или билдер. создаться в таблице тест
                categories.setTitle("test");
                //и делаем инсет
                categoriesMapper.insert(categories);
                //после этого обя. вывзывается сешн коммит, п.с. что должы быть атомарные действия, т.е. неделемвые. м. б. бол. кол-во манипулцяи, но с точки зранеия логика это как то единое действие
                //если одно упадет , то и другие действия должны отменится. н-р, делаем селект, удалем и втсавляюем новый объект .это как одно действие, если б не было комита.
                //то мы бы сделали селект, потом удлии, потом инсерт падает с ошибкой, старые удалены  а ноаве не добавелен, это плохо. и коммит объееняет
                //в общую группу.
                //у гет запросов коммитов нет, потому что мы просто читаем . , а селект занменет комиит// а вот манипд. проиходят в режиме транзакций.
                //
                session.commit();


                //создаем оюъек т типа тест. созаем новй экщ. объекта, т.е. новое услвоие
                lesson6.db.model.CategoriesExample example2 = new lesson6.db.model.CategoriesExample();
                //в новое условие указ. поусвлоеи что тайтл лай (вхождение) способ искать строки , указываем занчение, исп. занк проента(не интресует спрва и слеова)
              //ищем все строки где есть словао тест
                example2.createCriteria().andTitleLike("%test%");
                //получаем лист2.  два обекта тест (в примере у максиа)
                List<lesson6.db.model.Categories> list2 = categoriesMapper.selectByExample(example2);
                //здесь берет ся значение 0 и даоее устанвл. значение 100
                lesson6.db.model.Categories categories2 = list2.get(0);
                categories2.setTitle("test100");

                //потом updateByPrimaryKey, передаем обеъект categories2 / в таблице значени 28 моенятеся н значение тест100. т.е был апдейт, передаеди объект кот. хотели обновить
                //и снова вызывл икомит
                categoriesMapper.updateByPrimaryKey(categories2);
                session.commit();
*/


                //тут удаление тест100
              /*  categoriesMapper.deleteByPrimaryKey(categories2.getId());
                session.commit();*/


                //и блок файнали
            } finally {
                session.close();
            }

        }
    }

//дз. восопль. методоми тобы написать ассерты, мы не тестируем бащу, а испо.  интер орм для написания ассертами.
// т.е. мы испль. базу длня написани яассертов. мы тестир рестапи, чтобы проверить как отработали доп. исп. доступ в бд.
//орм не явл. цель. тестир. а инструменарий (удалить, добавить, рнвостить и т.д).
//создаи пост и с помощтю автоол удалить. 

