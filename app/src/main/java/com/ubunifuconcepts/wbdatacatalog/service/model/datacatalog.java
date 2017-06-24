package com.ubunifuconcepts.wbdatacatalog.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan on 6/24/2017.
 */

public class datacatalog {

    public String id;
    public List<Indicator> metatype;

    public datacatalog(){
        metatype = new ArrayList<Indicator>();
    }
}
