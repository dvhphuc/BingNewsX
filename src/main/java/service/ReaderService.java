package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.financial.CryptosCfg;
import configuration.financial.CurExchangesCfg;
import configuration.sport.Sportapi;
import configuration.weather.WeatherApi;
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
import java.util.Arrays;
import java.util.List;

public class ReaderService {
    public static <T> T getConfig(String configPath, Class<T> configClass) throws Exception {
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

    public static JSONArray getWeatherJsonFromAPI(WeatherApi weatherApi) throws Exception {
        var url = new URL(weatherApi.getEndpoint());
        var connection = url.openConnection();
        var response = connection.getInputStream();
        var responseString = new String(response.readAllBytes());

        //logic to get the array from the response
        List<String> subKeys = List.of(weatherApi.getResponseKey().split("\\."));
        var forecast = subKeys.get(0);
        var forecastday = subKeys.get(1);
        var hour = subKeys.get(2);

        JSONObject jsonObject = new JSONObject(responseString);
        var hourlyForecase = jsonObject.getJSONObject(forecast)
                .getJSONArray(forecastday)
                .getJSONObject(0)
                .getJSONArray(hour);

        return hourlyForecase;
    }

    public static JSONArray getCryptoInfo(CryptosCfg cryptosCfg) throws Exception {
        var responseKey = cryptosCfg.getResponseKey();
        var keys = Arrays.asList(responseKey.split("\\."));
        var lastKey = keys.get(keys.size() - 1);
        keys = keys.subList(0, keys.size() - 1);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(cryptosCfg.getURI()))
                .header("X-RapidAPI-Key", cryptosCfg.getHeaders().getXRapidAPIKey())
                .header("X-RapidAPI-Host", cryptosCfg.getHeaders().getXRapidAPIHost())
                .method(cryptosCfg.getMethod(), HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var jsonObject = new JSONObject(response.body());
        for (String key : keys) {
            try {
                jsonObject = jsonObject.getJSONObject(key);
            }
            catch (Exception e) {
                jsonObject = jsonObject.getJSONArray(key).getJSONObject(0);
            }
        }
        return jsonObject.getJSONArray(lastKey);
    }

    public static JSONArray getCurrencyExchange(CurExchangesCfg curExchangesCfg) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(curExchangesCfg.getURL()))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var responseArray = new JSONArray(response.body());
        var items = new JSONArray();
        for (var i = 0; i < responseArray.length(); ++i) {
            var item = responseArray.getJSONArray(i).getJSONObject(0);
            items.put(item);
        }
        return items;
    }
}
