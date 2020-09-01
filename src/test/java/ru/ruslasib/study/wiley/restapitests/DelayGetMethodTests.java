package ru.ruslasib.study.wiley.restapitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DelayGetMethodTests {

  @BeforeClass
  public void init() {
    RestAssured.baseURI = "https://httpbin.org";
  }

  @Test
  public void testDelayMethod() {
    RequestSpecification request = RestAssured.given();
    Response response = request.get("/delay/1");
    assertThat(response.statusCode(), equalTo(200));
    assertThat(response.jsonPath().get("headers.Accept-Encoding"), equalTo("gzip,deflate"));
  }
}
