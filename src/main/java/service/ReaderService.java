package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.Sportapi;
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
import java.util.List;

public class ReaderService {
    public static <T> T readConfig(String configPath, Class<T> configClass) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new java.io.File(configPath), configClass);
    }
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

    public static JSONArray getMatchResultFromAPI(Sportapi sportapi) throws Exception {
        var methodName = sportapi.getMethod();
        var resonseKey = sportapi.getResponseKey();

        var request = HttpRequest.newBuilder()
                .uri(URI.create(sportapi.getURI()))
                .header("X-RapidAPI-Key", sportapi.getHeader().get("X-RapidAPI-Key"))
                .header("X-RapidAPI-Host", sportapi.getHeader().get("X-RapidAPI-Host"))
                .method(methodName, HttpRequest.BodyPublishers.noBody())
                .build();

        var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return new JSONObject(response.body()).getJSONArray(resonseKey);
    }

}
