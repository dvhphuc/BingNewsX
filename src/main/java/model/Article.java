package model;

public class Article {
    String title;
    String imgUrl;
    String pubDate;

    public Article() {
    }

    public Article(String guid, String title, String imgUrl, String pubDate, String sourceLink, String channelId) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.channelId = channelId;
        this.pubDate = pubDate;
        this.guid = guid;
        this.sourceLink = sourceLink;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    String guid;
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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
    String channelId;

}
