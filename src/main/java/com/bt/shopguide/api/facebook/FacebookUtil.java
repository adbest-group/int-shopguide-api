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
        fu.token = "EAAS3KvljZAhkBAFEZAiNECTTLWugYeZB96V3BzFWZCz49imnY8VmkK6zH1ZAZBdpmzPPOAhlZBEx77v5YCd3ZBgeyMYlfm8c58YefS2Hgzo50ZCklQ0Q6XlCxYRmF8AR9gJxrn0xQZAaCQzqoinu8rZAFjtqDcKIysnJShc8jhv6iZAR4AZDZD";
        fu.version= "v2.10";
        fu.host= "https://graph.facebook.com";
        fu.userId= "867355876777770";

        System.out.println(fu.sharePhoto("http://b1.photo.store.qq.com/psu?/15b945c2-e6f4-41ff-b5c1-2bf3229a248c/QAhYWWcAqQAIf.lP1Y*Tzm9iVYfdaAA3fZ3OQSuEP5Y!/b/YQKE1wFv0gAAYtdpqQARfgAA&a=3&b=1&bo=ngL3AQAAAAABAE0!&rf=viewer_4","翻到旧照片，2008北京奥运会"));
    }
}
