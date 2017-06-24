package com.ubunifuconcepts.wbdatacatalog.model;

/**
 * Created by Bryan on 6/19/2017.
 */

public class WBindicator {
    private long id;
    private String name;
    private String desciption;
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
