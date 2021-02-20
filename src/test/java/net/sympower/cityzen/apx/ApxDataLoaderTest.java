package net.sympower.cityzen.apx;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApxDataLoaderTest {

    @Test
    public void load() throws Exception {
        // Arrange
        ApxDataLoader apxDataLoader = new ApxDataLoader();
        apxDataLoader.url = getClass().getResource("apx-data.json");

        // Act
        QuoteResponse response = apxDataLoader.load();

        // Assert
        assertNotNull(response);

        ObjectMapper mapper = new ObjectMapper();

        // pretty print
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
        System.out.println(json);

    }

    @Test
    public void parseTest() throws Exception {
        // Arrange
        ApxDataLoader apxDataLoader = new ApxDataLoader();
        apxDataLoader.url = getClass().getResource("apx-data.json");

        // Act
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(apxDataLoader.url);

        // Assert
        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();

            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();

                if ("market".equals(fieldName)) {
                    assertEquals("market", fieldName);
                } else if ("date_applied".equals(fieldName)) {
                    assertEquals("date_applied", fieldName);
                } else if ("tLabel".equals(fieldName)) {
                    assertEquals("tLabel", fieldName);
                } else if ("cLabel".equals(fieldName)) {
                    assertEquals("cLabel", fieldName);
                } else if ("values".equals(fieldName)) {
                    assertEquals("values", fieldName);
                } else if ("quote".equals(fieldName)) {
                    assertEquals("quote", fieldName);
                } else if ("unit".equals(fieldName)) {
                    assertEquals("unit", fieldName);
                } else if ("position".equals(fieldName)) {
                    assertEquals("position", fieldName);
                } else if ("chartShow".equals(fieldName)) {
                    assertEquals("chartShow", fieldName);
                } else if ("chartType".equals(fieldName)) {
                    assertEquals("chartType", fieldName);
                } else if ("color".equals(fieldName)) {
                    assertEquals("color", fieldName);
                } else if ("color".equals(fieldName)) {
                    assertEquals("unit", fieldName);
                } else if ("precision".equals(fieldName)) {
                    assertEquals("precision", fieldName);
                }
            }
        }
    }

}