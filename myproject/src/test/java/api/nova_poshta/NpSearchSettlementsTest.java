package api.nova_poshta;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class NpSearchSettlementsTest extends BaseApiNP {

    private final static String API_KEY = "4ad7a79cd70fe366e6ff23c1dbec58dc";

    private Map<String, Object> reqBody = new HashMap<>();

    @BeforeEach
    public void setReqBody() {
        Map<String, Object> methodProperties = new HashMap<>();

        methodProperties.put("CityName", "м. Київ");
        methodProperties.put("Limit", 5);

        reqBody.put("calledMethod", "searchSettlements");
        reqBody.put("methodProperties", methodProperties);
        reqBody.put("modelName", "Address");
        reqBody.put("apiKey", API_KEY);
    }

    @Test
    public void checkSettlements() {
        given()
                .spec(this.reqspec)
                .body(this.reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    public void checkJsonSchema() {
        given()
                .spec(this.reqspec)
                .body(this.reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body( matchesJsonSchema(
                        new File(System.getProperty("user.dir") +
                                "\\src\\main\\resources\\validators\\np_address_schema.json")));
    }

    @Test
    public void someCheck() {

        given()
                .spec(this.reqspec)
                .body(this.reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("success", equalTo(true))
                .body("data[0].Addresses.Present", hasItems("м. Київ, Київська обл.",
                        "смт. Макарів, Макарівський р-н, Київська обл."))
                .body("data[0].TotalCount", equalTo(106));
    }

    @Test
    public void testWithPojoUsage() {

        List<Address> addressesData = given()
                .spec(this.reqspec)
                .when()
                .contentType(ContentType.JSON).when().body(this.reqBody)
                .post()
                .then().log().all()
                .extract()
                .body().jsonPath().getList("data[0].Addresses", Address.class);

        System.out.println(addressesData);
        addressesData.forEach(el -> Assertions.assertTrue(el.getPresent().contains("Київ")));

    }


}