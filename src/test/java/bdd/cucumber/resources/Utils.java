package bdd.cucumber.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public RequestSpecification requestSpecification;

    public RequestSpecification GetRequestSpecification() throws IOException {
        if(requestSpecification == null){
            PrintStream printStream = new PrintStream(new FileOutputStream("logging.txt"));
            requestSpecification = new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .setBaseUri(GetGlobalConfig("BASE_URL"))
                    .addFilter(RequestLoggingFilter.logRequestTo(printStream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
                    .build();

            return requestSpecification;
        }
        return requestSpecification;
    }

    public String GetGlobalConfig(String key) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/bdd/cucumber/resources/GlobalConfig.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

    public String GetJsonPath(Response response, String key){
        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
        return String.valueOf(jsonPath.getString(key));
    }

}
