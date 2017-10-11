package com.bt.shopguide.dao.mapper;

import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.entity.GoodsListWithHtml;

import java.util.List;
import java.util.Map;

public interface GoodsListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_LIST
     *
     * @mbggenerated Tue Sep 26 09:43:22 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_LIST
     *
     * @mbggenerated Tue Sep 26 09:43:22 CST 2017
     */
    int insert(GoodsList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_LIST
     *
     * @mbggenerated Tue Sep 26 09:43:22 CST 2017
     */
    int insertSelective(GoodsList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_LIST
     *
     * @mbggenerated Tue Sep 26 09:43:22 CST 2017
     */
    GoodsList selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_LIST
     *
     * @mbggenerated Tue Sep 26 09:43:22 CST 2017
     */
    int updateByPrimaryKeySelective(GoodsList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_LIST
     *
     * @mbggenerated Tue Sep 26 09:43:22 CST 2017
     */
    int updateByPrimaryKey(GoodsList record);

    List<GoodsList> selectPage(Map map);
    int getTotalCount(Map map);
    GoodsListWithHtml selectGoodDetailByGoodsId(Long id);
}