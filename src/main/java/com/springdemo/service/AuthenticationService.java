package com.springdemo.service;

import com.springdemo.dao.UserLoginRequest;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Optional;

public class AuthenticationService {

    public static final String AUTHENTICATION_URL = "http://localhost:6060/users/login";

    public String getAuthenticationHeader(UserLoginRequest userdao){
        String valueToEncode = userdao.getUsername() + ":" + userdao.getPassword();
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

    public String submitAuthenticationRequest(UserLoginRequest userLoginRequest)
            throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(AUTHENTICATION_URL))
                .header("Authorization", getAuthenticationHeader(userLoginRequest))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 401){
            throw new AuthenticationException("Username or password incorrect");
        }
        if(response.statusCode() == 400){
            throw new IOException("Something is wrong on our end :(");
        }
        Optional<String> authToken = response.headers().firstValue("Authorization");
        return authToken.orElse(null);

    }
}
