package api.nova_poshta;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.XML;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class HomeWorkNovaPoshta extends BaseApiNP {

    private String type;

    @Test
    public void checkIfSuccessIsTrueJson() {
        given()
                .spec(this.reqspec)
                .queryParam("success")
                .contentType(JSON)
                .when()
                .post("/json")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    public void checkIfSuccessIsTrueXml() {
        given()
                .spec(this.reqspec)
                .queryParam("success")
                .contentType(XML)
                .when()
                .post("/xml")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    public void checkDescriptionXml() {
        given()
                .spec(this.reqspec)
                .queryParam("data")
                .contentType(XML)
                .when()
                .post("/xml")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("data.@Description", hasItems(equalTo("Вантаж"),
                        equalTo("Документи"), equalTo("Шини-диски"),
                        equalTo("Палети")),
                        "data.@Ref", hasItems(equalTo("Cargo"),
                                equalTo("Documents"), equalTo("TiresWheels"),
                                equalTo("Pallet")));
    }

    @Test
    public void checkDescriptionJson() {
        given()
                .spec(this.reqspec)
                .queryParam("data")
                .contentType(JSON)
                .when()
                .post("/json")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("data.@Description", hasItems(equalTo("Вантаж"),
                        equalTo("Документи"), equalTo("Шини-диски"),
                        equalTo("Палети")),
                        "data.@Ref", hasItems(equalTo("Cargo"),
                                equalTo("Documents"), equalTo("TiresWheels"),
                                equalTo("Pallet")));
    }

    @Test
    public void checkOfErrorsAbsenseJson() {
        given()
                .spec(this.reqspec)
                .queryParam("errors")
                .contentType(JSON)
                .when()
                .post("/json")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("errors", equalTo(null));
    }

}
