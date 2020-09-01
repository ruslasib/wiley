package ru.ruslasib.study.wiley.restapitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImageGetMethodTest {

  @BeforeClass
  public void init() {
    RestAssured.baseURI = "https://httpbin.org";
  }

  @Test
  public void testDelayMethod() {
    RequestSpecification request = RestAssured.given();
    Response response = request.get("/image/png");
    assertThat(response.statusCode(), equalTo(200));
    assertThat(response.body().toString(), equalTo(200));
    System.out.println(response.body().toString());
  }
}
