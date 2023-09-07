package service;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static JSONArray getMatchResultFromAPI() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-beta.p.rapidapi.com/fixtures?date=2023-02-06"))
                .header("X-RapidAPI-Key", "65e4f82b53msh001c94c3de4e044p16cf4fjsna8cbb2957755")
                .header("X-RapidAPI-Host", "api-football-beta.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        return new JSONObject(response.body()).getJSONArray("response");
    }

}
