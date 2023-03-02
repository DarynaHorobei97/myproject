package api.nova_poshta;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APITest extends BaseApiNP {
    @Test
    public void testWithPojoUsage() {
//        String API_KEY = "4ad7a79cd70fe366e6ff23c1dbec58dc";
//
//        Map<String, Object> reqBody = new HashMap<>();
//        Map<String, Object> methodProperties = new HashMap<>();
//
//        methodProperties.put("CityName", "м. Київ");
//        methodProperties.put("Limit", 5);
//
//        reqBody.put("calledMethod", "searchSettlements");
//        reqBody.put("methodProperties", methodProperties);
//        reqBody.put("modelName", "Address");
//        reqBody.put("apiKey", API_KEY);

        List<Address> addressesData = given()
                .when()
                .contentType(ContentType.JSON).when()
                .body(reqspec)
                .post("https://api.novaposhta.ua/v2.0/json/")
                .then().log().all()
                .spec(this.resSpec)
               // .statusCode(200)
                .extract()
                .body().jsonPath().getList("data[0].Addresses", Address.class);

        addressesData.forEach(x -> Assertions.assertTrue(x.getPresent().contains("Київ")));

    }

}
