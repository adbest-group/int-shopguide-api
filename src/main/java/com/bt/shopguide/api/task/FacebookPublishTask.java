package com.bt.shopguide.api.task;


import com.bt.shopguide.api.facebook.FacebookUtil;
import com.bt.shopguide.api.util.GoogleShortener;
import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.service.IGoodsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by caiting on 2017/11/2.
 */
@Component
public class FacebookPublishTask {
    @Autowired
    private GoogleShortener shortener;
    @Autowired
    private FacebookUtil facebookUtil;
    @Autowired
    private IGoodsListService goodsListService;

    @Value("${project.host}")
    private String host;

    //每小时发布一条page
    @Scheduled(cron = "0 0 0 * * ?")
    public void publishPhoto(){
        List<GoodsList> list = goodsListService.getRandGoods(1,10);
        if(list.size()>0){
            GoodsList gl = list.get(0);
            String shortUrl = shortener.shorten(host+"/detail/"+gl.getId());
            facebookUtil.sharePhoto(gl.getSmallImageUrl(),gl.getTitle()+"<br/>Link Url:"+shortUrl);
        }
    }

    public static void main(String[] args) throws Exception {


    }
}
