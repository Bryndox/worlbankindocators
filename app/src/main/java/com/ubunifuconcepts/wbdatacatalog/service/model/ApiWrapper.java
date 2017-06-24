package com.ubunifuconcepts.wbdatacatalog.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan on 6/24/2017.
 */

public class ApiWrapper {
    public  int page;
    public  int pages;
    public  String per_page;
    public  int total;
    public  List<datacatalog> datacatalog;

    public ApiWrapper(){
        datacatalog = new ArrayList<datacatalog>();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<com.ubunifuconcepts.wbdatacatalog.service.model.datacatalog> getDatacatalog() {
        return datacatalog;
    }

    public void setDatacatalog(List<com.ubunifuconcepts.wbdatacatalog.service.model.datacatalog> datacatalog) {
        this.datacatalog = datacatalog;
    }
}
