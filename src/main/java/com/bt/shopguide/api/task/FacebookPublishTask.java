package com.bt.shopguide.api.task;

import com.bt.shopguide.api.util.HttpClientHelper;
import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiting on 2017/11/2.
 */
public class FacebookPublishTask {

    public void publishPhoto(){

    }

    public static void main(String[] args) {
        HttpClientHelper http = HttpClientHelper.getInstance();
        Map m = new HashMap();
        m.put("url","HttpClientHelper");
        http.doPost("https://goo.gl",m);
    }
}
