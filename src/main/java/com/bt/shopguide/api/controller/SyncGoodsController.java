package com.bt.shopguide.api.controller;

import com.bt.shopguide.api.vo.JsonResult;
import com.bt.shopguide.dao.entity.Coupon;
import com.bt.shopguide.dao.entity.GoodsDetail;
import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.entity.GoodsListWithHtml;
import com.bt.shopguide.dao.service.ICouponService;
import com.bt.shopguide.dao.service.IGoodsDetailService;
import com.bt.shopguide.dao.service.IGoodsListService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

/**
 * Created by caiting on 2017/10/11.
 */
@Controller
@RequestMapping(value = "/sync")
public class SyncGoodsController {
    private Logger logger = Logger.getLogger(SyncGoodsController.class);

    @Autowired
    IGoodsDetailService goodsDetailService;
    @Autowired
    IGoodsListService goodsListService;
    @Autowired
    ICouponService couponService;

    @ResponseBody
    @RequestMapping(value = "goods")
    public JsonResult syncGoods(@RequestParam(value = "json",required = false) String goodsJson){
        JsonResult jsonResult = new JsonResult();
        if(goodsJson==null){
            jsonResult.setCode(-1);
            jsonResult.setMsg("not enougth param!");
            return jsonResult;
        }
        Gson gson = new Gson();
        List<GoodsListWithHtml> goods;
        Type type = new TypeToken<List<GoodsListWithHtml>>() {}.getType();
        try {
            goods = gson.fromJson(goodsJson,type);
        }catch(Exception e){
            jsonResult.setCode(-1);
            jsonResult.setMsg("parse error");
            return jsonResult;
        }
        for(GoodsListWithHtml goodHtml : goods){
            GoodsList glist = new GoodsList();
            GoodsDetail gdetail = new GoodsDetail();

            glist.setTitle(goodHtml.getTitle());
            glist.setSmallImageUrl(goodHtml.getSmallImageUrl());
            glist.setPrice(goodHtml.getPrice());
            glist.setOriginalPrice(goodHtml.getOriginalPrice());
            glist.setDiscounts(goodHtml.getDiscounts());
            glist.setCoupons(goodHtml.getCoupons());
            glist.setPromoCode(goodHtml.getPromoCode());
            glist.setCategory(goodHtml.getCategory());
            glist.setMallName(goodHtml.getMallName());
            glist.setGoodSourceName(goodHtml.getGoodSourceName());
            glist.setShortContent(goodHtml.getShortContent());
            glist.setUrl(goodHtml.getUrl());
            //产生随机点击数0-10
            //glist.setThumbs(goodHtml.getThumbs());
            glist.setThumbs((int)Math.ceil(Math.random()*10));
            glist.setPublish(goodHtml.getPublish());
            glist.setSyncTime(goodHtml.getSyncTime());
            glist.setCreateTime(goodHtml.getCreateTime());
            try{
                goodsListService.save(glist);
                try{
                    gdetail.setGoodsId(glist.getId());
                    gdetail.setContentHtml(goodHtml.getContentHtml());
                    gdetail.setCreateTime(goodHtml.getCreateTime());
                    goodsDetailService.save(gdetail);
                }catch(Exception e){
                    logger.error("save goods_detail faild!original goods_id is["+goodHtml.getId()+"]");
                    continue;
                }
            }catch(Exception e){
                logger.error("save goods_list faild!original id is["+goodHtml.getId()+"]");
                continue;
            }
        }
        return  jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "coupons")
    public JsonResult syncCoupons(@RequestParam(value = "json",required = false) String couponsJson){
        JsonResult jsonResult = new JsonResult();
        if(couponsJson==null){
            jsonResult.setCode(-1);
            jsonResult.setMsg("not enougth param!");
            return jsonResult;
        }
        Gson gson = new Gson();
        List<Coupon> coupons;
        Type type = new TypeToken<List<Coupon>>() {}.getType();
        try {
            coupons = gson.fromJson(couponsJson,type);
        }catch(Exception e){
            jsonResult.setCode(-1);
            jsonResult.setMsg("parse error");
            return jsonResult;
        }
        for(Coupon coupon : coupons){
            try{
                couponService.save(coupon);

            }catch(Exception e){
                logger.error("save coupon faild!original id is["+coupon.getId()+"]");
                continue;
            }
        }
        return  jsonResult;
    }
}
