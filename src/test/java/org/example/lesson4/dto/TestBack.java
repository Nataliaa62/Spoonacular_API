package org.example.lesson4.dto;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestBack extends AbstractTest {
    @Test
    void getRecipesCuisineMediterranean() {
        //проверка, что кухня Mediterranean определяется верно
        CuisineResponseClass cuisine = given().spec(requestSpecification)
                .formParam("cuisine", "french")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineResponseClass.class);

        assertThat(cuisine.getTotalResults(), equalTo(70));
        assertThat(cuisine.getResults().get(0).getId(), equalTo(633754));
        assertThat(cuisine.getResults().get(0).cuisines.get(0), containsString("Mediterranean"));

    }
    @Test
    void getRecipesCuisineFrench() {

        //проверка значения кухни - французская
        //метод состоит из  given()  .when() .then()

        CuisineResponseClass cuisine = given().spec(requestSpecification)
                .formParam("cuisine", "french")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineResponseClass.class);
        assertThat(cuisine.getResults().get(0).cuisines.get(1), containsString("French"));
    }


    //проверка, что запрос несуществующей кухни выдал пустой результат
    @Test
    void getRecipesCuisineEmpty() {
        CuisineResponseClass cuisine = given().spec(requestSpecification)
                .formParam("cuisine", "russian")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineResponseClass.class);
        assertThat(cuisine.getTotalResults(), equalTo(0));
    }


    //тело ответа содержит кетогенную диету
    @Test
    void getRecipesCuisineKetogenicDiet() {

        CuisineResponseClass cuisine = given().spec(requestSpecification)
                .queryParam("diet", "ketogenic")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineResponseClass.class);
        assertThat(cuisine.getResults().get(0).getDiets().get(5), containsString("ketogenic"));

           }

    //проверка значений поля "Автор"
    @Test
    void getRecipesCuisineAuthor() {
        CuisineResponseClass cuisine = given().spec(requestSpecification)
                .queryParam("author", "coffeebean")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineResponseClass.class);
        assertThat(cuisine.getResults().get(0).getAuthor(), containsString("coffeebean"));
    }


    //проверка полей ответа
    @Test
    void getRecipesCuisineFields() {
        CuisineResponseClass cuisine = given().spec(requestSpecification)
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineResponseClass.class);
        assertThat(cuisine.getResults().get(0).getId(), equalTo(716426));
        assertThat(cuisine.getResults().get(0).getImage(), containsString("https://spoonacular.com/recipeImages/716426-312x231.jpg"));
        assertThat(cuisine.getResults().get(0).getImageType(), containsString("jpg"));
        assertThat(cuisine.getResults().get(0).getTitle(), containsString("Cauliflower, Brown Rice, and Vegetable Fried Rice"));
    }

    //проверка, что кухня Mexican определяется верно
    @Test
    void postRecipesCuisineMexican() {
        CuisineClass cuisine = given().spec(requestSpecification)
                .formParam("title", "tacos")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineClass.class);
        assertThat(cuisine.getCuisine(), containsString("Mexican"));
    }

    //проверка, что кухня Mediterranean определяется верно
    @Test
    void postRecipesCuisineMediterranean() {
        CuisineClass cuisine = given().spec(requestSpecification)
                .formParam("title", "pizza")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineClass.class);
        assertThat(cuisine.getCuisine(), containsString("Mediterranean"));}

    //проверка, что кухня Indian определяется верно
    @Test
    void postRecipesCuisineMIndian() {
        CuisineClass cuisine = given().spec(requestSpecification)
                .queryParam("title", "Tandoori Chicken")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineClass.class);
        assertThat(cuisine.getCuisine(), containsString("Indian"));}

    // Проверка, что ответ содержит поля, указанные в документации
    @Test
    void postRecipesCuisineMMediterranean() {
        CuisineClass cuisine = given().spec(requestSpecification)
                .queryParam("title", "pasta")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineClass.class);
        assertThat(cuisine.getCuisines(), notNullValue());
        assertThat(cuisine.getConfidence(), equalTo(0.0));
        assertThat(cuisine.getCuisine(), equalTo("Mediterranean"));
    }


    // Проверяем, что тело ответа не пустое
    @Test
    void postRecipesCuisineNotNull() {
        CuisineClass cuisine = given().spec(requestSpecification)
                .queryParam("title", "pasta")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineClass.class);
        assertThat(cuisine, notNullValue());
    }


    @Test
    void addShoppingListTest() {
        //создаем  пользователя
        ResultAuthorizationClass userConnect = given().spec(requestSpecification)
                .body(new AuthorizationClass("nataliaa64no@yandex.ru", "nataliaa64", "no", "nataliaa64no@yandex.ru"))
                .when()
                .post("https://api.spoonacular.com/users/connect")
                .then()
                .extract()
                .response()
                .as(ResultAuthorizationClass.class);



     //добавляем в лист продукт (используем сгенерируемый хэш)
     ShoppingListClass shoppingList = given(requestSpecification)
                .queryParam("hash", userConnect.getHash())
                .body(new ItemClass("1 package baking powder", "Baking"))
                .when()
                .post("https://api.spoonacular.com/mealplanner/" + userConnect.getUsername() + "/shopping-list/items")
                .then()
                .extract()
                .response()
                .as(ShoppingListClass.class);

        given(requestSpecification)
                .queryParam("hash", userConnect.getHash())
                .delete("https://api.spoonacular.com/mealplanner/" + userConnect.getUsername() + "/shopping-list/items/" + shoppingList.getId())
                .then();
    }
}
