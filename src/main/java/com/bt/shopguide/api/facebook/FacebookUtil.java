package com.bt.shopguide.api.facebook;

import com.bt.shopguide.api.util.HttpClientHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiting on 2017/10/30.
 */
@Service
public class FacebookUtil {
//    @Value("${share.facebook.tooken}")
    private String token;
//    @Value("${share.facebook.apiversion}")
    private String version;
//    @Value("${share.facebook.host}")
    private String host;
//    @Value("${share.facebook.user.id}")
    private String userId;



    public String sharePhoto(String photoUrl,String caption){
        Map param = new HashMap();
        param.put("access_token",token);
        param.put("url",photoUrl);
        param.put("caption",caption);
        String result = HttpClientHelper.getInstance().doPost(host+"/"+this.version+"/"+userId+"/photos",param);
        return result;
    }

    public static void main(String[] args) {
        FacebookUtil fu = new FacebookUtil();
        fu.token = "EAAS3KvljZAhkBAAxXAoZCCb88gWm0E8oix0vFwBXRX7DbipuBAxUOC7k2wClOcAKdxvItzISCKW0DFGMuXNY9lzRftYyiqZB8ZAOnykgf9nesH3CGKoHfpjyOHZBbTdljMCZCG3nR7Jr4CYEYyQcrz0tIBQ8wQfZA7wuNRKqTutrwZDZD";
        fu.version= "v2.5";
        fu.host= "https://graph.facebook.com";
        fu.userId= "867355876777770";

        System.out.println(fu.sharePhoto("http://imgcache.dealmoon.com/img.dealmoon.com/images/c/16/02/19/56c72db183421.jpg_300_0_13_a375.jpg","Panasonic ES-LA93-K Arc4 Electric Shaver"));
    }
}
