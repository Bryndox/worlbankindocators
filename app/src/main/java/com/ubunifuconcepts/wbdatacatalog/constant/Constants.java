package com.ubunifuconcepts.wbdatacatalog.constant;

/**
 * Created by Bryan on 6/19/2017.
 */

public class Constants {
    public static int CATALOG_LOADER = 0;
    public static String INTENT_WEBVIEW_URL = "intent_webview_url";
    public static String INTENT_WEBVIEW_NAME = "intent_webview_name";

    public static class BroadcastReceiver {
        public static class Actions {
            public static String CATALOG_CHANGED = "catalog_changed";
        }
    }

    public static class ApiEndPoint {
        public static String API_CATALOG = "http://api.worldbank.org/v2/datacatalog/metatypes/name;description;url?format=json&per_page=20";
    }
}
