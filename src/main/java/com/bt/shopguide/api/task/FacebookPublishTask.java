package com.bt.shopguide.api.task;

import com.bt.shopguide.api.util.HttpClientHelper;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiting on 2017/11/2.
 */
public class FacebookPublishTask {

    public void publishPhoto(){

    }

    public static void main(String[] args) throws Exception {
        HttpClientHelper http = HttpClientHelper.getInstance();
        Map m = new HashMap();
        m.put("longUrl","http://www.dealswill.com/detail/19021");
        System.out.println(http.doPost("https://www.googleapis.com/urlshortener/v1/url?key=AIzaSyDRM32LWTZK_49u6LmUa3le95CUfQ7eBRg", m, new BasicHeader("Content-Type","application/json")));

    }
}
