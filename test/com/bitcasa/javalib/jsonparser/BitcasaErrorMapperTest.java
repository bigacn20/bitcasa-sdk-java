package com.bitcasa.javalib.jsonparser;

import junit.framework.Assert;

import org.junit.Test;

import com.bitcasa.javalib.dao.BitcasaError;
import com.bitcasa.javalib.dao.BitcasaResponse;
import com.bitcasa.javalib.exception.BitcasaException;
import com.bitcasa.javalib.exception.BitcasaJSONException;


public class BitcasaErrorMapperTest {

	@Test
	public void testErrorObjectMapper() throws BitcasaException {
		final String bitcasaError = "{\"code\":1050, \"message\":\"Your account is over quota. Delete some files or upgrade.\"}";
		BitcasaJSONParser jsonParser = new BitcasaJSONParser();
		BitcasaError error = jsonParser.parseJSONToObject(bitcasaError, BitcasaError.class);
		Assert.assertEquals(1050, error.getCode());
		Assert.assertEquals("Your account is over quota. Delete some files or upgrade.", error.getMessage());
	}
	
	@Test
	public void testErrorResponseObjectMapper() throws BitcasaException {
		final String errorResponse = "{\"error\": {\"code\":1005,\"message\": \"Email address is required\"},\"result\": null}";
		BitcasaJSONParser jsonParser = new BitcasaJSONParser();
		BitcasaResponse response = jsonParser.parseJSONToObject(errorResponse, BitcasaResponse.class);
		Assert.assertEquals(1005, response.getError().getCode());
		Assert.assertEquals("Email address is required", response.getError().getMessage());
		Assert.assertEquals(null, response.getResult());
	}
}
