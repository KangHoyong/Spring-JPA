package com.example.demo.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(
    properties = "spring.config.location=classpath:/google.yml")
public class OAuthConfigTest
{
    @Before
    public void setup()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void 구글로그인시도하면OAuth인증창등장여부체크() throws Exception
    {
        given()
        .when()
            .redirects().follow(false) // 리다이렉트 방지
            .get("/login")
        .then()
            .statusCode(302)
            .header("Location", containsString("https://accounts.google.com/o/oauth2/auth"));
    }
}