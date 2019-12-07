package com.example.api1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class youtubeLink {
    public JSONArray items = null;
    public String id = null;
    public static String url = null;
    public String thumbnailUrl = null;
    public String title = null;
    public String description = null;
    public static ArrayList<String> ytlinkList = new ArrayList<>();
    public static ArrayList<String> thumbnailList = new ArrayList<>();


    public youtubeLink(String id, String thumbnailUrl, String title, String description) {
        this.id = id;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.description = description;
    }

    public JSONArray getItems() {
        return items;
    }

    public void setItems(JSONArray items) {
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static ArrayList<String> getList() {
        return ytlinkList;
    }

    public static void addList(String link) {
        ytlinkList.add(link);
    }

    public static String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<String> getThumbnailList() {
        return thumbnailList;
    }

    public static void setThumbnailList(ArrayList<String> thumbnailList) {
        youtubeLink.thumbnailList = thumbnailList;
    }
}
