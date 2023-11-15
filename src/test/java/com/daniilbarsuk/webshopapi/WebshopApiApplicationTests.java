package com.daniilbarsuk.webshopapi;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebshopApiApplicationTests {
	@LocalServerPort
	private Integer port;

	public void createItem(Map<String, Object> itemDetails){
		given().body(itemDetails)
			.when().contentType("application/json; charset=UTF-8").post("http://localhost:" + port +"/items")
			.then().assertThat().statusCode(HttpStatus.CREATED.value())
			.body("name", equalTo(itemDetails.get("name")))
			.body("price", equalTo(itemDetails.get("price")));

	}
	@Test
	@Order(1)
	public void shouldCreateItem1(){
		Map<String, Object> itemDetails = new HashMap<>();
		itemDetails.put("name", "fridge");
		itemDetails.put("price", 700);
		createItem(itemDetails);
	}
	@Test
	@Order(2)
	public void shouldCreateItem2(){
		Map<String, Object> itemDetails = new HashMap<>();
		itemDetails.put("name", "laptop");
		itemDetails.put("price", 2000);
		createItem(itemDetails);
	}
	@Test
	@Order(3)
	public void shouldCreateItem3(){
		Map<String, Object> itemDetails = new HashMap<>();
		itemDetails.put("name", "smartphone");
		itemDetails.put("price", 500);
		createItem(itemDetails);
	}
	@Test
	@Order(4)
	public void shouldGetItem(){
		given()
			.when().get("http://localhost:" + port +"/items/1")
			.then().assertThat().statusCode(HttpStatus.OK.value());
	}
	@Test
	@Order(5)
	public void shouldCreateBasket(){
		given()
			.when().post("http://localhost:" + port +"/baskets")
			.then().assertThat().statusCode(HttpStatus.CREATED.value());
	}
	@Test
	@Order(6)
	public void shouldAddItem1ToBasket(){
		given()
			.when().post("http://localhost:" + port +"/baskets/1/items/1")
			.then().assertThat().statusCode(HttpStatus.OK.value())
			.body("items", hasItem(hasKey("name")))
			.body("items", hasItem(hasKey("price")));
	}
	@Test
	@Order(6)
	public void shouldAddItem2ToBasket(){
		given()
			.when().post("http://localhost:" + port +"/baskets/1/items/2")
			.then().assertThat().statusCode(HttpStatus.OK.value())
			.body("items", hasItem(hasKey("name")))
			.body("items", hasItem(hasKey("price")));
	}
	@Test
	@Order(7)
	public void shouldGetBasket(){
		given()
			.when().get("http://localhost:" + port +"/baskets/1")
			.then().assertThat().statusCode(HttpStatus.OK.value())
			.body("items", hasSize(2))
			.body("items", hasItem(hasKey("name")))
			.body("items", hasItem(hasKey("price")));
	}
	@Test
	@Order(8)
	public void shouldDeleteItemFromBasket(){
		given()
			.when().delete("http://localhost:" + port +"/baskets/1/items/1")
			.then().assertThat().statusCode(HttpStatus.OK.value())
			.body("items", hasSize(1))
			.body("items", hasItem(hasKey("name")))
			.body("items", hasItem(hasKey("price")));
	}

	@Test
	@Order(9)
	public void shouldDeleteBasket(){
		given()
			.when().delete("http://localhost:" + port +"/baskets/1")
			.then().assertThat().statusCode(HttpStatus.OK.value());
	}
}
