package com.bt.shopguide.api.twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Created by caiting on 2017/11/20.
 */
public class TwitterUtil {

    public static void main(String[] args) {
        System.out.println("test app");
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = null;
        try {
            status = twitter.updateStatus("$12.00 Prime Members Only: ChromaCast Acoustic Guitar 6-Pocket Padded Gig Bag. $12 @Amazon.Link Here: http://www.dealswill.com/detail/28920.");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
}
