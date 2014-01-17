package com.bitcasa.javalib.jsonparser;

import com.bitcasa.javalib.dao.*;
import com.bitcasa.javalib.exception.BitcasaException;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class BitcasaItemsResultTest {

    @Test
    public void testItemsResultMapper() throws BitcasaException {
        final String itemsResult = "{\"error\":null,\"result\": {\"items\":[{\"category\": \"folders\",\"name\": \"Getting Started\","
                + "\"mtime\": 1355807345000,\"path\": \"/ySma71B_Tbq0KwstGl1Zew/2oj2JZJQRZSvJuXY8eoeLw\",\"type\": 1,"
                + "\"mirrored\": false},{\"category\": \"documents\",\"album\": null,\"name\": \"About Bitcasa.pdf\","
                + "\"extension\": \"pdf\",\"duplicates\": [0],\"mirrored\": false,\"manifest_name\": \"Bitcasa Infinite Drive\","
                + "\"mime\": \"application/pdf\",\"mtime\": 1355801565998,\"path\": \"/ySma71B_Tbq0KwstGl1Zew/2oj2JZJQRZSvJuXY8eoeLw/V7As4ytsR5KDC25ChGAL7w\","
                + "\"type\": 0,\"id\": \"qkRXMMdB5zFNWU54LrQ31L2ZaGl2dHCIJGGX5LXzoR9WAalEUcRSeMizOJbzCWAalEAz7rMGDxCSfgV0dhjtcA==\","
                + "\"incomplete\": false,\"size\": 715581},{\"category\": \"documents\",\"album\": null,"
                + "\"name\": \"Bitcasa Android App Tutorial.pdf\",\"extension\": \"pdf\",\"duplicates\": [0],"
                + "\"mirrored\": false,\"manifest_name\": \"Bitcasa Infinite Drive\",\"mime\": \"application/pdf\","
                + "\"mtime\": 1355801567331,\"path\": \"/ySma71B_Tbq0KwstGl1Zew/2oj2JZJQRZSvJuXY8eoeLw/qhzfHga9SgOLzMVuShMhoA\","
                + "\"type\": 0,\"id\": \"DTm5S7H-aNWEPALq_Sp5jTd4JhkPeH1xODtmiIxBQTDn3R4wurxAX82DlBDe_5DmLlyEWtjhAozOtJD2rsk83w==\","
                + "\"incomplete\": false,\"size\": 2521560}]}}";
        BitcasaJSONParser jsonParser = new BitcasaJSONParser();
        BitcasaResponse response = jsonParser.parseJSONToObject(itemsResult, BitcasaResponse.class);
        BitcasaResult result = response.getResult();
        Assert.assertEquals(null, response.getError());
        Assert.assertNotNull(result);

        // check there are 3 items
        List<BitcasaItem> items = result.getItems();
        Assert.assertEquals(3, items.size());
        Assert.assertTrue(items.get(0) instanceof BitcasaFolder);
        Assert.assertTrue(items.get(1) instanceof BitcasaFile);
    }
}
