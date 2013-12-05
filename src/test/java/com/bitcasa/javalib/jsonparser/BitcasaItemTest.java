package com.bitcasa.javalib.jsonparser;

import com.bitcasa.javalib.dao.BitcasaItem;
import com.bitcasa.javalib.exception.BitcasaException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BitcasaItemTest {

    @Test
    public void testItemObjectMapper() throws BitcasaException {
        final String itemJson = "{\"category\": \"folders\","
                + "\"status\": \"created\","
                + "\"name\": \"test\","
                + "\"mirrored\": false,"
                + "\"mtime\": 1378316802366,"
                + "\"path\": \"/ySma71B_Tbq0KwstGl1Zew/2oj2JZJQRZSvJuXY8eoeLw/LMnhJPZ3RRqUUBp6sDk4tg\","
                + "\"type\": 1}";
        BitcasaJSONParser jsonParser = new BitcasaJSONParser();
        BitcasaItem item = jsonParser.parseJSONToObject(itemJson, BitcasaItem.class);
        assertEquals(BitcasaItem.CATEGORY_FOLDERS, item.getCategory().toString());
    }
}
