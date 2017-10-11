package com.bt.shopguide.api.controller.jsonp;

import com.bt.shopguide.api.system.GlobalVariable;
import com.bt.shopguide.api.vo.GoodDetailVo;
import com.bt.shopguide.api.vo.JsonResult;
import com.bt.shopguide.api.vo.JsonResultArray;
import com.bt.shopguide.api.vo.JsonResultArrayWithPage;
import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.entity.GoodsListWithHtml;
import com.bt.shopguide.dao.service.IGoodsListService;
import com.bt.shopguide.dao.vo.PageDataVo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by caiting on 2017/9/29.
 */
@RestController
public class GoodsController {

    @Value("${page.pageSize}")
    private int pageSize = 20;
    @Value("${project.charset}")
    private String charset;

    @Autowired
    IGoodsListService goodsListService;

    /**
     *商品列表
     **/
    @ResponseBody
    @RequestMapping(value = "/goods")
    public JsonResult getGoodsList(@RequestParam(value = "page",defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "mall",required = false) String mallName,
                                   @RequestParam(value = "category",required = false) String category){
        JsonResult result = new JsonResult();
        JsonResultArrayWithPage jrap = new JsonResultArrayWithPage();

        //组装分页组件
        PageDataVo<GoodsList> vo = new PageDataVo<>();
        vo.setPageIndex(pageIndex);
        vo.setPageSize(pageSize);
        Map<String,Object> condition = Maps.newHashMap();
        if(mallName!=null) condition.put("mallName",mallName);
        if(category!=null) condition.put("category",category);
        vo.setConditionMap(condition);
        goodsListService.selectGoodsListPage(vo);

        //获取分页数据
        jrap.setPageIndex(pageIndex);
        jrap.setPageSize(pageSize);
        jrap.setTotalCount(vo.getTotalCount());
        jrap.setList(vo.getData());

        result.setResult(jrap);
        return result;
    }

    /**
     *搜索商品列表
     **/
    @ResponseBody
    @RequestMapping(value = "/search")
    public JsonResult getGoodsList(@RequestParam(value = "page",defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "key",required = false) String keyword){
        JsonResult result = new JsonResult();
        JsonResultArrayWithPage jrap = new JsonResultArrayWithPage();

        //组装分页组件
        PageDataVo<GoodsList> vo = new PageDataVo<>();
        vo.setPageIndex(pageIndex);
        vo.setPageSize(pageSize);
        Map<String,Object> condition = Maps.newHashMap();
        if(keyword!=null) condition.put("keyword",keyword);
        vo.setConditionMap(condition);
        goodsListService.selectGoodsListPage(vo);

        //获取分页数据
        jrap.setPageIndex(pageIndex);
        jrap.setPageSize(pageSize);
        jrap.setTotalCount(vo.getTotalCount());
        jrap.setList(vo.getData());

        result.setResult(jrap);
        return result;
    }

    /**
     *top10商品列表
     **/
    @ResponseBody
    @RequestMapping(value = "/hotgoods")
    public JsonResult getGoodsTop10(){
        JsonResult result = new JsonResult();
        JsonResultArray jrap = new JsonResultArray();
        jrap.setList(GlobalVariable.goods_list_top10);
        result.setResult(jrap);
        return result;
    }

    @ResponseBody
    @RequestMapping("/goodsdetail")
    public JsonResult getGoodDetail(@RequestParam(value = "id",required = false) Long id){
        JsonResult result = new JsonResult();
        if(id==null){
            result.setCode(-1);
            result.setMsg("paramter id is necessary!");
        }else{
            try {
                GoodsListWithHtml good = goodsListService.selectGoodDetailByGoodsId(id);
                result.setResult(new GoodDetailVo(good,charset));
            }catch(Exception e){
                result.setCode(-1);
                result.setMsg("query faild!");
            }
        }
        return result;
    }
}
