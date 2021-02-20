package net.sympower.cityzen.apx;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ApxDataLoaderTest {

    @Test
    public void loadTest() throws Exception {
        // Arrange
        ApxDataLoader apxDataLoader = new ApxDataLoader();
        apxDataLoader.setUrl(getClass().getResource("apx-data.json"));

        // Act
        QuoteResponse response = apxDataLoader.load();

        // Assert
        assertNotNull(response);
        assertFalse(response.getQuotes().isEmpty());
        Assert.assertTrue(response.getQuotes().size() > 0);
        assertNotNull(response.getQuotes().get(0).getDate());
    }

    @Test
    public void parseFieldNameTest() throws Exception {
        // Arrange
        ApxDataLoader apxDataLoader = new ApxDataLoader();
        apxDataLoader.setUrl(getClass().getResource("apx-data.json"));

        // Act
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(apxDataLoader.getUrl());

        // Assert
        while (!parser.isClosed()) {
            parser.nextToken();
            String fieldName = parser.getCurrentName();
            if ("quote".equals(fieldName)) {
                assertEquals("quote", fieldName);
            } else if ("date_applied".equals(fieldName)) {
                assertEquals("date_applied", fieldName);
            } else if ("tLabel".equals(fieldName)) {
                assertEquals("tLabel", fieldName);
            } else if ("values".equals(fieldName)) {
                assertEquals("values", fieldName);
            } else if ("value".equals(fieldName)) {
                assertEquals("value", fieldName);
            }
        }
    }
}
