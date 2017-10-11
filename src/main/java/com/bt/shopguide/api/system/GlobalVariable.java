package com.bt.shopguide.api.system;

import com.bt.shopguide.dao.entity.Category;
import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.entity.Hotword;
import com.bt.shopguide.dao.entity.Malls;
import com.bt.shopguide.dao.service.ICategoryService;
import com.bt.shopguide.dao.service.IGoodsListService;
import com.bt.shopguide.dao.service.IHotwordService;
import com.bt.shopguide.dao.service.IMallsService;
import com.bt.shopguide.dao.vo.PageDataVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.te.CalendarData_te_IN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caiting on 2017/9/28.
 */
@Service
public class GlobalVariable {
    Logger logger = LoggerFactory.getLogger(GlobalVariable.class);

    @Autowired
    private IMallsService mallsService;
    @Autowired
    private IHotwordService hotwordService;
    @Autowired
    private IGoodsListService goodsListService;
    @Autowired
    private ICategoryService categoryService;
    //所有商城列表
    public static List<Malls> malls = new ArrayList<>();
    //top10商品
    public static List<GoodsList> goods_list_top10 = new ArrayList<>();
    //热词列表
    public static List<Hotword> hotwords = new ArrayList<>();
    //分类列表
    public static List<Category> categorys = new ArrayList<>();

    public void init(){
        logger.info("初始化全局变量开始！~~~~~~~~~~~~~~~");

        malls = mallsService.getAllMalls();

        hotwords = hotwordService.getTop5();

        PageDataVo<GoodsList> vo = new PageDataVo<>();
        vo.setPageSize(10);
        goodsListService.selectGoodsListPage(vo);
        goods_list_top10 = vo.getData();

        categorys = categoryService.getTopN(10);


        logger.info("初始化全局变量完成！~~~~~~~~~~~~~~~");
    }
}
