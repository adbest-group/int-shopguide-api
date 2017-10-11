package com.bt.shopguide.dao.service.imp;

import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.entity.GoodsListWithHtml;
import com.bt.shopguide.dao.mapper.GoodsListMapper;
import com.bt.shopguide.dao.service.IGoodsListService;
import com.bt.shopguide.dao.vo.PageDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiting on 2017/9/26.
 */
@Service
public class GoodsListService implements IGoodsListService {
    @Autowired
    private GoodsListMapper glMapper;

    @Override
    public int save(GoodsList glist) {
        return glMapper.insert(glist);
    }

    @Override
    public void selectGoodsListPage(PageDataVo<GoodsList> vo) {
        int totalCount = glMapper.getTotalCount(vo.getConditionMap());
        if(totalCount > 0){
            Map<String,Object> params = new HashMap<String,Object>();
            for(Map.Entry<String, Object> entry:vo.getConditionMap().entrySet()){
                params.put(entry.getKey(), entry.getValue());
            }
            params.put("startIndex", (vo.getPageIndex()-1)*vo.getPageSize());
            params.put("pageSize", vo.getPageSize());
            vo.setData(glMapper.selectPage(params));
            vo.setTotalCount(totalCount);
        }
    }

    @Override
    public GoodsListWithHtml selectGoodDetailByGoodsId(Long id) {
        return glMapper.selectGoodDetailByGoodsId(id);
    }
}
