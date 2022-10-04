package org.example.lesson3;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class TestBack extends AbstractTest{


    @Test
    void ResponseRecipesComplexSearch(){

        //проверка значения кухни - французская
        //метод состоит из  given()  .when() .then()
      JsonPath response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "french")
                .queryParam("addRecipeNutrition", "true")
                .when()
                .get(getBaseUrl()+ "/recipes/complexSearch")
                .then()
                .extract()
                .jsonPath();
        assertThat(response.get(" \"results\"[0].\"id\""), equalTo(633754));
        assertThat(response.get(" \"results\"[0].\"cuisines\"[1]"), equalTo("French"));


        //проверка, что запрос несуществующей кухни выдал пустой результат
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "russian")
                .queryParam("addRecipeNutrition", "true")
                .when()
                .get(getBaseUrl()+ "/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .body("totalResults", equalTo(0) )
                .time(lessThan(2000L));

        //тело ответа содержит кетогенную диету
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("diet", "ketogenic")
                .queryParam("addRecipeNutrition", "true")
                .when()
                .get(getBaseUrl()+ "/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .contentType(ContentType.JSON)
                //.body(" \"results\"[0].\"diet\"[5]", equalTo("ketogenic"))
                .body(containsString("ketogenic"))
                .time(lessThan(2000L));

        //проверка значений поля "Автор"
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("author", "coffeebean")
                .queryParam("addRecipeNutrition", "true")
                .when()
                .get(getBaseUrl()+ "/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .contentType(ContentType.JSON)
                .body(" \"results\"[0].\"author\"", equalTo("coffeebean"))
                .time(lessThan(2000L));


        //проверка полей ответа
        given()
                .queryParam("apiKey", getApiKey())
                .when()
                .get(getBaseUrl()+ "/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .contentType(ContentType.JSON)
                .body(" \"results\"[0].\"id\"", equalTo(716426))
                .body(" \"results\"[0].\"title\"", equalTo("Cauliflower, Brown Rice, and Vegetable Fried Rice"))
                .body(" \"results\"[0].\"image\"", equalTo("https://spoonacular.com/recipeImages/716426-312x231.jpg"))
                .body(" \"results\"[0].\"imageType\"", equalTo("jpg"))
                .time(lessThan(2000L));
    }


    @Test
    void PostrRecipesCuisine() {
        //проверка, что кухня Mediterranean определяется верно
        String cuisine = given()
                .queryParam("title", "pizza")
                .queryParam("apiKey", getApiKey())
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200)
                .body("\"cuisine\"", equalTo("Mediterranean"))
                .extract()
                .jsonPath()
                .get("\"cuisine\"")
                .toString();
        System.out.println(cuisine);


        //проверка, что кухня Mexican определяется верно
        given()
                .queryParam("title", "tacos")
                .queryParam("apiKey", getApiKey())
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200)
                .body("\"cuisine\"", equalTo("Mexican"))
                .extract()
                .jsonPath()
                .get("\"cuisine\"")
                .toString();


        //проверка, что кухня Indian определяется верно
        given()
                .queryParam("title", "Tandoori Chicken")
                .queryParam("apiKey", getApiKey())
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200)
                .body("\"cuisine\"", equalTo("Indian"))
                .extract()
                .jsonPath()
                .get("\"cuisine\"")
                .toString();

// Проверка, что ответ содержит поля, указанные в документации
         given()
                 .queryParam("title", "pasta")
                 .queryParam("apiKey", getApiKey())
                 .when()
                 .post("https://api.spoonacular.com/recipes/cuisine")
                 .then()
                 .statusCode(200)
                 .body(containsString("\"Mediterranean\",\"European\",\"Italian\""))
                 .body("\"confidence\"", equalTo(0.0F))
                 .body("\"cuisine\"", equalTo("Mediterranean"))
                 .extract()
                 .jsonPath()
                 .toString();

        // Проверяем, что тело ответа не пустое
        given()
                .queryParam("title", "pasta")
                .queryParam("apiKey", getApiKey())
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200)
                .body(notNullValue())
                .extract()
                .jsonPath()
                .toString();
    }

    @Test
    void addShoppingListTest() {
    //создаем  пользователя
        JsonPath userConnect = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("apiKey", getApiKey())
                .body("{\n"

                        + " \"username\": \"nataliaa64no@yandex.ru\",\n"
                        + " \"firstName\": \"nataliaa64\",\n"
                        + " \"lastName\": \"no\",\n"
                        + " \"email\": \"nataliaa64no@yandex.ru\"\n"

                        + "}")
                .when()
                .post("https://api.spoonacular.com/users/connect")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();
        assertThat(userConnect, notNullValue());

        final   String  hash = userConnect.getString(" \"hash\"");
        final   String  username = userConnect.getString(" \"username\"");

        System.out.println("Создан полльзователь: " + username);
        System.out.println("Hash: " + hash);

        //добавляем в лист продукт (используем сгенерируемый хэш)
        JsonPath shoppingList = given()
                .queryParam("hash", hash)
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                     + " \"item\": \"1 package baking powder\",\n"
                     + " \"aisle\": \"Baking\"\n"
                     + "}"
                )
                .when()
                .post("https://api.spoonacular.com/mealplanner/" + username + "/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();
        assertThat(shoppingList, notNullValue());
        assertThat(shoppingList.get("name"), equalTo("baking powder"));

        final   String  item = shoppingList.getString(" \"name\"");
        final   int  amount = (int) shoppingList.getDouble(" \"measures\".\"original\".\"amount\"");
        final   String  unit = shoppingList.getString(" \"measures\".\"original\".\"unit\"");
        final   String  id = shoppingList.getString(" \"id\"");

        System.out.println("Shopping-list содержит: " + item + " в количестве " + amount + " " + unit);


        given()
                .queryParam("hash", hash)
                .queryParam("apiKey", getApiKey())
                .delete("https://api.spoonacular.com/mealplanner/" + username + "/shopping-list/items/" + id)
                .then()
                .statusCode(200);

    }
}
