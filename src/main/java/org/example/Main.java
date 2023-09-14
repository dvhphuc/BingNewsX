package org.example;

import configuration.Configuration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        var client = HttpClient.newHttpClient();
        var resquest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/myendpoint"))
                .build();
        var response = client.send(resquest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
