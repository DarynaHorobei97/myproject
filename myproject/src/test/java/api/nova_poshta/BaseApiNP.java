package api.nova_poshta;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;


public abstract class BaseApiNP {
    protected RequestSpecification reqspec;
    protected ResponseSpecification resSpec;


    @BeforeEach
    public void setSpecs() {
        reqspec = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri("https://api.novaposhta.ua/v2.0/json/")
                .build();
        resSpec = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
