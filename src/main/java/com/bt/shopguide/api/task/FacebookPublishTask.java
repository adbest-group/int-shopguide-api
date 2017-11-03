package com.bt.shopguide.api.task;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;

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
//        HttpClientHelper http = HttpClientHelper.getInstance();
//        Map m = new HashMap();
//        m.put("url","http://www.dealswill.com/detail/19021");
//        System.out.println(http.doPost("https://goo.gl/api/shorten",m));
        String longURL = "https://www.google.co.jp";
        String shortURL = "";
        HttpsURLConnection con = null;
        Gson gson = new Gson();
            Map<String, String> valueMap = new HashMap<>();
            valueMap.put("longUrl", longURL);
            String requestBody = gson.toJson(valueMap);
            con = (HttpsURLConnection) new URL("https://www.googleapis.com/urlshortener/v1/url?key=secretKey").openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            con.getOutputStream().write(requestBody.getBytes());

            if (con.getResponseCode() == 200)
            {
                StringBuilder sb = new StringBuilder();
                try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())))
                {
                    String line;
                    while((line = br.readLine()) != null)
                    {
                        sb.append(line);
                    }
                    Map<String, String> map =gson.fromJson(sb.toString(),Map.class);

                    if (map != null && StringUtils.isNotEmpty(map.get("id")))
                    {
                        shortURL = map.get("id");
                    }
                }
                catch(IOException e)
                {
                    e.printStackTrace(); //TODO Change to Logger
                }
            }
        System.out.println(shortURL);

    }
}
