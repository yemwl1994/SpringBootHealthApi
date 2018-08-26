package com.acc.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class GoogleMapApi {
	
	public void getLatLongi(String address) throws IOException {
		
		RestTemplate template = new RestTemplate();
		
		Properties prop = PropertiesUtil.getProperties();
		
		String gkey = prop.getProperty("google.map.api.key");
		String Address = address;
		
		HttpHeaders headers= new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE,"application/json");
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .scheme("https").host("maps.googleapis.com").pathSegment("maps","api","geocode","json")
			       .query("key={key}").query("address={address}").build().expand(gkey,Address).encode();
		
		SimpleClientHttpRequestFactory simpleClient = (SimpleClientHttpRequestFactory)template.getRequestFactory();
		simpleClient.setConnectTimeout(30000);
		simpleClient.setReadTimeout(30000);
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers); 
		ResponseEntity<String> result = template.exchange(uriComponents.toUriString(), HttpMethod.GET, httpEntity, String.class); 
		System.out.println(result);
		
		// put it in a model or write to a json file and return the model
	}
}


/* "results" : [
{
    "address_components" : [
       {
          "long_name" : "20Taman",
          "short_name" : "20Taman",
          "types" : [ "subpremise" ]
       },
       {
          "long_name" : "20",
          "short_name" : "20",
          "types" : [ "street_number" ]
       },
       {
          "long_name" : "Jalan Petaling",
          "short_name" : "Jalan Petaling",
          "types" : [ "route" ]
       },
       {
          "long_name" : "City Centre",
          "short_name" : "City Centre",
          "types" : [ "political", "sublocality", "sublocality_level_1" ]
       },
       {
          "long_name" : "Kuala Lumpur",
          "short_name" : "Kuala Lumpur",
          "types" : [ "locality", "political" ]
       },
       {
          "long_name" : "Wilayah Persekutuan Kuala Lumpur",
          "short_name" : "Wilayah Persekutuan Kuala Lumpur",
          "types" : [ "administrative_area_level_1", "political" ]
       },
       {
          "long_name" : "Malaysia",
          "short_name" : "MY",
          "types" : [ "country", "political" ]
       },
       {
          "long_name" : "50000",
          "short_name" : "50000",
          "types" : [ "postal_code" ]
       }
    ],
    "formatted_address" : "20Taman, 20, Jalan Petaling, City Centre, 50000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur, Malaysia",
    "geometry" : {
       "bounds" : {
          "northeast" : {
             "lat" : 3.1450767,
             "lng" : 101.6979203
          },
          "southwest" : {
             "lat" : 3.1449706,
             "lng" : 101.6976527
          }
       },
       "location" : {
          "lat" : 3.1450433,  /////////////////////////////////////////////////////latitude
          "lng" : 101.6978674 /////////////////////////////////////////////////////longitude
       },
       "location_type" : "ROOFTOP",
       "viewport" : {
          "northeast" : {
             "lat" : 3.146372630291502,
             "lng" : 101.6991354802915
          },
          "southwest" : {
             "lat" : 3.143674669708498,
             "lng" : 101.6964375197085
          }
       }
    },
    "partial_match" : true,
    "place_id" : "EmgyMFRhbWFuLCAyMCwgSmFsYW4gUGV0YWxpbmcsIENpdHkgQ2VudHJlLCA1MDAwMCBLdWFsYSBMdW1wdXIsIFdpbGF5YWggUGVyc2VrdXR1YW4gS3VhbGEgTHVtcHVyLCBNYWxheXNpYSIjGiEKFgoUChIJO7OHo9FJzDERTxZkGqxaPi0SBzIwVGFtYW4",
    "types" : [ "subpremise" ]
 }
],
"status" : "OK"*/