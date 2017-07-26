package com.summer.service.demo.dao;

import com.summer.service.demo.bean.BasePage;
import com.summer.service.demo.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxz on 2017/7/12.
 */

@Repository("testDbConnDao")
public interface TestDbConnDao extends BaseDao{

    int testDBConn();
    Goods getGoodsById(Map<String, Object> map);
    int addGoods(Goods goods);
    List<Goods> getGoodsList(BasePage basePage);
    int addInventory(@Param("goodsId") int goodsId, @Param("inventory") int inventory);
    int deleteGoods(Goods goods);
}
