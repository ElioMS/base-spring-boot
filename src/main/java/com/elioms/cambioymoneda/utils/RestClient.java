package com.elioms.cambioymoneda.utils;

import com.elioms.cambioymoneda.models.response.MigoResponse;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class RestClient {

    private String uri;
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClient(String uri, @Nullable String authorization) {

        this.uri = uri;
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();

        headers.add("Accept", "*/*");
        headers.add("Authorization", authorization);
    }

    public String get() {
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
//        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public String post(String json) {
        headers.add("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
        ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
//        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public String postFormData(MultiValueMap<String, String> map) {
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = rest.postForEntity( uri, request , String.class );
        System.out.println("respuesta: "+response.getBody());
        return response.getBody();
    }

//    public void put(String uri, String json) {
//        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
//        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.PUT, requestEntity, (Class<String>) null);
////        this.setStatus(responseEntity.getStatusCode());
//    }

//    public void delete(String uri) {
//        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
//        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.DELETE, requestEntity, (Class<String>) null);
////        this.setStatus(responseEntity.getStatusCode());
//    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}