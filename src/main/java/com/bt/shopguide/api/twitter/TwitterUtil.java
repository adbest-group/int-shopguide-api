package com.bt.shopguide.api.twitter;

import com.bt.shopguide.api.util.HttpClientHelper;
import twitter4j.*;

/**
 * Created by caiting on 2017/11/20.
 */
public class TwitterUtil {

    public static void main(String[] args) {
        System.out.println("test app");
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = null;
//        UploadedMedia media = null;
        try {
            StatusUpdate st = new StatusUpdate("$579.99 ($779.99, 26% off) Apple 10.5-Inch iPad Pro with Cellular 64GB (Verizon).Link Here: http://www.dealswill.com/detail/29028.");
            st.setMedia("", HttpClientHelper.getInstance().getStaticResourceInputStream("http://imgcache.dealmoon.com/thumbimg.dealmoon.com/ugc/d95/7f6/bac/4a71689737090ff91d930e7.jpg_300_0_13_504b.jpg"));
            status = twitter.updateStatus(st);
//            media = twitter.uploadMedia;

        } catch (TwitterException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
}
