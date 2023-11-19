package com.daniilbarsuk.webshopapi;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	private static Map<String, String> credentials;
	@Autowired
	private PasswordEncoder encoder;
	@Test
	@Order(1)
	public void shouldSignup(){
		credentials = new HashMap<>();
		credentials.put("username", "daniil");
		credentials.put("password", encoder.encode("111111"));
		given().body(credentials)
			.when().contentType("application/json; charset=UTF-8").post("http://localhost:" + port + "/auth/signup")
			.then().assertThat().statusCode(HttpStatus.CREATED.value())
			.body("username", equalTo(credentials.get("username")));
	}
	public void createItem(Map<String, Object> itemDetails){
		given().auth().basic(credentials.get("username"), credentials.get("password")).body(itemDetails)
			.when().contentType("application/json; charset=UTF-8").post("http://localhost:" + port +"/items")
			.then().assertThat().statusCode(HttpStatus.CREATED.value())
			.body("name", equalTo(itemDetails.get("name")))
			.body("price", equalTo(itemDetails.get("price")));

	}
	@Test
	@Order(2)
	public void shouldCreateItem1(){
		Map<String, Object> itemDetails = new HashMap<>();
		itemDetails.put("name", "fridge");
		itemDetails.put("price", 700);
		createItem(itemDetails);
	}
	@Test
	@Order(3)
	public void shouldCreateItem2(){
		Map<String, Object> itemDetails = new HashMap<>();
		itemDetails.put("name", "laptop");
		itemDetails.put("price", 2000);
		createItem(itemDetails);
	}
	@Test
	@Order(4)
	public void shouldCreateItem3(){
		Map<String, Object> itemDetails = new HashMap<>();
		itemDetails.put("name", "smartphone");
		itemDetails.put("price", 500);
		createItem(itemDetails);
	}
	@Test
	@Order(5)
	public void shouldGetItem(){
		given().auth().basic(credentials.get("username"), credentials.get("password"))
			.when().get("http://localhost:" + port +"/items/1")
			.then().assertThat().statusCode(HttpStatus.OK.value());
	}

	@Test
	@Order(7)
	public void shouldAddItem1ToBasket(){
		given().auth().basic(credentials.get("username"), credentials.get("password"))
			.when().post("http://localhost:" + port +"/basket/items/1")
			.then().assertThat().statusCode(HttpStatus.OK.value())
			.body("items", hasItem(hasKey("name")))
			.body("items", hasItem(hasKey("price")));
	}
	@Test
	@Order(8)
	public void shouldAddItem2ToBasket(){
		given().auth().basic(credentials.get("username"), credentials.get("password"))
			.when().post("http://localhost:" + port +"/basket/items/2")
			.then().assertThat().statusCode(HttpStatus.OK.value())
			.body("items", hasItem(hasKey("name")))
			.body("items", hasItem(hasKey("price")));
	}
	@Test
	@Order(9)
	public void shouldGetBasket(){
		given().auth().basic(credentials.get("username"), credentials.get("password"))
			.when().get("http://localhost:" + port +"/basket")
			.then().assertThat().statusCode(HttpStatus.OK.value())
			.body("items", hasSize(2))
			.body("items", hasItem(hasKey("name")))
			.body("items", hasItem(hasKey("price")));
	}
	@Test
	@Order(10)
	public void shouldDeleteItemFromBasket(){
		given().auth().basic(credentials.get("username"), credentials.get("password"))
			.when().delete("http://localhost:" + port +"/basket/items/1")
			.then().assertThat().statusCode(HttpStatus.OK.value())
			.body("items", hasSize(1))
			.body("items", hasItem(hasKey("name")))
			.body("items", hasItem(hasKey("price")));
	}
}
