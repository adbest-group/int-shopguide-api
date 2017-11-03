package com.bt.shopguide.api.task;

import com.bt.shopguide.api.util.HttpClientHelper;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

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
        String json = "{\"longUrl\": \"http://www.dealswill.com\"}";
        String apiUrl = "https://www.googleapis.com/urlshortener/v1/url?key=AIzaSyDRM32LWTZK_49u6LmUa3le95CUfQ7eBRg";
        HttpClientHelper http = HttpClientHelper.getInstance();
        CloseableHttpClient httpClient = http.getConnection();


        HttpPost postRequest = new HttpPost(apiUrl);
        postRequest.setHeader("Content-Type", "application/json");
        postRequest.setEntity(new StringEntity(json, "UTF-8"));

        HttpResponse response = httpClient.execute(postRequest);
        String responseText = EntityUtils.toString(response.getEntity());

        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        HashMap<String, String> res = gson.fromJson(responseText, HashMap.class);



        System.out.println(res.get("id"));

    }
}
