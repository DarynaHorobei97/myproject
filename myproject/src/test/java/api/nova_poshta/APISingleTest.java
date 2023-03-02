package api.nova_poshta;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APISingleTest {
    @Test
    public void checkThatSuccess() {
        String API_KEY = "4ad7a79cd70fe366e6ff23c1dbec58dc";

        Map<String, Object> reqBody = new HashMap<>();
        Map<String, Object> methodProperties = new HashMap<>();

        methodProperties.put("CityName", "м. Київ");
        methodProperties.put("Limit", 5);

        reqBody.put("calledMethod", "searchSettlements");
        reqBody.put("methodProperties", methodProperties);
        reqBody.put("modelName", "Address");
        reqBody.put("apiKey", API_KEY);

        given()
                .when()
                .contentType(ContentType.JSON).when()
                .body(reqBody)
                .post("https://api.novaposhta.ua/v2.0/json/")
                .then().log().all()
                .statusCode(200)
                .assertThat()
                .body("success", equalTo(true));
    }
}
