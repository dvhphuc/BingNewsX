package service;

import configuration.SportAPI;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ReaderService {
    public static NodeList getRssItems(String rssUrl) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(rssUrl).openStream());
        var listItems = doc.getElementsByTagName("item");

        return listItems;
    }

    public static JSONArray getNewsJsonFromAPI(String endpoint, String responseKey) throws Exception {
        var url = new URL(endpoint);
        var connection = url.openConnection();
        var response = connection.getInputStream();
        var responseString = new String(response.readAllBytes());
        return new JSONObject(responseString).getJSONArray(responseKey);
    }

    public static JSONArray getMatchResultFromAPI(SportAPI sportAPI) throws Exception {
        var uri = sportAPI.getURI();
        var rapidAPIHost = sportAPI.getRapidHost();
        var rapidAPIKey = sportAPI.getRapidKey();
        var method = sportAPI.getMethod(); //GET, PUT, POST,...
        var responseKey = sportAPI.getResponseKey();

        var req = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header(rapidAPIKey.getKey(), rapidAPIKey.getValue())
                .header(rapidAPIHost.getKey(), rapidAPIHost.getValue())
                .method(method, HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());

        return new JSONObject(res.body()).getJSONArray(responseKey);
    }
}
