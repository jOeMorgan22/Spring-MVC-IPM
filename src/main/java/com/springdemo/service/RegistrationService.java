package com.springdemo.service;

import com.google.gson.Gson;
import com.springdemo.dao.UserRegistrationRequest;
import org.springframework.dao.DataIntegrityViolationException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RegistrationService {

    public static final String REGISTER_URL = "http://localhost:6060/register";

    public String submitRegistrationRequest(UserRegistrationRequest registrationRequest)
            throws IOException, InterruptedException {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        registrationRequest.setRole("ROLE_USER");
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(registrationRequest)))
                .uri(URI.create(REGISTER_URL))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 409){
            throw new DataIntegrityViolationException("Username already exists");
        }
        return response.body();
    }
}
