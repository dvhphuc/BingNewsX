package model;

import java.util.Date;

public class Article {
    String title;
    String imgUrl;
    String channel;
    String pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    String sourceLink;

    public void setField(String key, String content) {
        switch (key) {
            case "title":
                this.setTitle(content);
                break;
            case "imgUrl":
                this.setImgUrl(content);
                break;
            case "channel":
                this.setChannel(content);
                break;
            case "pubDate":
                this.setPubDate(content);
                break;
            case "sourceLink":
                this.setSourceLink(content);
                break;
        }
    }
}
