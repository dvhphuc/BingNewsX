package service;

import configuration.TopNewsConfig;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

public class ReaderService {
    public static NodeList getRssItems(String rssUrl) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(rssUrl).openStream());
        var listItems = doc.getElementsByTagName("item");

        return listItems;
    }

    public static JSONObject getTopNewsesFromAPIConfig(TopNewsConfig topNewsAPIConfig) {
        var url = topNewsAPIConfig.getUrl();
        var apikey = topNewsAPIConfig.getQueryParams().get("apikey");
        var country = topNewsAPIConfig.getQueryParams().get("country");
        var responseKey = topNewsAPIConfig.getResponseKey();

        url = url + "?apikey=" + apikey + "&country=" + country;

    }
}
