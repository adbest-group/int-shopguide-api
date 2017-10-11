package com.bt.shopguide.dao.service;

import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.entity.GoodsListWithHtml;
import com.bt.shopguide.dao.vo.PageDataVo;

/**
 * Created by caiting on 2017/9/26.
 */

public interface IGoodsListService {
    public int save(GoodsList glist);
    public void selectGoodsListPage(PageDataVo<GoodsList> vo);
    public GoodsListWithHtml selectGoodDetailByGoodsId(Long id);
}
